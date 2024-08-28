#! /bin/sh

# Auteur : gl19
# Version initiale : 01/01/2023

# Test de tous les fichiers contextuellement invalide

cd "$(dirname "$0")"/../../.. || exit 1

PATH=./src/test/script/launchers:"$PATH"


#Liste des increments a verifier
incr1-inv-context.sh
incr2-inv-context.sh
incr3-inv-context.sh
incr4-inv-context.sh
incr5-inv-context.sh
incr6-inv-context.sh