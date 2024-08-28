DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:30) - verify Main: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:34) - verify Main: end
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [5, 0] Program
   +> ListDeclClass [List with 0 elements]
   `> [5, 0] Main
      +> ListDeclVar [List with 3 elements]
      |  []> [6, 8] DeclVar
      |  ||  +> [6, 4] Identifier (int)
      |  ||  |  definition: type (builtin), type=int
      |  ||  +> [6, 8] Identifier (a)
      |  ||  |  definition: variable defined at [6, 8], type=int
      |  ||  `> [6, 12] Initialization
      |  ||     `> [6, 12] Int (3)
      |  ||        type: int
      |  []> [6, 15] DeclVar
      |  ||  +> [6, 4] Identifier (int)
      |  ||  |  definition: type (builtin), type=int
      |  ||  +> [6, 15] Identifier (b)
      |  ||  |  definition: variable defined at [6, 15], type=int
      |  ||  `> [6, 17] Initialization
      |  ||     `> [6, 17] Int (4)
      |  ||        type: int
      |  []> [8, 12] DeclVar
      |      +> [8, 4] Identifier (boolean)
      |      |  definition: type (builtin), type=boolean
      |      +> [8, 12] Identifier (c)
      |      |  definition: variable defined at [8, 12], type=boolean
      |      `> [8, 16] Initialization
      |         `> [8, 18] NotEquals
      |            type: boolean
      |            +> [8, 16] Identifier (a)
      |            |  definition: variable defined at [6, 8], type=int
      |            `> [8, 21] Identifier (b)
      |               definition: variable defined at [6, 15], type=int
      `> ListInst [List with 0 elements]
