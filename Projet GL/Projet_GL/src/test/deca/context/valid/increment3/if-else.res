DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [8, 1] Program
   +> ListDeclClass [List with 1 elements]
   |  []> [1, 0] DeclClass
   |      +> [1, 6] Identifier (P)
   |      |  definition: type defined at [1, 0], type=P
   |      +> [1, 8] Identifier (Object)
   |      |  definition: type (builtin), type=Object
   |      +> ListDeclField [List with 2 elements]
   |      |  []> [2, 8] DeclField
   |      |  ||  +> [2, 4] Identifier (int)
   |      |  ||  |  definition: type (builtin), type=int
   |      |  ||  +> [2, 8] Identifier (x)
   |      |  ||  |  definition: field defined at [2, 8], type=int
   |      |  ||  `> NoInitialization
   |      |  []> [3, 8] DeclField
   |      |      +> [3, 4] Identifier (int)
   |      |      |  definition: type (builtin), type=int
   |      |      +> [3, 8] Identifier (y)
   |      |      |  definition: field defined at [3, 8], type=int
   |      |      `> NoInitialization
   |      `> ListDeclMethod [List with 1 elements]
   |         []> [4, 4] DeclMethod
   |             +> [4, 9] Identifier (move)
   |             |  definition: method defined at [4, 4], type=void
   |             +> [4, 4] Identifier (void)
   |             |  definition: type (builtin), type=void
   |             +> ListDeclParam [List with 2 elements]
   |             |  []> [4, 14] DeclParam
   |             |  ||  +> [4, 14] Identifier (int)
   |             |  ||  |  definition: type (builtin), type=int
   |             |  ||  +> [4, 18] Identifier (a)
   |             |  ||  |  definition: parameter defined at [4, 14], type=int
   |             |  []> [4, 21] DeclParam
   |             |      +> [4, 21] Identifier (int)
   |             |      |  definition: type (builtin), type=int
   |             |      +> [4, 25] Identifier (b)
   |             |      |  definition: parameter defined at [4, 21], type=int
   |             `> [4, 28] MethodBody
   |                +> ListDeclVar [List with 0 elements]
   |                `> ListInst [List with 2 elements]
   |                   []> [5, 10] Assign
   |                   ||  type: int
   |                   ||  +> [5, 8] Identifier (x)
   |                   ||  |  definition: field defined at [2, 8], type=int
   |                   ||  `> [5, 14] Plus
   |                   ||     type: int
   |                   ||     +> [5, 12] Identifier (x)
   |                   ||     |  definition: field defined at [2, 8], type=int
   |                   ||     `> [5, 16] Identifier (a)
   |                   ||        definition: parameter defined at [4, 14], type=int
   |                   []> [6, 10] Assign
   |                       type: int
   |                       +> [6, 8] Identifier (y)
   |                       |  definition: field defined at [3, 8], type=int
   |                       `> [6, 14] Plus
   |                          type: int
   |                          +> [6, 12] Identifier (y)
   |                          |  definition: field defined at [3, 8], type=int
   |                          `> [6, 16] Identifier (b)
   |                             definition: parameter defined at [4, 21], type=int
   `> EmptyMain
