#! /bin/sh

# Auteur : gl19
# Version initiale : 01/01/2023

# Test de tous les fichiers contextuellement valide

cd "$(dirname "$0")"/../../.. || exit 1

PATH=./src/test/script/launchers:"$PATH"


#Liste des increments a verifier
incr1-valid-context.sh
incr2-valid-context.sh
incr3-valid-context.sh
incr4-valid-context.sh
incr5-valid-context.sh
incr6-valid-context.sh