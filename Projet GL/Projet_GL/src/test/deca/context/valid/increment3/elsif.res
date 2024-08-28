DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:30) - verify Main: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:34) - verify Main: end
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [5, 0] Program
   +> ListDeclClass [List with 0 elements]
   `> [5, 0] Main
      +> ListDeclVar [List with 2 elements]
      |  []> [6, 8] DeclVar
      |  ||  +> [6, 4] Identifier (int)
      |  ||  |  definition: type (builtin), type=int
      |  ||  +> [6, 8] Identifier (a)
      |  ||  |  definition: variable defined at [6, 8], type=int
      |  ||  `> [6, 12] Initialization
      |  ||     `> [6, 12] Int (3)
      |  ||        type: int
      |  []> [7, 10] DeclVar
      |      +> [7, 4] Identifier (float)
      |      |  definition: type (builtin), type=float
      |      +> [7, 10] Identifier (b)
      |      |  definition: variable defined at [7, 10], type=float
      |      `> [7, 14] Initialization
      |         `> [7, 14] Float (3.0)
      |            type: float
      `> ListInst [List with 1 elements]
         []> [9, 4] IfThenElse
             +> [9, 8] Greater
             |  type: boolean
             |  +> ConvFloat
             |  |  type: float
             |  |  `> [9, 7] Identifier (a)
             |  |     definition: variable defined at [6, 8], type=int
             |  `> [9, 9] Identifier (b)
             |     definition: variable defined at [7, 10], type=float
             +> ListInst [List with 1 elements]
             |  []> [10, 8] Print
             |      `> ListExpr [List with 1 elements]
             |         []> [10, 14] StringLiteral (a est plus grand)
             |             type: string
             `> ListInst [List with 1 elements]
                []> [12, 9] IfThenElse
                    +> [12, 13] Lower
                    |  type: boolean
                    |  +> ConvFloat
                    |  |  type: float
                    |  |  `> [12, 12] Identifier (a)
                    |  |     definition: variable defined at [6, 8], type=int
                    |  `> [12, 14] Identifier (b)
                    |     definition: variable defined at [7, 10], type=float
                    +> ListInst [List with 1 elements]
                    |  []> [13, 8] Print
                    |      `> ListExpr [List with 1 elements]
                    |         []> [13, 14] StringLiteral (a est plus petit)
                    |             type: string
                    `> ListInst [List with 1 elements]
                       []> [15, 9] IfThenElse
                           +> [15, 14] Equals
                           |  type: boolean
                           |  +> ConvFloat
                           |  |  type: float
                           |  |  `> [15, 12] Identifier (a)
                           |  |     definition: variable defined at [6, 8], type=int
                           |  `> [15, 17] Identifier (b)
                           |     definition: variable defined at [7, 10], type=float
                           +> ListInst [List with 1 elements]
                           |  []> [16, 8] Print
                           |      `> ListExpr [List with 1 elements]
                           |         []> [16, 14] StringLiteral (a et b sont egaux :))
                           |             type: string
                           `> ListInst [List with 0 elements]
