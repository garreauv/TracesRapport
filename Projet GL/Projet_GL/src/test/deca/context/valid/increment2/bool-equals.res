DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:30) - verify Main: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:34) - verify Main: end
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [5, 0] Program
   +> ListDeclClass [List with 0 elements]
   `> [5, 0] Main
      +> ListDeclVar [List with 4 elements]
      |  []> [6, 12] DeclVar
      |  ||  +> [6, 4] Identifier (boolean)
      |  ||  |  definition: type (builtin), type=boolean
      |  ||  +> [6, 12] Identifier (a)
      |  ||  |  definition: variable defined at [6, 12], type=boolean
      |  ||  `> [6, 16] Initialization
      |  ||     `> [6, 18] Equals
      |  ||        type: boolean
      |  ||        +> [6, 16] Int (3)
      |  ||        |  type: int
      |  ||        `> [6, 21] Int (2)
      |  ||           type: int
      |  []> [7, 12] DeclVar
      |  ||  +> [7, 4] Identifier (boolean)
      |  ||  |  definition: type (builtin), type=boolean
      |  ||  +> [7, 12] Identifier (b)
      |  ||  |  definition: variable defined at [7, 12], type=boolean
      |  ||  `> [7, 16] Initialization
      |  ||     `> [7, 18] Equals
      |  ||        type: boolean
      |  ||        +> [7, 16] Int (2)
      |  ||        |  type: int
      |  ||        `> [7, 21] Int (2)
      |  ||           type: int
      |  []> [8, 12] DeclVar
      |  ||  +> [8, 4] Identifier (boolean)
      |  ||  |  definition: type (builtin), type=boolean
      |  ||  +> [8, 12] Identifier (c)
      |  ||  |  definition: variable defined at [8, 12], type=boolean
      |  ||  `> [8, 16] Initialization
      |  ||     `> [8, 18] Equals
      |  ||        type: boolean
      |  ||        +> ConvFloat
      |  ||        |  type: float
      |  ||        |  `> [8, 16] Int (1)
      |  ||        |     type: int
      |  ||        `> [8, 21] Float (1.0)
      |  ||           type: float
      |  []> [9, 12] DeclVar
      |      +> [9, 4] Identifier (boolean)
      |      |  definition: type (builtin), type=boolean
      |      +> [9, 12] Identifier (d)
      |      |  definition: variable defined at [9, 12], type=boolean
      |      `> [9, 16] Initialization
      |         `> [9, 18] Equals
      |            type: boolean
      |            +> ConvFloat
      |            |  type: float
      |            |  `> [9, 16] Int (3)
      |            |     type: int
      |            `> [9, 21] Float (3.1)
      |               type: float
      `> ListInst [List with 0 elements]
