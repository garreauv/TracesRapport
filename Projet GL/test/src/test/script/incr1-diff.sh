for test in src/test/deca/context/valid/increment1/*.res
do
    git diff --color --no-index "$test" ${test%???}"txt"
done