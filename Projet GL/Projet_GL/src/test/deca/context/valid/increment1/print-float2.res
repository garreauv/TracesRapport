DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:30) - verify Main: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:34) - verify Main: end
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [6, 0] Program
   +> ListDeclClass [List with 0 elements]
   `> [6, 0] Main
      +> ListDeclVar [List with 1 elements]
      |  []> [7, 10] DeclVar
      |      +> [7, 4] Identifier (float)
      |      |  definition: type (builtin), type=float
      |      +> [7, 10] Identifier (a)
      |      |  definition: variable defined at [7, 10], type=float
      |      `> NoInitialization
      `> ListInst [List with 2 elements]
         []> [9, 6] Assign
         ||  type: float
         ||  +> [9, 4] Identifier (a)
         ||  |  definition: variable defined at [7, 10], type=float
         ||  `> [9, 8] Float (3.2)
         ||     type: float
         []> [10, 4] Println
             `> ListExpr [List with 1 elements]
                []> [10, 12] Identifier (a)
                    definition: variable defined at [7, 10], type=float
