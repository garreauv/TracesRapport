#! /bin/sh

cd "$(dirname "$0")"/../../.. || exit 1

PATH=./src/test/script/launchers:./src/main/bin:"$PATH"

# execution des scripts

rm -f ./src/test/deca/codegen/valid/created/float.ass 2>/dev/null
decac ./src/test/deca/codegen/valid/created/float.deca || exit 1

if [ ! -f ./src/test/deca/codegen/valid/created/float.ass ]; then
    echo "Fichier float.ass non généré."
    exit 1
fi

resultat=$(ima ./src/test/deca/codegen/valid/created/float.ass) || exit 1
rm -f ./src/test/deca/codegen/valid/created/float.ass

# On code en dur la valeur attendue.
attendu=3.2

if [ "$resultat" = "$attendu" ]; then
    echo "Tout va bien"
else
    echo "Résultat inattendu de ima pour le test float:"
    echo "$resultat"
fi

#execution du deuxième script

rm -f ./src/test/deca/codegen/valid/created/int.ass 2>/dev/null
decac ./src/test/deca/codegen/valid/created/int.deca || exit 1

if [ ! -f ./src/test/deca/codegen/valid/created/int.ass ]; then
    echo "Fichier int.ass non généré."
    exit 1
fi

attendu=3;

if [ "$resultat" = "$attendu" ]; then
    echo "Tout va bien"
else
    echo "Résultat inattendu de ima pour le test int:"
    echo "$resultat"
fi

