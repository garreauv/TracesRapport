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
      |  ||  `> [8, 12] Initialization
      |  ||     `> [8, 12] Int (2)
      |  ||        type: int
      |  []> [9, 10] DeclVar
      |  ||  +> [9, 4] Identifier (float)
      |  ||  |  definition: type (builtin), type=float
      |  ||  +> [9, 10] Identifier (b)
      |  ||  |  definition: variable defined at [9, 10], type=float
      |  ||  `> NoInitialization
      |  []> [9, 12] DeclVar
      |      +> [9, 4] Identifier (float)
      |      |  definition: type (builtin), type=float
      |      +> [9, 12] Identifier (c)
      |      |  definition: variable defined at [9, 12], type=float
      |      `> NoInitialization
      `> ListInst [List with 2 elements]
         []> [11, 6] Assign
         ||  type: float
         ||  +> [11, 4] Identifier (b)
         ||  |  definition: variable defined at [9, 10], type=float
         ||  `> [11, 8] Float (3.5)
         ||     type: float
         []> [13, 6] Assign
             type: float
             +> [13, 4] Identifier (c)
             |  definition: variable defined at [9, 12], type=float
             `> [13, 10] Plus
                type: float
                +> ConvFloat
                |  type: float
                |  `> [13, 8] Identifier (a)
                |     definition: variable defined at [8, 8], type=int
                `> [13, 12] Identifier (b)
                   definition: variable defined at [9, 10], type=float
