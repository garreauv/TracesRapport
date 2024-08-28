`> [10, 0] Program
   +> ListDeclClass [List with 0 elements]
   `> [10, 0] Main
      +> ListDeclVar [List with 1 elements]
      |  []> [11, 8] DeclVar
      |      +> [11, 4] Identifier (int)
      |      +> [11, 8] Identifier (i)
      |      `> NoInitialization
      `> ListInst [List with 4 elements]
         []> [12, 4] IfThenElse
         ||  +> [12, 7] BooleanLiteral (true)
         ||  +> ListInst [List with 1 elements]
         ||  |  []> [13, 10] Assign
         ||  |      +> [13, 8] Identifier (a)
         ||  |      `> [13, 14] Plus
         ||  |         +> [13, 12] Int (1)
         ||  |         `> [13, 15] Int (2)
         ||  `> ListInst [List with 0 elements]
         []> [16, 4] IfThenElse
         ||  +> [16, 8] Lower
         ||  |  +> [16, 7] Identifier (i)
         ||  |  `> [16, 9] Int (1)
         ||  +> ListInst [List with 1 elements]
         ||  |  []> [17, 10] Assign
         ||  |      +> [17, 8] Identifier (i)
         ||  |      `> [17, 13] Minus
         ||  |         +> [17, 12] Identifier (i)
         ||  |         `> [17, 14] Int (1)
         ||  `> ListInst [List with 1 elements]
         ||     []> [19, 10] Assign
         ||         +> [19, 8] Identifier (i)
         ||         `> [19, 12] Int (5)
         []> [22, 4] IfThenElse
         ||  +> [22, 8] Greater
         ||  |  +> [22, 7] Identifier (i)
         ||  |  `> [22, 9] Int (2)
         ||  +> ListInst [List with 2 elements]
         ||  |  []> [23, 8] Print
         ||  |  ||  `> ListExpr [List with 1 elements]
         ||  |  ||     []> [23, 14] StringLiteral (Ok)
         ||  |  []> [24, 10] Assign
         ||  |      +> [24, 8] Identifier (i)
         ||  |      `> [24, 13] Plus
         ||  |         +> [24, 12] Identifier (i)
         ||  |         `> [24, 14] Int (1)
         ||  `> ListInst [List with 1 elements]
         ||     []> [25, 10] IfThenElse
         ||         +> [25, 14] LowerOrEqual
         ||         |  +> [25, 13] Identifier (i)
         ||         |  `> [25, 16] Int (1)
         ||         +> ListInst [List with 1 elements]
         ||         |  []> [26, 10] Assign
         ||         |      +> [26, 8] Identifier (i)
         ||         |      `> [26, 13] Minus
         ||         |         +> [26, 12] Identifier (i)
         ||         |         `> [26, 14] Int (2)
         ||         `> ListInst [List with 1 elements]
         ||            []> [27, 10] IfThenElse
         ||                +> [27, 14] GreaterOrEqual
         ||                |  +> [27, 13] Identifier (i)
         ||                |  `> [27, 16] Int (2)
         ||                +> ListInst [List with 2 elements]
         ||                |  []> [28, 8] Print
         ||                |  ||  `> ListExpr [List with 1 elements]
         ||                |  ||     []> [28, 14] StringLiteral (Ok)
         ||                |  []> [29, 10] Assign
         ||                |      +> [29, 8] Identifier (i)
         ||                |      `> [29, 13] Plus
         ||                |         +> [29, 12] Identifier (i)
         ||                |         `> [29, 14] Int (2)
         ||                `> ListInst [List with 0 elements]
         []> [32, 4] IfThenElse
             +> [32, 8] Equals
             |  +> [32, 7] Identifier (i)
             |  `> [32, 10] Int (2)
             +> ListInst [List with 1 elements]
             |  []> [33, 10] Assign
             |      +> [33, 8] Identifier (i)
             |      `> [33, 12] Int (3)
             `> ListInst [List with 1 elements]
                []> [34, 10] IfThenElse
                    +> [34, 14] GreaterOrEqual
                    |  +> [34, 13] Identifier (i)
                    |  `> [34, 16] Int (2)
                    +> ListInst [List with 2 elements]
                    |  []> [35, 8] Print
                    |  ||  `> ListExpr [List with 1 elements]
                    |  ||     []> [35, 14] StringLiteral (Ok)
                    |  []> [36, 10] Assign
                    |      +> [36, 8] Identifier (i)
                    |      `> [36, 13] Plus
                    |         +> [36, 12] Identifier (i)
                    |         `> [36, 14] Int (2)
                    `> ListInst [List with 2 elements]
                       []> [38, 8] Print
                       ||  `> ListExpr [List with 1 elements]
                       ||     []> [38, 14] StringLiteral (Ok)
                       []> [39, 10] Assign
                           +> [39, 8] Identifier (i)
                           `> [39, 12] Int (1)
