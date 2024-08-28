DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [41, 1] Program
   +> ListDeclClass [List with 2 elements]
   |  []> [5, 0] DeclClass
   |  ||  +> [5, 6] Identifier (A)
   |  ||  |  definition: type defined at [5, 0], type=A
   |  ||  +> [5, 7] Identifier (Object)
   |  ||  |  definition: type (builtin), type=Object
   |  ||  +> ListDeclField [List with 1 elements]
   |  ||  |  []> [6, 18] DeclField
   |  ||  |      +> [6, 14] Identifier (int)
   |  ||  |      |  definition: type (builtin), type=int
   |  ||  |      +> [6, 18] Identifier (a)
   |  ||  |      |  definition: field defined at [6, 18], type=int
   |  ||  |      `> NoInitialization
   |  ||  `> ListDeclMethod [List with 4 elements]
   |  ||     []> [8, 4] DeclMethod
   |  ||     ||  +> [8, 9] Identifier (hello)
   |  ||     ||  |  definition: method defined at [8, 4], type=void
   |  ||     ||  +> [8, 4] Identifier (void)
   |  ||     ||  |  definition: type (builtin), type=void
   |  ||     ||  +> ListDeclParam [List with 0 elements]
   |  ||     ||  `> [8, 16] MethodBody
   |  ||     ||     +> ListDeclVar [List with 0 elements]
   |  ||     ||     `> ListInst [List with 1 elements]
   |  ||     ||        []> [9, 8] Print
   |  ||     ||            `> ListExpr [List with 1 elements]
   |  ||     ||               []> [9, 14] StringLiteral (Hello)
   |  ||     ||                   type: string
   |  ||     []> [12, 4] DeclMethod
   |  ||     ||  +> [12, 8] Identifier (oui)
   |  ||     ||  |  definition: method defined at [12, 4], type=int
   |  ||     ||  +> [12, 4] Identifier (int)
   |  ||     ||  |  definition: type (builtin), type=int
   |  ||     ||  +> ListDeclParam [List with 0 elements]
   |  ||     ||  `> [12, 13] MethodBody
   |  ||     ||     +> ListDeclVar [List with 0 elements]
   |  ||     ||     `> ListInst [List with 1 elements]
   |  ||     ||        []> [13, 8] Return
   |  ||     ||            `> [13, 15] Int (1)
   |  ||     ||               type: int
   |  ||     []> [16, 4] DeclMethod
   |  ||     ||  +> [16, 10] Identifier (ok)
   |  ||     ||  |  definition: method defined at [16, 4], type=float
   |  ||     ||  +> [16, 4] Identifier (float)
   |  ||     ||  |  definition: type (builtin), type=float
   |  ||     ||  +> ListDeclParam [List with 0 elements]
   |  ||     ||  `> [16, 14] MethodBody
   |  ||     ||     +> ListDeclVar [List with 0 elements]
   |  ||     ||     `> ListInst [List with 1 elements]
   |  ||     ||        []> [17, 8] Return
   |  ||     ||            `> [17, 15] Float (3.2)
   |  ||     ||               type: float
   |  ||     []> [20, 4] DeclMethod
   |  ||         +> [20, 12] Identifier (b)
   |  ||         |  definition: method defined at [20, 4], type=boolean
   |  ||         +> [20, 4] Identifier (boolean)
   |  ||         |  definition: type (builtin), type=boolean
   |  ||         +> ListDeclParam [List with 0 elements]
   |  ||         `> [20, 15] MethodBody
   |  ||            +> ListDeclVar [List with 0 elements]
   |  ||            `> ListInst [List with 1 elements]
   |  ||               []> [21, 8] Return
   |  ||                   `> [21, 15] BooleanLiteral (true)
   |  ||                      type: boolean
   |  []> [25, 0] DeclClass
   |      +> [25, 6] Identifier (B)
   |      |  definition: type defined at [25, 0], type=B
   |      +> [25, 8] Identifier (A)
   |      |  definition: type defined at [5, 0], type=A
   |      +> ListDeclField [List with 0 elements]
   |      `> ListDeclMethod [List with 4 elements]
   |         []> [26, 4] DeclMethod
   |         ||  +> [26, 9] Identifier (hello)
   |         ||  |  definition: method defined at [26, 4], type=void
   |         ||  +> [26, 4] Identifier (void)
   |         ||  |  definition: type (builtin), type=void
   |         ||  +> ListDeclParam [List with 0 elements]
   |         ||  `> [26, 16] MethodBody
   |         ||     +> ListDeclVar [List with 0 elements]
   |         ||     `> ListInst [List with 1 elements]
   |         ||        []> [27, 8] Print
   |         ||            `> ListExpr [List with 1 elements]
   |         ||               []> [27, 14] StringLiteral (idk why you say goobye i say hello)
   |         ||                   type: string
   |         []> [30, 4] DeclMethod
   |         ||  +> [30, 8] Identifier (oui)
   |         ||  |  definition: method defined at [30, 4], type=int
   |         ||  +> [30, 4] Identifier (int)
   |         ||  |  definition: type (builtin), type=int
   |         ||  +> ListDeclParam [List with 0 elements]
   |         ||  `> [30, 13] MethodBody
   |         ||     +> ListDeclVar [List with 0 elements]
   |         ||     `> ListInst [List with 1 elements]
   |         ||        []> [31, 8] Return
   |         ||            `> [31, 15] Int (2)
   |         ||               type: int
   |         []> [34, 4] DeclMethod
   |         ||  +> [34, 10] Identifier (ok)
   |         ||  |  definition: method defined at [34, 4], type=float
   |         ||  +> [34, 4] Identifier (float)
   |         ||  |  definition: type (builtin), type=float
   |         ||  +> ListDeclParam [List with 0 elements]
   |         ||  `> [34, 14] MethodBody
   |         ||     +> ListDeclVar [List with 0 elements]
   |         ||     `> ListInst [List with 1 elements]
   |         ||        []> [35, 8] Return
   |         ||            `> [35, 15] Float (1.2)
   |         ||               type: float
   |         []> [38, 4] DeclMethod
   |             +> [38, 12] Identifier (b)
   |             |  definition: method defined at [38, 4], type=boolean
   |             +> [38, 4] Identifier (boolean)
   |             |  definition: type (builtin), type=boolean
   |             +> ListDeclParam [List with 0 elements]
   |             `> [38, 15] MethodBody
   |                +> ListDeclVar [List with 0 elements]
   |                `> ListInst [List with 1 elements]
   |                   []> [39, 8] Return
   |                       `> [39, 15] BooleanLiteral (false)
   |                          type: boolean
   `> EmptyMain
