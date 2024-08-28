`> [10, 0] Program
   +> ListDeclClass [List with 0 elements]
   `> [10, 0] Main
      +> ListDeclVar [List with 2 elements]
      |  []> [12, 8] DeclVar
      |  ||  +> [12, 4] Identifier (int)
      |  ||  +> [12, 8] Identifier (i)
      |  ||  `> NoInitialization
      |  []> [13, 10] DeclVar
      |      +> [13, 4] Identifier (float)
      |      +> [13, 10] Identifier (j)
      |      `> NoInitialization
      `> ListInst [List with 3 elements]
         []> [14, 6] Assign
         ||  +> [14, 4] Identifier (i)
         ||  `> [14, 8] ReadInt
         []> [15, 6] Assign
         ||  +> [15, 4] Identifier (j)
         ||  `> [15, 8] ReadFloat
         []> [17, 4] Print
             `> ListExpr [List with 2 elements]
                []> [17, 10] Identifier (i)
                []> [17, 13] Identifier (j)
