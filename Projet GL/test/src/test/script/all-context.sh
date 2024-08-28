#! /bin/sh

# Auteur : gl19
# Version initiale : 01/01/2023

# Test de tous les fichiers contextuellement valide

cd "$(dirname "$0")"/../../.. || exit 1

PATH=./src/test/script/launchers:"$PATH"


#Liste des increments a verifier
valid-context.sh
invalid-context.sh
#diff-context.sh