
#! /bin/sh

for i in ../../../src/test/deca/codegen/invalid/created/*.deca
do
    echo "$i"
    # Remplacer <executable> par test_synt ou test_lex
    # ou test_context ou decac
    decac "$i" 
    #> "${i%.deca}".res not necessary because tests are of type mismatch
done

echo "Time taken of the script in seconds: " $SECONDS
