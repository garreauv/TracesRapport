`> [10, 0] Program
   +> ListDeclClass [List with 0 elements]
   `> [10, 0] Main
      +> ListDeclVar [List with 1 elements]
      |  []> [11, 5] DeclVar
      |      +> [11, 1] Identifier (int)
      |      +> [11, 5] Identifier (x)
      |      `> NoInitialization
      `> ListInst [List with 2 elements]
         []> [12, 2] Assign
         ||  +> [12, 1] Identifier (x)
         ||  `> [12, 3] ReadInt
         []> [13, 1] Println
             `> ListExpr [List with 1 elements]
                []> [13, 12] Multiply
                    +> [13, 9] Float (0.5)
                    `> [13, 15] Multiply
                       +> [13, 14] Identifier (x)
                       `> [13, 16] Identifier (x)
