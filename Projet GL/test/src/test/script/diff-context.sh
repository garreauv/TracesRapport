echo "Début des tests diff"

for test in src/test/deca/context/valid/increment1/*.res
do
    git diff --color --no-index "$test" ${test%???}"txt"
done

for test in src/test/deca/context/valid/increment2/*.res
do
    git diff --color --no-index "$test" ${test%???}"txt"
done

for test in src/test/deca/context/valid/increment3/*.res
do
    git diff --color --no-index "$test" ${test%???}"txt"
done

for test in src/test/deca/context/invalid/increment1/*.res
do
    git diff --color --no-index "$test" ${test%???}"txt"
done

for test in src/test/deca/context/invalid/increment2/*.res
do
    git diff --color --no-index "$test" ${test%???}"txt"
done

for test in src/test/deca/context/invalid/increment3/*.res
do
    git diff --color --no-index "$test" ${test%???}"txt"
done

echo "Fin des tests diff"