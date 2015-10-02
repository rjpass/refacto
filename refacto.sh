#!/bin/sh

projectsOldLocation=()
projectsLocation=()
projects_base=()
projects_util=()
projects_api=()
projects_protocol=()
projects_product=()

# usage:	Moves a project to mvn structure, moves code to mvn structure, updates dependencies to mvn structure
# returns:	Nothing
moveProject() {
	local projectName oldProjectLocation newProjectLocation special
	projectName=$1
	oldProjectLocation=$2
	newProjectLocation=$3
	special=$4
	projectPath="../efss-maven/$newProjectLocation/$projectName"

	if [ "$projectName" = "snmpagent" ]; then
		projectPath="../efss-maven/$newProjectLocation/vlsnmpagent"
	elif [ "$projectName" = "TestServer" ]; then
		projectPath="../efss-maven/$newProjectLocation/UnifyTestServer"
	fi 

	if [ "$special" = "" ]; then
		mkdir -p "$projectPath/src/main/java"
		mkdir -p "$projectPath/src/test/java"
		cp -R "../efss-maven/$oldProjectLocation/$projectName/src/" "$projectPath/src/main/java" 2>/dev/null
		cp -R "../efss-maven/$oldProjectLocation/$projectName/test/" "$projectPath/src/test/java" 2>/dev/null
	elif [ "$special" = "httpClient" ]; then
		mkdir -p "$projectPath/src/main/java"
		mkdir -p "$projectPath/src/test/java"
		cp -R "../efss-maven/$oldProjectLocation/$projectName/jbproject/" "$projectPath/src/main/java" 2>/dev/null
	else  #this is a maven project already
		mkdir -p "$projectPath"
		cp -R "../efss-maven/$oldProjectLocation/$projectName/src/" "$projectPath/src" 2>/dev/null
	fi

	rsync -aq --exclude='nbproject/' --exclude='build*.xml' --exclude='src/' --exclude='test/' --exclude='jbproject/' ../efss-maven/$oldProjectLocation/$projectName/* $projectPath
	
	if [ "$special" != "alreadyMaven" ]; then
		echo "    Moving project $projectName"
		if [ "$projectName" = "snmpagent" ]; then
			java -cp java/DependencyBuilder/build/classes/ dependencybuilder.DependencyBuilder ../efss-maven/$oldProjectLocation/$projectName $projectPath $newProjectLocation "vlsnmpagent"
		else
			java -cp java/DependencyBuilder/build/classes/ dependencybuilder.DependencyBuilder ../efss-maven/$oldProjectLocation/$projectName $projectPath $newProjectLocation $projectName
		fi
	else
		echo "    Moving project $projectName (already Mavenized)"
		java -cp java/DependencyBuilder/build/classes/ dependencybuilder.MavenHacker ../efss-maven/$newProjectLocation/$projectName ../efss-maven/$oldProjectLocation/$projectName/pom.xml $newProjectLocation $projectName
	fi

	if [ "$projectName" = "snmpagent" ]; then
		projectName="vlsnmpagent"
	fi 

	projectsOldLocation+=("$oldProjectLocation/$projectName")
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
		if [ "$projectName" != "TestServer" ]; then
			projects_product+=("$projectName")
		fi
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

# dnsjava -- can't find it
# confdecrypt -- can't find it
# jcifs* -- problem building
# base64 -- can't find it
# 


doDiff() {
	cd ~/code/refacto
	mkdir temp1
	cd temp1
	jar xf ../../efss-maven/$1/$2/target/com.cleo.$1.$2-5.2.2-SNAPSHOT.jar > /dev/null 2>&1
	rm -rf META-INF/

	jarPath=~/VersaLex/lib/$2

	if [ "$2" = "vaadin-recaptcha" ]; then
		jarPath=~/VersaLex/lib/vaadin/$2
	elif [ "$2" = "DocumentSearchDBClient" ]; then
		jarPath=~/VersaLex/lib/docdb/$2
	elif [ "$2" = "ftpbean" ]; then
		jarPath=~/VersaLex/lib/ftp
	elif [ "$2" = "ftpsbean" ]; then
		jarPath=~/VersaLex/lib/ftps
	elif [ "$2" = "SecureShare_POJO" ]; then
		jarPath=~/VersaLex/lib/secureshare/$2
	elif [ "$2" = "SecureShare_API" ]; then
		jarPath=~/VersaLex/lib/secureshare/$2
	elif [ "$2" = "SecureShare_NoSQL" ]; then
		jarPath=~/VersaLex/lib/secureshare/$2
	elif [ "$2" = "SecureShare_Data" ]; then
		jarPath=~/VersaLex/lib/secureshare/$2
	elif [ "$2" = "SecureShare_m9_API" ]; then
		jarPath=~/VersaLex/lib/secureshare/$2
	elif [ "$2" = "SecureShare_Util" ]; then
		jarPath=~/VersaLex/lib/secureshare/$2
	elif [ "$2" = "SecureShare_WebServices" ]; then
		jarPath=~/VersaLex/lib/secureshare/$2
	fi

	cd ..
	mkdir temp2
	cd temp2
	jar xf $jarPath.jar > /dev/null 2>&1
	rm -rf META-INF/

	#hack the 8th byte of the class file to avoid source discrepencies
	#see class layout at https://en.wikipedia.org/wiki/Java_class_file#General_layout
	find . -name \*.class -execdir sh -c "echo {}; printf '\x33' | dd of={} bs=1 seek=7 conv=notrunc" \; > /dev/null 2>&1

	diff -r ../temp1/ . | grep "^Only" > /dev/null 2>&1
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

#destroy the old folders
destroy=""

mvnStatus=0

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
		--destroy )			destroy="true"
							;;
	esac
	shift
done

if [ ! -d "../efss-maven" ] || [ "$clear" = "true" ]; then
	echo "Downloading the EFSS repo\n"
	rm -rf "../efss-maven"
	git clone git@github.com:CleoDev/EFSS.git ../efss-maven
	cd ../efss-maven
	#git checkout circular-dependencies
	git checkout circular-dependencies
	cd -
fi 

if [ "$migrate" = "true" ]; then	
	echo "\nMigrating new project structure into EFSS (efss-maven) repo\n"
	#find  * \! -name "EFSS" -maxdepth 0 -exec cp -r {} EFSS \;
	rsync -a --exclude='EFSS/' --exclude='java/' --exclude='refacto.sh' new-structure/* ../efss-maven

	#projects_protocol+=("megacol")
	projects_api+=("megacol")

	###questions
	# CLJRDeploy - the deps for this project don't exist in nexus, we don't build it in nexus... used for JReports installer?
	# LoopTestFileDiff  - the deps take in lexicom -- do we need this?
	# MQLoopback
	# updnd
	# PortConnector
	# Look at the directories left (ex; UtilitiesAndServices has projects)
	#
	# NOTE
	# ----------------------
	# snmpagent created a jar called vlsnmpagent
	# Renamed ftp and ftps jars to ftpbean and ftpsbean
	# 
	# Circular Dependencies
	# ----------------------
	# SftpServer depends on lexbean
	

	#remove old reqs and rebuild as projects are added
	rm cleo.prop 
	touch cleo.prop

	echo "\nMigrating projects (base):"
	moveProject XMLLogger UtilitiesAndServices base
	moveProject common UtilitiesAndServices base
	moveProject aspirin ThirdParty base
	#moveProject mailbean UtilitiesAndServices base   this is where it should go	
	moveProject VLMetrics UtilitiesAndServices base
	moveProject snmpagent UtilitiesAndServices base 
	moveProject vlembeddeddb UtilitiesAndServices base
	moveProject dnsjava ThirdParty base
	moveProject vaadin-recaptcha UtilitiesAndServices base
	moveProject Jcapi ThirdParty base
	moveProject jcifs-1.3.14 ThirdParty/Jcifs base		#this one is a little weird -- look into it
	moveProject jtnef ThirdParty base
	moveProject confdecrypt UtilitiesAndServices base
	moveProject base64 UtilitiesAndServices base
	moveProject SecureShare_POJO server base alreadyMaven
	moveProject SecureShare_API server base alreadyMaven
	moveProject SecureShare_NoSQL server base alreadyMaven
	moveProject SecureShare_Data server base alreadyMaven
	moveProject DocumentSearchDBClient UtilitiesAndServices base alreadyMaven
	moveProject FeedOutboxes UtilitiesAndServices base
	
	updateModule base ${projects_base[*]}

	echo "\nMigrating projects (util):"
	moveProject HTTPClient ThirdParty util httpClient
	moveProject j2ssh ThirdParty util 
	moveProject LexAPI_POJO UtilitiesAndServices util alreadyMaven
	moveProject CertManager UtilitiesAndServices util
	moveProject WebServer Servers util 
	moveProject SmtpServer Servers util 
	moveProject FtpServer Servers util 
	#moveProject SftpServer Servers util 		this is where it should go
	#moveProject updnd UtilitiesAndServices util 
	moveProject snmpagent UtilitiesAndServices util 
	moveProject hsp-api UtilitiesAndServices util alreadyMaven
	moveProject SecureShare_m9_API server util alreadyMaven
	moveProject SecureShare_Util server util alreadyMaven
	moveProject SecureShare_Builders server util alreadyMaven
	moveProject LexiComLicenser_2 UtilitiesAndServices util alreadyMaven

	updateModule util ${projects_util[*]}

	echo "\nMigrating projects (api):"
	moveProject VLOSGIMgr UtilitiesAndServices api alreadyMaven
	moveProject lexbean ProtocolBeans api 
	moveProject VersaLexWS UtilitiesAndServices api
	moveProject mailbean UtilitiesAndServices api  	#this shouldn't go here
	moveProject lexhelp UtilitiesAndServices api alreadyMaven
	moveProject SecureShare_WebServices server api alreadyMaven
	moveProject SecureShare_MessageMigrator server api alreadyMaven
	
	updateModule api ${projects_api[*]}

	echo "\nMigrating projects (protocol):"
	moveProject as2bean ProtocolBeans protocol
	moveProject dcebmxhttpsbean ProtocolBeans protocol
	moveProject ebicsbean ProtocolBeans protocol
	moveProject ebxmlbean ProtocolBeans protocol
	moveProject faspbean ProtocolBeans protocol
	moveProject ftpbean ProtocolBeans protocol
	moveProject ftpsbean ProtocolBeans protocol
	moveProject httpbean ProtocolBeans protocol
	moveProject httpsbean ProtocolBeans protocol
	moveProject hspbean ProtocolBeans protocol alreadyMaven
	moveProject mllpbean ProtocolBeans protocol
	moveProject mqbean ProtocolBeans protocol
	moveProject oftpbean ProtocolBeans protocol
	moveProject rosettabean ProtocolBeans protocol
	moveProject smtpbean ProtocolBeans protocol
	moveProject smtpsbean ProtocolBeans protocol
	moveProject sshftpbean ProtocolBeans protocol
	moveProject streembean ProtocolBeans protocol
	moveProject wsbean ProtocolBeans protocol

	moveProject cleouribitspeed UtilitiesAndServices/URISchemes protocol 
	moveProject cleourivlpipe UtilitiesAndServices/URISchemes protocol 
	moveProject cleourijms UtilitiesAndServices/URISchemes protocol 
	moveProject cleourimsmq UtilitiesAndServices/URISchemes protocol 
	moveProject UnifyTrustURI UtilitiesAndServices/URISchemes protocol alreadyMaven
	moveProject cleouriwebhdfs UtilitiesAndServices/URISchemes protocol alreadyMaven

	updateModule protocol ${projects_protocol[*]}

	echo "\nMigrating projects (product):"
	moveProject SftpServer Servers product
	moveProject LexiCom . product 
	moveProject VLTrader . product
	moveProject Harmony . product
	moveProject VLProxy . product 

	updateModule product ${projects_product[*]}

	echo "\nMigrating projects (Applications)"
	moveProject TestServer server Applications alreadyMaven
fi

if [ "$build" = "true" ]; then
	echo "\nBuilding"
	cd ../efss-maven
	mvn -DskipTests -l ../refacto/mvn.log				# tests can't build
	#mvn -l ../refacto/mvn.log
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
		result=$(doDiff base $i)
		if [ "$result" != "0" ]; then
			printf "    $i... not the same!\n"
		fi
	done

	for i in "${projects_util[@]}"
	do
		result=$(doDiff util $i)
		if [ "$result" != "0" ]; then
			printf "    $i... not the same!\n"
		fi
	done

	for i in "${projects_api[@]}"
	do
		result=$(doDiff api $i)
		if [ "$result" != "0" ]; then
			printf "    $i... not the same!\n"
		fi
	done

	for i in "${projects_protocol[@]}"
	do
		result=$(doDiff protocol $i)
		if [ "$result" != "0" ]; then
			printf "    $i... not the same!\n"
		fi
	done

	for i in "${projects_product[@]}"
	do
		result=$(doDiff product $i)
		if [ "$result" != "0" ]; then
			printf "    $i... not the same!\n"
		fi
	done
fi

if [ "$destroy" = "true" ] && [ $mvnStatus = 0 ]; then
	echo "\nCleaning up old directories"
	cd ../efss-maven
	for i in "${projectsOldLocation[@]}"
	do
		echo "Removing $i"
		rm -rf $i
	done

	echo "Removing ProtocolBeans folder"
	rm -rf ProtocolBeans

	echo "Removing server folder"
	rm -rf server

	echo "Removing Servers folder"
	rm -rf Servers

	echo "Removing jcifs folder" 
	rm -rf ThirdParty/jcifs 

	echo "Removing snmpagent folder"
	rm -rf UtilitiesAndServices/snmpagent
fi



