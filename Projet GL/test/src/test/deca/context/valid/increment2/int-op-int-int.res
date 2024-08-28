DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:30) - verify Main: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:34) - verify Main: end
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [7, 0] Program
   +> ListDeclClass [List with 0 elements]
   `> [7, 0] Main
      +> ListDeclVar [List with 3 elements]
      |  []> [8, 8] DeclVar
      |  ||  +> [8, 4] Identifier (int)
      |  ||  |  definition: type (builtin), type=int
      |  ||  +> [8, 8] Identifier (a)
      |  ||  |  definition: variable defined at [8, 8], type=int
      |  ||  `> NoInitialization
      |  []> [8, 10] DeclVar
      |  ||  +> [8, 4] Identifier (int)
      |  ||  |  definition: type (builtin), type=int
      |  ||  +> [8, 10] Identifier (b)
      |  ||  |  definition: variable defined at [8, 10], type=int
      |  ||  `> NoInitialization
      |  []> [8, 12] DeclVar
      |      +> [8, 4] Identifier (int)
      |      |  definition: type (builtin), type=int
      |      +> [8, 12] Identifier (c)
      |      |  definition: variable defined at [8, 12], type=int
      |      `> NoInitialization
      `> ListInst [List with 4 elements]
         []> [10, 6] Assign
         ||  type: int
         ||  +> [10, 4] Identifier (a)
         ||  |  definition: variable defined at [8, 8], type=int
         ||  `> [10, 8] Int (2)
         ||     type: int
         []> [11, 6] Assign
         ||  type: int
         ||  +> [11, 4] Identifier (b)
         ||  |  definition: variable defined at [8, 10], type=int
         ||  `> [11, 8] Int (3)
         ||     type: int
         []> [12, 6] Assign
         ||  type: int
         ||  +> [12, 4] Identifier (c)
         ||  |  definition: variable defined at [8, 12], type=int
         ||  `> [12, 9] Plus
         ||     type: int
         ||     +> [12, 8] Int (2)
         ||     |  type: int
         ||     `> [12, 10] Int (3)
         ||        type: int
         []> [14, 4] Println
             `> ListExpr [List with 1 elements]
                []> [14, 12] Identifier (c)
                    definition: variable defined at [8, 12], type=int
