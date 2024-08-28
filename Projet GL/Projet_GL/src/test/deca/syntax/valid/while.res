`> [10, 0] Program
   +> ListDeclClass [List with 0 elements]
   `> [10, 0] Main
      +> ListDeclVar [List with 1 elements]
      |  []> [11, 8] DeclVar
      |      +> [11, 4] Identifier (int)
      |      +> [11, 8] Identifier (i)
      |      `> NoInitialization
      `> ListInst [List with 9 elements]
         []> [12, 4] While
         ||  +> [12, 10] BooleanLiteral (true)
         ||  `> ListInst [List with 1 elements]
         ||     []> [13, 10] Assign
         ||         +> [13, 8] Identifier (a)
         ||         `> [13, 14] Plus
         ||            +> [13, 12] Int (1)
         ||            `> [13, 15] Int (2)
         []> [16, 4] While
         ||  +> [16, 11] Lower
         ||  |  +> [16, 10] Identifier (i)
         ||  |  `> [16, 12] Int (1)
         ||  `> ListInst [List with 1 elements]
         ||     []> [17, 10] Assign
         ||         +> [17, 8] Identifier (i)
         ||         `> [17, 13] Minus
         ||            +> [17, 12] Identifier (i)
         ||            `> [17, 14] Int (1)
         []> [20, 4] While
         ||  +> [20, 11] Greater
         ||  |  +> [20, 10] Identifier (i)
         ||  |  `> [20, 12] Int (2)
         ||  `> ListInst [List with 2 elements]
         ||     []> [21, 8] Print
         ||     ||  `> ListExpr [List with 1 elements]
         ||     ||     []> [21, 14] StringLiteral (Ok)
         ||     []> [22, 10] Assign
         ||         +> [22, 8] Identifier (i)
         ||         `> [22, 13] Plus
         ||            +> [22, 12] Identifier (i)
         ||            `> [22, 14] Int (1)
         []> [26, 4] While
         ||  +> [26, 11] LowerOrEqual
         ||  |  +> [26, 10] Identifier (i)
         ||  |  `> [26, 13] Int (1)
         ||  `> ListInst [List with 1 elements]
         ||     []> [27, 10] Assign
         ||         +> [27, 8] Identifier (i)
         ||         `> [27, 13] Minus
         ||            +> [27, 12] Identifier (i)
         ||            `> [27, 14] Int (2)
         []> [30, 4] While
         ||  +> [30, 11] GreaterOrEqual
         ||  |  +> [30, 10] Identifier (i)
         ||  |  `> [30, 13] Int (2)
         ||  `> ListInst [List with 2 elements]
         ||     []> [31, 8] Print
         ||     ||  `> ListExpr [List with 1 elements]
         ||     ||     []> [31, 14] StringLiteral (Ok)
         ||     []> [32, 10] Assign
         ||         +> [32, 8] Identifier (i)
         ||         `> [32, 13] Plus
         ||            +> [32, 12] Identifier (i)
         ||            `> [32, 14] Int (2)
         []> [35, 4] While
         ||  +> [35, 11] Equals
         ||  |  +> [35, 10] Identifier (i)
         ||  |  `> [35, 13] Int (2)
         ||  `> ListInst [List with 1 elements]
         ||     []> [36, 10] Assign
         ||         +> [36, 8] Identifier (i)
         ||         `> [36, 12] Int (3)
         []> [39, 4] While
         ||  +> [39, 11] NotEquals
         ||  |  +> [39, 10] Identifier (i)
         ||  |  `> [39, 13] Int (2)
         ||  `> ListInst [List with 2 elements]
         ||     []> [40, 8] Print
         ||     ||  `> ListExpr [List with 1 elements]
         ||     ||     []> [40, 14] StringLiteral (Ok)
         ||     []> [41, 10] Assign
         ||         +> [41, 8] Identifier (i)
         ||         `> [41, 13] Plus
         ||            +> [41, 12] Identifier (i)
         ||            `> [41, 14] Int (2)
         []> [44, 5] Assign
         ||  +> [44, 4] Identifier (i)
         ||  `> [44, 6] Int (0)
         []> [45, 4] While
             +> [45, 10] Not
             |  `> [45, 11] Int (1)
             `> ListInst [List with 2 elements]
                []> [46, 8] Print
                ||  `> ListExpr [List with 1 elements]
                ||     []> [46, 14] StringLiteral (Ok)
                []> [47, 10] Assign
                    +> [47, 8] Identifier (i)
                    `> [47, 12] Int (1)
