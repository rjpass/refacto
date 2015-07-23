#!/bin/sh

# usage:	Moves a project to mvn structure, moves code to mvn structure, updates dependencies to mvn structure
# returns:	Nothing
moveProject() {
	local projectName oldProjectLocation newProjectLocation
	projectName=$1
	oldProjectLocation=$2
	newProjectLocation=$3
	projectPath="EFSS/$newProjectLocation/$projectName"
	mkdir -p "$projectPath/src/main/java"
	touch "$projectPath/pom.xml"
	cp -R "EFSS/$oldProjectLocation/$projectName/src/" "$projectPath/src/main/java"
	echo "Moving project $projectName"
	java -cp java/DependencyBuilder/build/classes/ dependencybuilder.DependencyBuilder EFSS/$oldProjectLocation/$projectName EFSS/$newProjectLocation/$projectName $newProjectLocation $projectName
}

updateModule() {
	package=$1
	shift
	modules=""
	while [ "$1" != "" ]; do 
		modules+="$1 "
		shift
	done

	java -cp java/DependencyBuilder/build/classes/ dependencybuilder.ModuleBuilder $package $modules
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
find  * \! -name "EFSS" -maxdepth 0 -exec cp -r {} EFSS \;

echo "\nMigrating projects (base):"
moveProject common UtilitiesAndServices base
moveProject mailbean UtilitiesAndServices base

updateModule base common mailbean