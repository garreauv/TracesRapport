DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:30) - verify Main: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:34) - verify Main: end
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [8, 0] Program
   +> ListDeclClass [List with 0 elements]
   `> [8, 0] Main
      +> ListDeclVar [List with 2 elements]
      |  []> [9, 8] DeclVar
      |  ||  +> [9, 4] Identifier (int)
      |  ||  |  definition: type (builtin), type=int
      |  ||  +> [9, 8] Identifier (a)
      |  ||  |  definition: variable defined at [9, 8], type=int
      |  ||  `> [9, 12] Initialization
      |  ||     `> [9, 12] Int (2)
      |  ||        type: int
      |  []> [10, 10] DeclVar
      |      +> [10, 4] Identifier (float)
      |      |  definition: type (builtin), type=float
      |      +> [10, 10] Identifier (b)
      |      |  definition: variable defined at [10, 10], type=float
      |      `> NoInitialization
      `> ListInst [List with 1 elements]
         []> [13, 6] Assign
             type: float
             +> [13, 4] Identifier (b)
             |  definition: variable defined at [10, 10], type=float
             `> [13, 8] UnaryMinus
                type: int
                `> [13, 9] Identifier (a)
                   definition: variable defined at [9, 8], type=int
