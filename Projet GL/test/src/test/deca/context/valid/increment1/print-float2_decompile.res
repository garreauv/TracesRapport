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
      |      `> NoInitialization
      `> ListInst [List with 2 elements]
         []> [3, 4] Assign
         ||  type: float
         ||  +> [3, 2] Identifier (a)
         ||  |  definition: variable defined at [2, 7], type=float
         ||  `> [3, 6] Float (3.2)
         ||     type: float
         []> [4, 1] Println
             `> ListExpr [List with 1 elements]
                []> [4, 10] Identifier (a)
                    definition: variable defined at [2, 7], type=float
