DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [15, 1] Program
   +> ListDeclClass [List with 2 elements]
   |  []> [5, 0] DeclClass
   |  ||  +> [5, 6] Identifier (A)
   |  ||  |  definition: type defined at [5, 0], type=A
   |  ||  +> [5, 7] Identifier (Object)
   |  ||  |  definition: type (builtin), type=Object
   |  ||  +> ListDeclField [List with 0 elements]
   |  ||  `> ListDeclMethod [List with 1 elements]
   |  ||     []> [6, 4] DeclMethod
   |  ||         +> [6, 8] Identifier (big)
   |  ||         |  definition: method defined at [6, 4], type=int
   |  ||         +> [6, 4] Identifier (int)
   |  ||         |  definition: type (builtin), type=int
   |  ||         +> ListDeclParam [List with 0 elements]
   |  ||         `> [6, 13] MethodBody
   |  ||            +> ListDeclVar [List with 0 elements]
   |  ||            `> ListInst [List with 1 elements]
   |  ||               []> [7, 8] Return
   |  ||                   `> [7, 15] Float (1.0)
   |  ||                      type: float
   |  []> [11, 0] DeclClass
   |      +> [11, 6] Identifier (B)
   |      |  definition: type defined at [11, 0], type=B
   |      +> [11, 8] Identifier (A)
   |      |  definition: type defined at [5, 0], type=A
   |      +> ListDeclField [List with 0 elements]
   |      `> ListDeclMethod [List with 1 elements]
   |         []> [12, 4] DeclMethod
   |             +> [12, 10] Identifier (big)
   |             |  definition: method defined at [12, 4], type=float
   |             +> [12, 4] Identifier (float)
   |             |  definition: type (builtin), type=float
   |             +> ListDeclParam [List with 0 elements]
   |             `> [12, 15] MethodBody
   |                +> ListDeclVar [List with 0 elements]
   |                `> ListInst [List with 1 elements]
   |                   []> [13, 8] Return
   |                       `> [13, 15] Int (3)
   |                          type: int
   `> EmptyMain
