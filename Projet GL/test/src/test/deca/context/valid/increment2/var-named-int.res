DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:30) - verify Main: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:34) - verify Main: end
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [5, 0] Program
   +> ListDeclClass [List with 0 elements]
   `> [5, 0] Main
      +> ListDeclVar [List with 1 elements]
      |  []> [6, 8] DeclVar
      |      +> [6, 4] Identifier (int)
      |      |  definition: type (builtin), type=int
      |      +> [6, 8] Identifier (int)
      |      |  definition: variable defined at [6, 8], type=int
      |      `> [6, 14] Initialization
      |         `> [6, 14] Int (3)
      |            type: int
      `> ListInst [List with 2 elements]
         []> [8, 8] Assign
         ||  type: int
         ||  +> [8, 4] Identifier (int)
         ||  |  definition: variable defined at [6, 8], type=int
         ||  `> [8, 14] Plus
         ||     type: int
         ||     +> [8, 10] Identifier (int)
         ||     |  definition: variable defined at [6, 8], type=int
         ||     `> [8, 16] Int (1)
         ||        type: int
         []> [10, 4] Print
             `> ListExpr [List with 1 elements]
                []> [10, 10] Identifier (int)
                    definition: variable defined at [6, 8], type=int
