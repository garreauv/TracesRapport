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
      |  ||     `> [6, 20] Greater
      |  ||        type: boolean
      |  ||        +> [6, 16] Float (3.1)
      |  ||        |  type: float
      |  ||        `> [6, 22] Float (3.101)
      |  ||           type: float
      |  []> [7, 12] DeclVar
      |  ||  +> [7, 4] Identifier (boolean)
      |  ||  |  definition: type (builtin), type=boolean
      |  ||  +> [7, 12] Identifier (b)
      |  ||  |  definition: variable defined at [7, 12], type=boolean
      |  ||  `> [7, 16] Initialization
      |  ||     `> [7, 21] GreaterOrEqual
      |  ||        type: boolean
      |  ||        +> [7, 16] Float (3.23)
      |  ||        |  type: float
      |  ||        `> [7, 24] Float (3.23)
      |  ||           type: float
      |  []> [8, 12] DeclVar
      |  ||  +> [8, 4] Identifier (boolean)
      |  ||  |  definition: type (builtin), type=boolean
      |  ||  +> [8, 12] Identifier (c)
      |  ||  |  definition: variable defined at [8, 12], type=boolean
      |  ||  `> [8, 16] Initialization
      |  ||     `> [8, 20] Lower
      |  ||        type: boolean
      |  ||        +> [8, 16] Float (3.1)
      |  ||        |  type: float
      |  ||        `> [8, 22] Float (4.2)
      |  ||           type: float
      |  []> [9, 12] DeclVar
      |  ||  +> [9, 4] Identifier (boolean)
      |  ||  |  definition: type (builtin), type=boolean
      |  ||  +> [9, 12] Identifier (d)
      |  ||  |  definition: variable defined at [9, 12], type=boolean
      |  ||  `> [9, 16] Initialization
      |  ||     `> [9, 20] LowerOrEqual
      |  ||        type: boolean
      |  ||        +> [9, 16] Float (2.0)
      |  ||        |  type: float
      |  ||        `> [9, 23] Float (1.9)
      |  ||           type: float
      |  []> [10, 12] DeclVar
      |  ||  +> [10, 4] Identifier (boolean)
      |  ||  |  definition: type (builtin), type=boolean
      |  ||  +> [10, 12] Identifier (e)
      |  ||  |  definition: variable defined at [10, 12], type=boolean
      |  ||  `> [10, 16] Initialization
      |  ||     `> [10, 20] Equals
      |  ||        type: boolean
      |  ||        +> [10, 16] Float (3.2)
      |  ||        |  type: float
      |  ||        `> [10, 23] Float (4.2)
      |  ||           type: float
      |  []> [11, 12] DeclVar
      |      +> [11, 4] Identifier (boolean)
      |      |  definition: type (builtin), type=boolean
      |      +> [11, 12] Identifier (f)
      |      |  definition: variable defined at [11, 12], type=boolean
      |      `> [11, 16] Initialization
      |         `> [11, 20] NotEquals
      |            type: boolean
      |            +> [11, 16] Float (9.1)
      |            |  type: float
      |            `> [11, 23] Float (3.0)
      |               type: float
      `> ListInst [List with 0 elements]
