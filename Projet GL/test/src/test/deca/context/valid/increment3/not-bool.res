DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:30) - verify Main: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:34) - verify Main: end
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [3, 0] Program
   +> ListDeclClass [List with 0 elements]
   `> [3, 0] Main
      +> ListDeclVar [List with 3 elements]
      |  []> [4, 12] DeclVar
      |  ||  +> [4, 4] Identifier (boolean)
      |  ||  |  definition: type (builtin), type=boolean
      |  ||  +> [4, 12] Identifier (bool)
      |  ||  |  definition: variable defined at [4, 12], type=boolean
      |  ||  `> [4, 19] Initialization
      |  ||     `> [4, 19] BooleanLiteral (true)
      |  ||        type: boolean
      |  []> [5, 8] DeclVar
      |  ||  +> [5, 4] Identifier (int)
      |  ||  |  definition: type (builtin), type=int
      |  ||  +> [5, 8] Identifier (a)
      |  ||  |  definition: variable defined at [5, 8], type=int
      |  ||  `> NoInitialization
      |  []> [5, 10] DeclVar
      |      +> [5, 4] Identifier (int)
      |      |  definition: type (builtin), type=int
      |      +> [5, 10] Identifier (b)
      |      |  definition: variable defined at [5, 10], type=int
      |      `> NoInitialization
      `> ListInst [List with 4 elements]
         []> [6, 6] Assign
         ||  type: int
         ||  +> [6, 4] Identifier (a)
         ||  |  definition: variable defined at [5, 8], type=int
         ||  `> [6, 8] Int (2)
         ||     type: int
         []> [7, 6] Assign
         ||  type: int
         ||  +> [7, 4] Identifier (b)
         ||  |  definition: variable defined at [5, 10], type=int
         ||  `> [7, 8] Int (3)
         ||     type: int
         []> [8, 4] IfThenElse
         ||  +> [8, 7] Identifier (bool)
         ||  |  definition: variable defined at [4, 12], type=boolean
         ||  +> ListInst [List with 1 elements]
         ||  |  []> [9, 8] Println
         ||  |      `> ListExpr [List with 1 elements]
         ||  |         []> [9, 16] Identifier (a)
         ||  |             definition: variable defined at [5, 8], type=int
         ||  `> ListInst [List with 0 elements]
         []> [11, 4] IfThenElse
             +> [11, 7] Not
             |  type: boolean
             |  `> [11, 8] Identifier (bool)
             |     definition: variable defined at [4, 12], type=boolean
             +> ListInst [List with 1 elements]
             |  []> [12, 8] Println
             |      `> ListExpr [List with 1 elements]
             |         []> [12, 16] Identifier (b)
             |             definition: variable defined at [5, 10], type=int
             `> ListInst [List with 0 elements]
