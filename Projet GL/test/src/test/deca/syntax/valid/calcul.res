`> [10, 0] Program
   +> ListDeclClass [List with 0 elements]
   `> [10, 0] Main
      +> ListDeclVar [List with 9 elements]
      |  []> [11, 12] DeclVar
      |  ||  +> [11, 8] Identifier (int)
      |  ||  +> [11, 12] Identifier (a)
      |  ||  `> NoInitialization
      |  []> [11, 14] DeclVar
      |  ||  +> [11, 8] Identifier (int)
      |  ||  +> [11, 14] Identifier (b)
      |  ||  `> NoInitialization
      |  []> [11, 16] DeclVar
      |  ||  +> [11, 8] Identifier (int)
      |  ||  +> [11, 16] Identifier (c)
      |  ||  `> NoInitialization
      |  []> [11, 18] DeclVar
      |  ||  +> [11, 8] Identifier (int)
      |  ||  +> [11, 18] Identifier (d)
      |  ||  `> NoInitialization
      |  []> [11, 20] DeclVar
      |  ||  +> [11, 8] Identifier (int)
      |  ||  +> [11, 20] Identifier (e)
      |  ||  `> [11, 22] Initialization
      |  ||     `> [11, 22] Int (1)
      |  []> [12, 14] DeclVar
      |  ||  +> [12, 8] Identifier (float)
      |  ||  +> [12, 14] Identifier (f)
      |  ||  `> NoInitialization
      |  []> [12, 16] DeclVar
      |  ||  +> [12, 8] Identifier (float)
      |  ||  +> [12, 16] Identifier (g)
      |  ||  `> NoInitialization
      |  []> [12, 18] DeclVar
      |  ||  +> [12, 8] Identifier (float)
      |  ||  +> [12, 18] Identifier (h)
      |  ||  `> NoInitialization
      |  []> [12, 20] DeclVar
      |      +> [12, 8] Identifier (float)
      |      +> [12, 20] Identifier (i)
      |      `> [12, 22] Initialization
      |         `> [12, 22] Float (1.1)
      `> ListInst [List with 12 elements]
         []> [14, 10] Assign
         ||  +> [14, 8] Identifier (d)
         ||  `> [14, 12] Int (5)
         []> [15, 10] Assign
         ||  +> [15, 8] Identifier (a)
         ||  `> [15, 14] Plus
         ||     +> [15, 12] Identifier (e)
         ||     `> [15, 16] Identifier (d)
         []> [16, 10] Assign
         ||  +> [16, 8] Identifier (c)
         ||  `> [16, 12] Int (0)
         []> [17, 10] Assign
         ||  +> [17, 8] Identifier (b)
         ||  `> [17, 14] Minus
         ||     +> [17, 12] Identifier (d)
         ||     `> [17, 16] Identifier (c)
         []> [18, 10] Assign
         ||  +> [18, 8] Identifier (d)
         ||  `> [18, 14] Multiply
         ||     +> [18, 12] Identifier (e)
         ||     `> [18, 16] Identifier (a)
         []> [19, 10] Assign
         ||  +> [19, 8] Identifier (e)
         ||  `> [19, 14] Divide
         ||     +> [19, 12] Identifier (a)
         ||     `> [19, 16] Identifier (b)
         []> [20, 10] Assign
         ||  +> [20, 8] Identifier (c)
         ||  `> [20, 13] Modulo
         ||     +> [20, 12] Identifier (d)
         ||     `> [20, 14] Identifier (b)
         []> [21, 10] Assign
         ||  +> [21, 8] Identifier (e)
         ||  `> [21, 44] Modulo
         ||     +> [21, 19] Multiply
         ||     |  +> [21, 15] Plus
         ||     |  |  +> [21, 13] Int (5)
         ||     |  |  `> [21, 17] Int (6)
         ||     |  `> [21, 28] Plus
         ||     |     +> [21, 24] Minus
         ||     |     |  +> [21, 22] Identifier (a)
         ||     |     |  `> [21, 26] Identifier (c)
         ||     |     `> [21, 41] Divide
         ||     |        +> [21, 36] Plus
         ||     |        |  +> [21, 31] Int (1265)
         ||     |        |  `> [21, 38] Int (52)
         ||     |        `> [21, 42] Identifier (e)
         ||     `> [21, 45] Identifier (e)
         []> [23, 10] Assign
         ||  +> [23, 8] Identifier (f)
         ||  `> [23, 12] Float (2.3)
         []> [24, 10] Assign
         ||  +> [24, 8] Identifier (h)
         ||  `> [24, 12] Float (0.0)
         []> [25, 10] Assign
         ||  +> [25, 8] Identifier (g)
         ||  `> [25, 14] Plus
         ||     +> [25, 12] Identifier (h)
         ||     `> [25, 16] Identifier (i)
         []> [26, 10] Assign
             +> [26, 8] Identifier (i)
             `> [26, 55] Modulo
                +> [26, 21] Multiply
                |  +> [26, 17] Plus
                |  |  +> [26, 13] Float (5.5)
                |  |  `> [26, 19] Int (6)
                |  `> [26, 31] Plus
                |     +> [26, 26] Minus
                |     |  +> [26, 24] Identifier (f)
                |     |  `> [26, 28] Identifier (hh)
                |     `> [26, 52] Divide
                |        +> [26, 41] Plus
                |        |  +> [26, 34] Float (3.0256)
                |        |  `> [26, 43] Float (6.526221)
                |        `> [26, 53] Identifier (g)
                `> [26, 56] Identifier (i)
