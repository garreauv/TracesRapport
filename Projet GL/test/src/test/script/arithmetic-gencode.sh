#! /bin/sh

for i in ../../../src/test/deca/codegen/valid/created/arithmetic/*.deca
do 
    echo "$i"
    decac "$i" > "${i%.deca}" .res
done

echo "Time taken of the script in seconds: " $SECONDS
