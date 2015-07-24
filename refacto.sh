#!/bin/sh

projectsLocation=()
projects=()

# usage:	Moves a project to mvn structure, moves code to mvn structure, updates dependencies to mvn structure
# returns:	Nothing
moveProject() {
	local projectName oldProjectLocation newProjectLocation
	projectName=$1
	oldProjectLocation=$2
	newProjectLocation=$3
	projectPath="EFSS/$newProjectLocation/$projectName"
	mkdir -p "$projectPath/src/main/java"
	mkdir -p "$projectPath/src/test/java"
	cp -R "EFSS/$oldProjectLocation/$projectName/src/" "$projectPath/src/main/java"
	cp -R "EFSS/$oldProjectLocation/$projectName/test/" "$projectPath/src/test/java"
	rsync -aq --exclude='nbproject/' --exclude='build*.xml' --exclude='src/' --exclude='test/' EFSS/$oldProjectLocation/$projectName/* $projectPath
	echo "Moving project $projectName"
	java -cp java/DependencyBuilder/build/classes/ dependencybuilder.DependencyBuilder EFSS/$oldProjectLocation/$projectName EFSS/$newProjectLocation/$projectName $newProjectLocation $projectName

	projectsLocation+=("$newProjectLocation/$projectName")
	projects+=("$projectName")
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
	echo "Diffing EFSS/$1/target/com.cleo.$1.$2-5.2.1-SNAPSHOT.jar ~/VersaLex/$2.jar"
	return diff "EFSS/$1/target/com.cleo.$1.$2-5.2.1-SNAPSHOT.jar" ~/VersaLex/$2.jar > /dev/null 2>&1
	#return $?
}

## Main Script ##
echo "Refacto(r) the Github repo\n\n\n"

#clear the EFSS repo and redownload
clear=""

#update the EFSS repo -- don't redownload
update=""

while [ "$1" != "" ]; do 
	case $1 in
		-c | --clear )		clear="true"
							;;
		-u | --update )		update="true"
							;;
	esac
	shift
done

echo "Downloading the EFSS repo\n"
if [ ! -d "EFSS" ] || [ "$clear" = "true" ]; then
	rm -rf "EFSS"
	git clone git@github.com:CleoDev/EFSS.git
elif [ "$update" == "" ]; then
	echo "EFSS repo already exists.  Run -c to delete and re-download, or -u to run update on existing EFSS repo"
	exit 
fi

echo "\nMigrating new project structure into EFSS repo\n"
#find  * \! -name "EFSS" -maxdepth 0 -exec cp -r {} EFSS \;
rsync -a --exclude='EFSS/' --exclude='java/' --exclude='refacto.sh' . EFSS


echo "\nMigrating projects (base):"
moveProject common UtilitiesAndServices base
moveProject mailbean UtilitiesAndServices base
moveProject VLMetrics UtilitiesAndServices base
moveProject XMLLogger UtilitiesAndServices base
moveProject vlembeddeddb UtilitiesAndServices base
moveProject dnsjava ThirdParty base
moveProject aspirin ThirdParty base
#moveProject CLJRDeploy UtilitiesAndServices base
moveProject vaadin-recaptcha UtilitiesAndServices base
moveProject Jcapi ThirdParty base
moveProject jcifs-1.3.14 ThirdParty/Jcifs base		#this one is a little weird -- look into it
#moveProject jtnef ThirdParty base

updateModule base ${projects[*]}

echo "\nBuilding"
cd EFSS
mvn -DskipTests
cd -

# echo "\nDiffing jars"
# cd EFSS/meta
# mvn -Plinux > /dev/null 2>&1
# cd ../..
# for i in "${projectsLocation[@]}"
# do
# 	result=doDiff $i
# 	if [ result != 0 ]; then
# 		echo "$i is not the same!"
# 	fi
# done

# echo "\nCleaning up old directories"

