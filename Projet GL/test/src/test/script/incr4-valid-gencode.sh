Red='\033[0;31m'          # Red
Green='\033[0;32m'        # Green
NC='\033[0m'
e= '-e'

cd "$(dirname "$0")"/../../.. || exit 1

PATH=./src/test/script/launchers:./src/main/bin:"$PATH"


for test in src/test/deca/codegen/valid/created/incr4/*.ass
do
    rm -f "$test" 2>/dev/null
done

for test in src/test/deca/codegen/valid/created/incr4/*.deca
do
    decac "$test" || exit 1
    if [ ! -f "${test%.deca}".ass ]; then
        echo "Fichier .ass non généré."
        exit 1
    fi
done






for test in src/test/deca/codegen/valid/created/incr4/*.ass
do
    echo "Test : ima "$test ""
    # ima "$test" || exit 1
    resultat=$(ima "$test")
    #attendu=$(sed -n "$n"p src/test/script/incr2-valid-gencode-expected.txt)
    attendu=$(echo $(head -n 1 "${test%.ass}".deca) | cut -c 3-)
    if [ "$resultat" = "$attendu" ]; then
        echo ${e} "Status : ${Green}PASSED${NC}"
    else
        echo ${e} "Status : ${Red}FAILED${NC}"
        echo "Résultat inattendu de ima:"
        echo "$resultat"
        echo "Attendu: $attendu"
    fi

done
