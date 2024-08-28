DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:30) - verify Main: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:34) - verify Main: end
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [1, 0] Program
   +> ListDeclClass [List with 0 elements]
   `> [1, 0] Main
      +> ListDeclVar [List with 1 elements]
      |  []> [2, 7] DeclVar
      |      +> [2, 1] Identifier (float)
      |      |  definition: type (builtin), type=float
      |      +> [2, 7] Identifier (a)
      |      |  definition: variable defined at [2, 7], type=float
      |      `> [2, 9] Initialization
      |         `> [2, 9] Float (2.7)
      |            type: float
      `> ListInst [List with 1 elements]
         []> [3, 1] Println
             `> ListExpr [List with 1 elements]
                []> [3, 10] Identifier (a)
                    definition: variable defined at [2, 7], type=float
