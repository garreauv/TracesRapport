DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [18, 1] Program
   +> ListDeclClass [List with 2 elements]
   |  []> [3, 0] DeclClass
   |  ||  +> [3, 6] Identifier (A)
   |  ||  |  definition: type defined at [3, 0], type=A
   |  ||  +> [3, 7] Identifier (Object)
   |  ||  |  definition: type (builtin), type=Object
   |  ||  +> ListDeclField [List with 1 elements]
   |  ||  |  []> [4, 18] DeclField
   |  ||  |      +> [4, 14] Identifier (int)
   |  ||  |      |  definition: type (builtin), type=int
   |  ||  |      +> [4, 18] Identifier (x)
   |  ||  |      |  definition: field defined at [4, 18], type=int
   |  ||  |      `> [4, 20] Initialization
   |  ||  |         `> [4, 22] Int (3)
   |  ||  |            type: int
   |  ||  `> ListDeclMethod [List with 1 elements]
   |  ||     []> [6, 4] DeclMethod
   |  ||         +> [6, 8] Identifier (getX)
   |  ||         |  definition: method defined at [6, 4], type=int
   |  ||         +> [6, 4] Identifier (int)
   |  ||         |  definition: type (builtin), type=int
   |  ||         +> ListDeclParam [List with 0 elements]
   |  ||         `> [6, 14] MethodBody
   |  ||            +> ListDeclVar [List with 0 elements]
   |  ||            `> ListInst [List with 1 elements]
   |  ||               []> [7, 8] Return
   |  ||                   `> [7, 15] Selection
   |  ||                      type: int
   |  ||                      +> [7, 15] this
   |  ||                      |  type: A
   |  ||                      `> [7, 20] Identifier (x)
   |  ||                         definition: field defined at [4, 18], type=int
   |  []> [11, 0] DeclClass
   |      +> [11, 6] Identifier (B)
   |      |  definition: type defined at [11, 0], type=B
   |      +> [11, 7] Identifier (Object)
   |      |  definition: type (builtin), type=Object
   |      +> ListDeclField [List with 2 elements]
   |      |  []> [12, 18] DeclField
   |      |  ||  +> [12, 14] Identifier (int)
   |      |  ||  |  definition: type (builtin), type=int
   |      |  ||  +> [12, 18] Identifier (y)
   |      |  ||  |  definition: field defined at [12, 18], type=int
   |      |  ||  `> NoInitialization
   |      |  []> [13, 6] DeclField
   |      |      +> [13, 4] Identifier (A)
   |      |      |  definition: type defined at [3, 0], type=A
   |      |      +> [13, 6] Identifier (a)
   |      |      |  definition: field defined at [13, 6], type=A
   |      |      `> [13, 8] Initialization
   |      |         `> [13, 10] New
   |      |            type: A
   |      |            +> [13, 14] Identifier (A)
   |      |            |  definition: type defined at [3, 0], type=A
   |      `> ListDeclMethod [List with 1 elements]
   |         []> [15, 4] DeclMethod
   |             +> [15, 9] Identifier (setY)
   |             |  definition: method defined at [15, 4], type=void
   |             +> [15, 4] Identifier (void)
   |             |  definition: type (builtin), type=void
   |             +> ListDeclParam [List with 0 elements]
   |             `> [15, 15] MethodBody
   |                +> ListDeclVar [List with 0 elements]
   |                `> ListInst [List with 1 elements]
   |                   []> [16, 15] Assign
   |                       type: int
   |                       +> [16, 8] Selection
   |                       |  type: int
   |                       |  +> [16, 8] this
   |                       |  |  type: B
   |                       |  `> [16, 13] Identifier (y)
   |                       |     definition: field defined at [12, 18], type=int
   |                       `> [16, 17] MethodCall
   |                          type: int
   |                          +> [16, 17] Identifier (a)
   |                          |  definition: field defined at [13, 6], type=A
   |                          +> [16, 19] Identifier (getX)
   |                          |  definition: method defined at [6, 4], type=int
   |                          `> [16, 24] ListExpr [List with 0 elements]
   `> EmptyMain
