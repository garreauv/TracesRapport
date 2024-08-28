DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [11, 1] Program
   +> ListDeclClass [List with 1 elements]
   |  []> [5, 0] DeclClass
   |      +> [5, 6] Identifier (A)
   |      |  definition: type defined at [5, 0], type=A
   |      +> [5, 7] Identifier (Object)
   |      |  definition: type (builtin), type=Object
   |      +> ListDeclField [List with 1 elements]
   |      |  []> [6, 18] DeclField
   |      |      +> [6, 14] Identifier (int)
   |      |      |  definition: type (builtin), type=int
   |      |      +> [6, 18] Identifier (x)
   |      |      |  definition: field defined at [6, 18], type=int
   |      |      `> NoInitialization
   |      `> ListDeclMethod [List with 1 elements]
   |         []> [8, 4] DeclMethod
   |             +> [8, 9] Identifier (m)
   |             |  definition: method defined at [8, 4], type=void
   |             +> [8, 4] Identifier (void)
   |             |  definition: type (builtin), type=void
   |             +> ListDeclParam [List with 1 elements]
   |             |  []> [8, 11] DeclParam
   |             |      +> [8, 11] Identifier (Object)
   |             |      |  definition: type (builtin), type=Object
   |             |      +> [8, 18] Identifier (o)
   |             |      |  definition: parameter defined at [8, 11], type=Object
   |             `> [8, 20] MethodBody
   |                +> ListDeclVar [List with 0 elements]
   |                `> ListInst [List with 1 elements]
   |                   []> [9, 10] Assign
   |                       type: int
   |                       +> [9, 8] Identifier (x)
   |                       |  definition: field defined at [6, 18], type=int
   |                       `> [9, 12] Int (2)
   |                          type: int
   `> EmptyMain
