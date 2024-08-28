DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [12, 1] Program
   +> ListDeclClass [List with 2 elements]
   |  []> [5, 0] DeclClass
   |  ||  +> [5, 6] Identifier (A)
   |  ||  |  definition: type defined at [5, 0], type=A
   |  ||  +> [5, 7] Identifier (Object)
   |  ||  |  definition: type (builtin), type=Object
   |  ||  +> ListDeclField [List with 2 elements]
   |  ||  |  []> [6, 8] DeclField
   |  ||  |  ||  +> [6, 4] Identifier (int)
   |  ||  |  ||  |  definition: type (builtin), type=int
   |  ||  |  ||  +> [6, 8] Identifier (a)
   |  ||  |  ||  |  definition: field defined at [6, 8], type=int
   |  ||  |  ||  `> NoInitialization
   |  ||  |  []> [7, 22] DeclField
   |  ||  |      +> [7, 14] Identifier (boolean)
   |  ||  |      |  definition: type (builtin), type=boolean
   |  ||  |      +> [7, 22] Identifier (b)
   |  ||  |      |  definition: field defined at [7, 22], type=boolean
   |  ||  |      `> NoInitialization
   |  ||  `> ListDeclMethod [List with 0 elements]
   |  []> [10, 0] DeclClass
   |      +> [10, 6] Identifier (B)
   |      |  definition: type defined at [10, 0], type=B
   |      +> [10, 8] Identifier (A)
   |      |  definition: type defined at [5, 0], type=A
   |      +> ListDeclField [List with 1 elements]
   |      |  []> [11, 8] DeclField
   |      |      +> [11, 4] Identifier (int)
   |      |      |  definition: type (builtin), type=int
   |      |      +> [11, 8] Identifier (a)
   |      |      |  definition: field defined at [11, 8], type=int
   |      |      `> NoInitialization
   |      `> ListDeclMethod [List with 0 elements]
   `> EmptyMain
