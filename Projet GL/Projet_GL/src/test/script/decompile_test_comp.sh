#! /bin/sh

# Auteur : Louis
# Version initiale : 01/01/2023

# Test minimaliste de la syntaxe.
# On lance test_synt sur un fichier valide, et les tests invalides.

# dans le cas du fichier valide, on teste seulement qu'il n'y a pas eu
# d'erreur. Il faudrait tester que l'arbre donné est bien le bon. Par
# exemple, en stoquant la valeur attendue quelque part, et en
# utilisant la commande unix "diff".
#
# Il faudrait aussi lancer ces tests sur tous les fichiers deca
# automatiquement. Un exemple d'automatisation est donné avec une
# boucle for sur les tests invalides, il faut aller encore plus loin.

cd "$(dirname "$0")"/../../.. || exit 1

PATH=./src/test/script/launchers:"$PATH"


for test in src/test/deca/context/valid/increment1/*.deca
do
    test_decompile "$test" > "${test%.deca}"decompile.deca
    test_decompile "${test%.deca}"decompile.deca > "${test%.deca}"decompile_decompile.deca
    if ! diff "${test%.deca}"decompile.deca "${test%.deca}"decompile_decompile.deca
    then
        echo "Failed : La décompilation a créé 2 documents différents."
    else 
        echo "Succes : La décompilation a créé 2 documents identiques."
    fi
done

for test in src/test/deca/context/valid/increment1/*.deca
do
    rm "${test%.deca}"decompile.deca
    rm "${test%.deca}"decompile_decompile.deca
done


        
    