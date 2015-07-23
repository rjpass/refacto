#!/bin/sh

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
move * EFSS/