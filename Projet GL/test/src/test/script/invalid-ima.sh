Red='\033[0;31m'          # Red
Green='\033[0;32m'        # Green
NC='\033[0m'
e='-e'
passed=1
nb_tests=0
nb_passed=0
nb_failed=0

cd "$(dirname "$0")"/../../.. || exit 1

PATH=./src/test/script/launchers:./src/main/bin:"$PATH"


for test in src/test/deca/codegen/invalid/created/ima/*.ass
do
    rm -f "$test" 2>/dev/null
done

for test in src/test/deca/codegen/invalid/created/ima/*.deca
do
    decac "$test" || exit 1
    if [ ! -f "${test%.deca}".ass ]; then
        echo "Fichier .ass non généré."
        exit 1
    fi
done

ima_invalid () {
    # $1 = premier argument.
    ima "$1" > "${1%.ass}".res
    if ima "$1" 2>&1 | \
        grep -q -e "Error"
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

echo "Testing invalid tests for part C"
    for cas_de_test in src/test/deca/codegen/invalid/created/ima/*.ass
    do
        nb_tests=$((nb_tests+1))
        ima_invalid "$cas_de_test" 2>/dev/null
    done
        if [ $passed -eq 1 ] #j'ai remplacé = par -eq et j'ai rajouté les crochets
        then 
            echo ${e} "Invalid tests part C: ${Green}PASSED${NC}"
        else
            echo 
            echo ${e} "Invalid test part C : ${Red}FAILED${NC}"
            echo ${e} "${Green}PASSED${NC} : $nb_passed/$nb_tests"
            echo ${e} "${Red}FAILED${NC} : $nb_failed/$nb_tests"
        fi
