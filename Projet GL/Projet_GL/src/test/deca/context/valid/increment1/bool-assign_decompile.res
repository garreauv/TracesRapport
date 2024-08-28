DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:30) - verify Main: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:34) - verify Main: end
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [1, 0] Program
   +> ListDeclClass [List with 0 elements]
   `> [1, 0] Main
      +> ListDeclVar [List with 1 elements]
      |  []> [2, 9] DeclVar
      |      +> [2, 1] Identifier (boolean)
      |      |  definition: type (builtin), type=boolean
      |      +> [2, 9] Identifier (a)
      |      |  definition: variable defined at [2, 9], type=boolean
      |      `> NoInitialization
      `> ListInst [List with 2 elements]
         []> [3, 4] Assign
         ||  type: boolean
         ||  +> [3, 2] Identifier (a)
         ||  |  definition: variable defined at [2, 9], type=boolean
         ||  `> [3, 6] BooleanLiteral (true)
         ||     type: boolean
         []> [4, 4] Assign
             type: boolean
             +> [4, 2] Identifier (a)
             |  definition: variable defined at [2, 9], type=boolean
             `> [4, 6] BooleanLiteral (false)
                type: boolean
