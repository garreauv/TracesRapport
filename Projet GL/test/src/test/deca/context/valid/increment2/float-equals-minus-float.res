DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:30) - verify Main: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:34) - verify Main: end
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [5, 0] Program
   +> ListDeclClass [List with 0 elements]
   `> [5, 0] Main
      +> ListDeclVar [List with 2 elements]
      |  []> [6, 10] DeclVar
      |  ||  +> [6, 4] Identifier (float)
      |  ||  |  definition: type (builtin), type=float
      |  ||  +> [6, 10] Identifier (a)
      |  ||  |  definition: variable defined at [6, 10], type=float
      |  ||  `> NoInitialization
      |  []> [6, 12] DeclVar
      |      +> [6, 4] Identifier (float)
      |      |  definition: type (builtin), type=float
      |      +> [6, 12] Identifier (b)
      |      |  definition: variable defined at [6, 12], type=float
      |      `> NoInitialization
      `> ListInst [List with 3 elements]
         []> [8, 6] Assign
         ||  type: float
         ||  +> [8, 4] Identifier (a)
         ||  |  definition: variable defined at [6, 10], type=float
         ||  `> [8, 8] Float (4.7)
         ||     type: float
         []> [9, 6] Assign
         ||  type: float
         ||  +> [9, 4] Identifier (b)
         ||  |  definition: variable defined at [6, 12], type=float
         ||  `> [9, 8] UnaryMinus
         ||     type: float
         ||     `> [9, 9] Identifier (a)
         ||        definition: variable defined at [6, 10], type=float
         []> [11, 4] Println
             `> ListExpr [List with 1 elements]
                []> [11, 12] Identifier (b)
                    definition: variable defined at [6, 12], type=float
