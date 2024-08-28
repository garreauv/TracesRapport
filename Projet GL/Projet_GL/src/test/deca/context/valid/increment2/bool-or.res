DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:30) - verify Main: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:34) - verify Main: end
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [5, 0] Program
   +> ListDeclClass [List with 0 elements]
   `> [5, 0] Main
      +> ListDeclVar [List with 2 elements]
      |  []> [6, 12] DeclVar
      |  ||  +> [6, 4] Identifier (boolean)
      |  ||  |  definition: type (builtin), type=boolean
      |  ||  +> [6, 12] Identifier (a)
      |  ||  |  definition: variable defined at [6, 12], type=boolean
      |  ||  `> [6, 16] Initialization
      |  ||     `> [6, 21] Or
      |  ||        type: boolean
      |  ||        +> [6, 16] BooleanLiteral (true)
      |  ||        |  type: boolean
      |  ||        `> [6, 24] BooleanLiteral (false)
      |  ||           type: boolean
      |  []> [8, 12] DeclVar
      |      +> [8, 4] Identifier (boolean)
      |      |  definition: type (builtin), type=boolean
      |      +> [8, 12] Identifier (b)
      |      |  definition: variable defined at [8, 12], type=boolean
      |      `> NoInitialization
      `> ListInst [List with 1 elements]
         []> [10, 6] Assign
             type: boolean
             +> [10, 4] Identifier (b)
             |  definition: variable defined at [8, 12], type=boolean
             `> [10, 10] Or
                type: boolean
                +> [10, 8] Identifier (a)
                |  definition: variable defined at [6, 12], type=boolean
                `> [10, 13] BooleanLiteral (true)
                   type: boolean
