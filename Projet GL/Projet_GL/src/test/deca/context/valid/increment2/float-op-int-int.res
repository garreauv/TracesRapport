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
      |  []> [9, 10] DeclVar
      |      +> [9, 4] Identifier (float)
      |      |  definition: type (builtin), type=float
      |      +> [9, 10] Identifier (c)
      |      |  definition: variable defined at [9, 10], type=float
      |      `> NoInitialization
      `> ListInst [List with 3 elements]
         []> [11, 6] Assign
         ||  type: int
         ||  +> [11, 4] Identifier (a)
         ||  |  definition: variable defined at [8, 8], type=int
         ||  `> [11, 8] Int (2)
         ||     type: int
         []> [12, 6] Assign
         ||  type: int
         ||  +> [12, 4] Identifier (b)
         ||  |  definition: variable defined at [8, 10], type=int
         ||  `> [12, 8] Int (3)
         ||     type: int
         []> [15, 6] Assign
             type: float
             +> [15, 4] Identifier (c)
             |  definition: variable defined at [9, 10], type=float
             `> [15, 9] Plus
                type: int
                +> [15, 8] Identifier (a)
                |  definition: variable defined at [8, 8], type=int
                `> [15, 10] Identifier (b)
                   definition: variable defined at [8, 10], type=int
