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
      |  ||     `> [6, 16] BooleanLiteral (true)
      |  ||        type: boolean
      |  []> [6, 22] DeclVar
      |  ||  +> [6, 4] Identifier (boolean)
      |  ||  |  definition: type (builtin), type=boolean
      |  ||  +> [6, 22] Identifier (b)
      |  ||  |  definition: variable defined at [6, 22], type=boolean
      |  ||  `> [6, 26] Initialization
      |  ||     `> [6, 26] BooleanLiteral (false)
      |  ||        type: boolean
      |  []> [8, 12] DeclVar
      |  ||  +> [8, 4] Identifier (boolean)
      |  ||  |  definition: type (builtin), type=boolean
      |  ||  +> [8, 12] Identifier (c)
      |  ||  |  definition: variable defined at [8, 12], type=boolean
      |  ||  `> [8, 16] Initialization
      |  ||     `> [8, 18] NotEquals
      |  ||        type: boolean
      |  ||        +> [8, 16] Identifier (a)
      |  ||        |  definition: variable defined at [6, 12], type=boolean
      |  ||        `> [8, 21] Identifier (b)
      |  ||           definition: variable defined at [6, 22], type=boolean
      |  []> [10, 12] DeclVar
      |      +> [10, 4] Identifier (boolean)
      |      |  definition: type (builtin), type=boolean
      |      +> [10, 12] Identifier (d)
      |      |  definition: variable defined at [10, 12], type=boolean
      |      `> [10, 16] Initialization
      |         `> [10, 28] Equals
      |            type: boolean
      |            +> [10, 23] NotEquals
      |            |  type: boolean
      |            |  +> [10, 18] NotEquals
      |            |  |  type: boolean
      |            |  |  +> [10, 16] Identifier (a)
      |            |  |  |  definition: variable defined at [6, 12], type=boolean
      |            |  |  `> [10, 21] Identifier (b)
      |            |  |     definition: variable defined at [6, 22], type=boolean
      |            |  `> [10, 26] Identifier (c)
      |            |     definition: variable defined at [8, 12], type=boolean
      |            `> [10, 31] Identifier (a)
      |               definition: variable defined at [6, 12], type=boolean
      `> ListInst [List with 0 elements]
