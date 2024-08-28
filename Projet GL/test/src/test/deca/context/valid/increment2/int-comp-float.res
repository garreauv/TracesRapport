DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:30) - verify Main: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:34) - verify Main: end
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [5, 0] Program
   +> ListDeclClass [List with 0 elements]
   `> [5, 0] Main
      +> ListDeclVar [List with 6 elements]
      |  []> [6, 12] DeclVar
      |  ||  +> [6, 4] Identifier (boolean)
      |  ||  |  definition: type (builtin), type=boolean
      |  ||  +> [6, 12] Identifier (a)
      |  ||  |  definition: variable defined at [6, 12], type=boolean
      |  ||  `> [6, 16] Initialization
      |  ||     `> [6, 18] Greater
      |  ||        type: boolean
      |  ||        +> ConvFloat
      |  ||        |  type: float
      |  ||        |  `> [6, 16] Int (3)
      |  ||        |     type: int
      |  ||        `> [6, 20] Float (3.1)
      |  ||           type: float
      |  []> [7, 12] DeclVar
      |  ||  +> [7, 4] Identifier (boolean)
      |  ||  |  definition: type (builtin), type=boolean
      |  ||  +> [7, 12] Identifier (b)
      |  ||  |  definition: variable defined at [7, 12], type=boolean
      |  ||  `> [7, 16] Initialization
      |  ||     `> [7, 18] GreaterOrEqual
      |  ||        type: boolean
      |  ||        +> ConvFloat
      |  ||        |  type: float
      |  ||        |  `> [7, 16] Int (3)
      |  ||        |     type: int
      |  ||        `> [7, 21] Float (3.0)
      |  ||           type: float
      |  []> [8, 12] DeclVar
      |  ||  +> [8, 4] Identifier (boolean)
      |  ||  |  definition: type (builtin), type=boolean
      |  ||  +> [8, 12] Identifier (c)
      |  ||  |  definition: variable defined at [8, 12], type=boolean
      |  ||  `> [8, 16] Initialization
      |  ||     `> [8, 18] Lower
      |  ||        type: boolean
      |  ||        +> ConvFloat
      |  ||        |  type: float
      |  ||        |  `> [8, 16] Int (3)
      |  ||        |     type: int
      |  ||        `> [8, 20] Float (4.8)
      |  ||           type: float
      |  []> [9, 12] DeclVar
      |  ||  +> [9, 4] Identifier (boolean)
      |  ||  |  definition: type (builtin), type=boolean
      |  ||  +> [9, 12] Identifier (d)
      |  ||  |  definition: variable defined at [9, 12], type=boolean
      |  ||  `> [9, 16] Initialization
      |  ||     `> [9, 18] LowerOrEqual
      |  ||        type: boolean
      |  ||        +> ConvFloat
      |  ||        |  type: float
      |  ||        |  `> [9, 16] Int (2)
      |  ||        |     type: int
      |  ||        `> [9, 21] Float (1.9)
      |  ||           type: float
      |  []> [10, 12] DeclVar
      |  ||  +> [10, 4] Identifier (boolean)
      |  ||  |  definition: type (builtin), type=boolean
      |  ||  +> [10, 12] Identifier (e)
      |  ||  |  definition: variable defined at [10, 12], type=boolean
      |  ||  `> [10, 16] Initialization
      |  ||     `> [10, 18] Equals
      |  ||        type: boolean
      |  ||        +> ConvFloat
      |  ||        |  type: float
      |  ||        |  `> [10, 16] Int (3)
      |  ||        |     type: int
      |  ||        `> [10, 21] Float (3.0)
      |  ||           type: float
      |  []> [11, 12] DeclVar
      |      +> [11, 4] Identifier (boolean)
      |      |  definition: type (builtin), type=boolean
      |      +> [11, 12] Identifier (f)
      |      |  definition: variable defined at [11, 12], type=boolean
      |      `> [11, 16] Initialization
      |         `> [11, 18] NotEquals
      |            type: boolean
      |            +> ConvFloat
      |            |  type: float
      |            |  `> [11, 16] Int (2)
      |            |     type: int
      |            `> [11, 21] Float (4.77)
      |               type: float
      `> ListInst [List with 0 elements]
