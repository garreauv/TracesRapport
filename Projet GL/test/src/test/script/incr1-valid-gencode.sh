Red='\033[0;31m'          # Red
Green='\033[0;32m'        # Green
NC='\033[0m'
e='-e'

cd "$(dirname "$0")"/../../.. || exit 1

PATH=./src/test/script/launchers:./src/main/bin:"$PATH"


for test in src/test/deca/codegen/valid/created/incr1/*.ass
do
    rm -f "$test" 2>/dev/null
done

for test in src/test/deca/codegen/valid/created/incr1/*.deca
do
    decac "$test" || exit 1
    if [ ! -f "${test%.deca}".ass ]; then
        echo "Fichier .ass non généré."
        exit 1
    fi
done



n=1

for test in src/test/deca/codegen/valid/created/incr1/*.ass
do
    echo "Test : ima "$test ""
    # ima "$test" || exit 1
    resultat=$(ima "$test") || exit 1
    attendu=$(sed -n "$n"p src/test/script/incr1-valid-gencode-expected.txt)
    if [ $n -eq 4 ]
    then
        attendu=$(sed -n 4,5p src/test/script/incr1-valid-gencode-expected.txt)
        n=$(( n + 1 ))
    fi
    if [ "$resultat" = "$attendu" ]; then
        echo ${e} "Status : ${Green}PASSED${NC}"
    else
        echo ${e} "Status : ${Red}FAILED${NC}"
        echo "Résultat inattendu de ima:"
        echo "$resultat"
        echo "Attendu: $attendu"
    fi
    n=$(( n + 1 ))

done


