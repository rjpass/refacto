#!/bin/sh

projectsLocation=()
projects_base=()
projects_util=()
projects_api=()
projects_protocol=()
projects_product=()

# usage:	Moves a project to mvn structure, moves code to mvn structure, updates dependencies to mvn structure
# returns:	Nothing
moveProject() {
	local projectName oldProjectLocation newProjectLocation alreadyMaven
	projectName=$1
	oldProjectLocation=$2
	newProjectLocation=$3
	alreadyMaven=$4
	projectPath="../efss-maven/$newProjectLocation/$projectName"

	if [ "$alreadyMaven" = "" ]; then
		mkdir -p "$projectPath/src/main/java"
		mkdir -p "$projectPath/src/test/java"
		cp -R "../efss-maven/$oldProjectLocation/$projectName/src/" "$projectPath/src/main/java" 2>/dev/null
		cp -R "../efss-maven/$oldProjectLocation/$projectName/test/" "$projectPath/src/test/java" 2>/dev/null
	else
		mkdir -p "$projectPath"
		cp -R "../efss-maven/$oldProjectLocation/$projectName/src/" "$projectPath/src" 2>/dev/null
	fi

	rsync -aq --exclude='nbproject/' --exclude='build*.xml' --exclude='src/' --exclude='test/' ../efss-maven/$oldProjectLocation/$projectName/* $projectPath
	
	if [ "$alreadyMaven" = "" ]; then
		echo "    Moving project $projectName"
		java -cp java/DependencyBuilder/build/classes/ dependencybuilder.DependencyBuilder ../efss-maven/$oldProjectLocation/$projectName ../efss-maven/$newProjectLocation/$projectName $newProjectLocation $projectName
	else
		echo "    Moving project $projectName (already Mavenized)"
		java -cp java/DependencyBuilder/build/classes/ dependencybuilder.MavenHacker ../efss-maven/$newProjectLocation/$projectName ../efss-maven/$oldProjectLocation/$projectName/pom.xml $newProjectLocation $projectName
	fi

	projectsLocation+=("$newProjectLocation/$projectName")
	
	if [ "$newProjectLocation" = "base" ]; then
		projects_base+=("$projectName")
	elif [ "$newProjectLocation" = "util" ]; then
		projects_util+=("$projectName")
	elif [ "$newProjectLocation" = "api" ]; then
		projects_api+=("$projectName")
	elif [ "$newProjectLocation" = "protocol" ]; then
		projects_protocol+=("$projectName")
	elif [ "$newProjectLocation" = "product" ]; then
		projects_product+=("$projectName")
	fi
}

# usage:	Updates a 'modules' POM for all of the passed in projects.  Syntax $1=module name, $2-x=projects
# returns:	Nothing
updateModule() {
	package=$1
	shift
	modules=""
	while [ "$1" != "" ]; do 
		modules+="$1 "
		shift
	done

	echo "Update $package module POM"
	java -cp java/DependencyBuilder/build/classes/ dependencybuilder.ModuleBuilder $package $modules
}

# usage:	Diffs a jar created with mvn with the one from lib hydrator
# returns: 	0 = same, 1 = different
doDiff() {
	cd ~/code/refacto
	mkdir temp1
	cd temp1
	jar xf ../../efss-maven/$1/$2/target/com.cleo.$1.$2-5.2.1-SNAPSHOT.jar > /dev/null 2>&1
	rm -rf META-INF/

	cd ..
	mkdir temp2
	cd temp2
	jar xf ~/VersaLex/lib/$2.jar > /dev/null 2>&1
	rm -rf META-INF/

	#hack the 8th byte of the class file to avoid source discrepencies
	#see class layout at https://en.wikipedia.org/wiki/Java_class_file#General_layout
	find . -name \*.class -execdir sh -c "echo {}; printf '\x33' | dd of={} bs=1 seek=7 conv=notrunc" \; > /dev/null 2>&1

	diff -r ../temp1/ . > /dev/null 2>&1
	retVal=$?

	cd ..
	rm -rf temp1
	rm -rf temp2

	echo $retVal
}

## Main Script ##
echo "Refacto(r) the Github repo\n"

#clear the EFSS repo and redownload
clear=""

#update the EFSS repo -- don't redownload
update=""

#migrate the projects
migrate=""

#build the repo once converted
build=""

#diff the jars after conversion
dif=""

while [ "$1" != "" ]; do 
	case $1 in
		-c | --clear )		clear="true"
							;;
		-u | --update )		update="true"
							;;
		-m | --migrate )	migrate="true"
							;;
		-b | --build )		build="true"
							;;
		-d | --diff )		dif="true"
							;;
	esac
	shift
done

echo "Downloading the EFSS repo\n"
if [ ! -d "../efss-maven" ] || [ "$clear" = "true" ]; then
	rm -rf "../efss-maven"
	git clone git@github.com:CleoDev/EFSS.git ../efss-maven
elif [ "$update" == "" ]; then
	echo "EFSS repo already exists (efss-maven).  Run -c to delete and re-download, or -u to run update on existing EFSS repo"
	exit 
fi

if [ "$migrate" = "true" ]; then	
	echo "\nMigrating new project structure into EFSS (efss-maven) repo\n"
	#find  * \! -name "EFSS" -maxdepth 0 -exec cp -r {} EFSS \;
	rsync -a --exclude='EFSS/' --exclude='java/' --exclude='refacto.sh' new-structure/* ../efss-maven

	projects_protocol+=("megacol")

	###questions
	# FeedOutboxes
	# LoopTestFileDiff
	# VersaLexWS
	# AppletIntegrationWebProject
	# MQLoopback
	# updnd
	# PortConnector
	# 

	echo "\nMigrating projects (base):"
	moveProject XMLLogger UtilitiesAndServices base
	moveProject common UtilitiesAndServices base
	moveProject aspirin ThirdParty base
	#moveProject mailbean UtilitiesAndServices base 	this is where it should go
	moveProject VLMetrics UtilitiesAndServices base
	moveProject vlembeddeddb UtilitiesAndServices base
	moveProject dnsjava ThirdParty base
	#moveProject CLJRDeploy UtilitiesAndServices base
	moveProject vaadin-recaptcha UtilitiesAndServices base
	moveProject Jcapi ThirdParty base
	moveProject jcifs-1.3.14 ThirdParty/Jcifs base		#this one is a little weird -- look into it
	#moveProject jtnef ThirdParty base
	moveProject confdecrypt UtilitiesAndServices base
	moveProject base64 UtilitiesAndServices base

	updateModule base ${projects_base[*]}

	echo "\nMigrating projects (util):"
	moveProject CertManager UtilitiesAndServices util
	moveProject WebServer Servers util 
	moveProject SmtpServer Servers util 
	moveProject FtpServer Servers util 
	moveProject SftpServer Servers util 
	#moveProject updnd UtilitiesAndServices util 
	moveProject snmpagent UtilitiesAndServices util 
	#moveProject j2ssh ThirdParty util 
	moveProject hsp-api UtilitiesAndServices util alreadyMaven
	#moveProject HTTPClient ThirdParty util 				# this has a circ dep with LexiCom	

	updateModule util ${projects_util[*]}

	echo "\nMigrating projects (api):"
	moveProject LexAPI_POJO UtilitiesAndServices api alreadyMaven
	moveProject LexAPI UtilitiesAndServices api 
	moveProject lexbean ProtocolBeans api 
	moveProject mailbean UtilitiesAndServices api
	moveProject lexhelp UtilitiesAndServices api alreadyMaven
	moveProject cleouribitspeed UtilitiesAndServices/URISchemes api 
	moveProject cleourivlpipe UtilitiesAndServices/URISchemes api 
	moveProject cleourijms UtilitiesAndServices/URISchemes api 
	moveProject cleourimsmq UtilitiesAndServices/URISchemes api 

	updateModule api ${projects_api[*]}

	echo "\nMigrating projects (protocol):"
	moveProject as2bean ProtocolBeans protocol
	moveProject dcebmxhttpsbean ProtocolBeans protocol
	moveProject ebicsbean ProtocolBeans protocol
	moveProject ebxmlbean ProtocolBeans protocol
	moveProject faspbean ProtocolBeans protocol
	moveProject ftpbean ProtocolBeans protocol
	moveProject ftpsbean ProtocolBeans protocol
	moveProject hspbean ProtocolBeans protocol alreadyMaven
	moveProject httpbean ProtocolBeans protocol
	moveProject httpsbean ProtocolBeans protocol
	moveProject mllpbean ProtocolBeans protocol
	moveProject mqbean ProtocolBeans protocol
	moveProject oftpbean ProtocolBeans protocol
	moveProject rosettabean ProtocolBeans protocol
	moveProject smtpbean ProtocolBeans protocol
	moveProject smtpsbean ProtocolBeans protocol
	moveProject sshftpbean ProtocolBeans protocol
	moveProject streembean ProtocolBeans protocol
	moveProject wsbean ProtocolBeans protocol

	updateModule protocol ${projects_protocol[*]}

	echo "\nMigrating projects (product):"
	moveProject LexiCom . product 
	#moveProject VLTrader . product
	#moveProject Harmony . product
	#moveProject VLProxy . product 

	updateModule product ${projects_product[*]}
fi

if [ "$build" = "true" ]; then
	echo "\nBuilding"
	cd ../efss-maven
	mvn -DskipTests -l ../refacto/mvn.log				# tests can't build
	#mvn -l ../mvn.log
	mvnStatus=$?
	if [ $mvnStatus = 0 ]; then
		echo "    MVN Build Successful"
	else
		echo "    ------MVN Build FAILED------"
	fi
fi

cd ../refacto

if [ "$dif" = "true" ] && [ $mvnStatus = 0 ]; then
	echo "\nDiffing jars"
	cd ~/code/efss-maven/meta
	mvn -Plinux > /dev/null 2>&1
	cd ~/code/refacto
	for i in "${projects_base[@]}"
	do
		printf "Diffing $i... "
		result=$(doDiff base $i)
		if [ "$result" != "0" ]; then
			printf "not the same!  ***********\n"
		else
			printf "validated\n"
		fi
	done
fi
# echo "\nCleaning up old directories"

