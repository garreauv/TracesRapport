DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:30) - verify Main: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:34) - verify Main: end
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [6, 0] Program
   +> ListDeclClass [List with 0 elements]
   `> [6, 0] Main
      +> ListDeclVar [List with 1 elements]
      |  []> [7, 8] DeclVar
      |      +> [7, 4] Identifier (int)
      |      |  definition: type (builtin), type=int
      |      +> [7, 8] Identifier (a)
      |      |  definition: variable defined at [7, 8], type=int
      |      `> [7, 12] Initialization
      |         `> [7, 12] Int (7)
      |            type: int
      `> ListInst [List with 1 elements]
         []> [8, 4] Println
             `> ListExpr [List with 1 elements]
                []> [8, 12] Identifier (a)
                    definition: variable defined at [7, 8], type=int
