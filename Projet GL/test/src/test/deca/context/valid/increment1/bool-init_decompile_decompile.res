DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:30) - verify Main: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:34) - verify Main: end
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [1, 0] Program
   +> ListDeclClass [List with 0 elements]
   `> [1, 0] Main
      +> ListDeclVar [List with 2 elements]
      |  []> [2, 9] DeclVar
      |  ||  +> [2, 1] Identifier (boolean)
      |  ||  |  definition: type (builtin), type=boolean
      |  ||  +> [2, 9] Identifier (b)
      |  ||  |  definition: variable defined at [2, 9], type=boolean
      |  ||  `> [2, 11] Initialization
      |  ||     `> [2, 11] BooleanLiteral (true)
      |  ||        type: boolean
      |  []> [3, 9] DeclVar
      |      +> [3, 1] Identifier (boolean)
      |      |  definition: type (builtin), type=boolean
      |      +> [3, 9] Identifier (c)
      |      |  definition: variable defined at [3, 9], type=boolean
      |      `> [3, 11] Initialization
      |         `> [3, 11] BooleanLiteral (false)
      |            type: boolean
      `> ListInst [List with 0 elements]
