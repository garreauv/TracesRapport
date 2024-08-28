#! /bin/sh

# Auteur : gl19
# Version initiale : 01/01/2023

# Test de tous les fichiers contextuellement valide dans acr

Red='\033[0;31m'          # Red
Green='\033[0;32m'        # Green
NC='\033[0m'
e='-e'
passed=1
nb_tests=0
nb_passed=0
nb_failed=0

cd "$(dirname "$0")"/../../.. || exit 1

PATH=./src/test/script/launchers:"$PATH"


test_context_incr5_invalid () {
    # $1 = premier argument.
    test_context "$1" > "${1%.deca}".res
    if test_context "$1" 2>&1 | \
        grep -q -e ':[0-9][0-9]*:'
    then
        echo ${e} "File name : $(basename $1)"
        content=$(echo $(head -n 1 $1) | cut -c 3-)
        echo ${e} "Testing : $content"
        echo ${e} "Status : ${Green}PASSED${NC}"
        nb_passed=$((nb_passed+1))
    else
        echo ${e} "File name : $(basename $1)"
        content=$(echo $(head -n 1 $1) | cut -c 3-)
        echo ${e} "Testing : $content"
        echo ${e} "Status : ${Red}FAILED${NC}"
        nb_failed=$((nb_failed+1))
        passed=0
    fi
}

echo "Testing invalid tests fifth increment"
    for cas_de_test in src/test/deca/context/invalid/increment5/*.deca
    do
        nb_tests=$((nb_tests+1))
        test_context_incr5_invalid "$cas_de_test" 2>/dev/null
    done
        if [ $passed -eq 1 ] #j'ai remplacé = par -eq et j'ai rajouté les crochets
        then 
            echo ${e} "Invalid tests fifth increment : ${Green}PASSED${NC}"
        else
            echo 
            echo ${e} "Fifth increment : ${Red}FAILED${NC}"
            echo ${e} "${Green}PASSED${NC} : $nb_passed/$nb_tests"
            echo ${e} "${Red}FAILED${NC} : $nb_failed/$nb_tests"
        fi
