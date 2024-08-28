#! /bin/sh

# Auteur : gl19
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

Green='\033[0;32m'        # Green
Red='\033[0;31m'          # Red
NC='\033[0m'
e='-e'

PATH=./src/test/script/launchers:"$PATH"

# exemple de définition d'une fonction
test_synt_invalide () {
    # $1 = premier argument.
    test_synt "$1"  2> "${1%.deca}".tmp
    if diff "${1%.deca}".tmp "${1%.deca}".res
    then
        echo "${Green}PASSED : ${NC}"
        echo "Echec attendu pour test_synt sur $1."
    else
        echo "${Red}FAILED : ${NC}"
        echo "Succes inattendu de test_synt sur $1."
    fi
    rm "${1%.deca}".tmp
}    

for cas_de_test in src/test/deca/syntax/invalid/*.deca
do
    test_synt_invalide "$cas_de_test"
done

# exemple de définition d'une fonction
test_synt_valide () {
    # $1 = premier argument.
    test_synt "$1"  > "${1%.deca}".tmp
    if diff "${1%.deca}".tmp "${1%.deca}".res
    then
        echo "${Green}PASSED : ${NC}"
        echo "Succes attendu de test_synt sur $1."
    else
        echo "${Red}FAILED : ${NC}"
        echo "Echec inattendu pour test_synt sur $1."
        
    fi
    rm "${1%.deca}".tmp
}

for cas_de_test in src/test/deca/syntax/valid/*.deca
do
    test_synt_valide "$cas_de_test"
done