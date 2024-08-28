echo "Début de la démonstration"
read
all-context.sh
read
code src/test/deca/context/valid/increment1/hello-world.deca
read
code src/test/deca/context/valid/increment1/hello-world.res
read
decac src/test/deca/context/valid/increment1/hello-world.deca
ima src/test/deca/context/valid/increment1/hello-world.ass
read
code src/test/deca/codegen/perf/provided/syracuse42.deca
read
decac src/test/deca/codegen/perf/provided/syracuse42.deca
ima -s src/test/deca/codegen/perf/provided/syracuse42.ass
echo "Fin de la démonstration"