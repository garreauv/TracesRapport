DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [13, 9] Program
   +> ListDeclClass [List with 3 elements]
   |  []> [5, 0] DeclClass
   |  ||  +> [5, 6] Identifier (A)
   |  ||  |  definition: type defined at [5, 0], type=A
   |  ||  +> [5, 7] Identifier (Object)
   |  ||  |  definition: type (builtin), type=Object
   |  ||  +> ListDeclField [List with 1 elements]
   |  ||  |  []> [6, 8] DeclField
   |  ||  |      +> [6, 4] Identifier (int)
   |  ||  |      |  definition: type (builtin), type=int
   |  ||  |      +> [6, 8] Identifier (a)
   |  ||  |      |  definition: field defined at [6, 8], type=int
   |  ||  |      `> NoInitialization
   |  ||  `> ListDeclMethod [List with 0 elements]
   |  []> [9, 0] DeclClass
   |  ||  +> [9, 6] Identifier (B)
   |  ||  |  definition: type defined at [9, 0], type=B
   |  ||  +> [9, 8] Identifier (A)
   |  ||  |  definition: type defined at [5, 0], type=A
   |  ||  +> ListDeclField [List with 1 elements]
   |  ||  |  []> [10, 10] DeclField
   |  ||  |      +> [10, 4] Identifier (float)
   |  ||  |      |  definition: type (builtin), type=float
   |  ||  |      +> [10, 10] Identifier (b)
   |  ||  |      |  definition: field defined at [10, 10], type=float
   |  ||  |      `> NoInitialization
   |  ||  `> ListDeclMethod [List with 0 elements]
   |  []> [13, 0] DeclClass
   |      +> [13, 6] Identifier (C)
   |      |  definition: type defined at [13, 0], type=C
   |      +> [13, 7] Identifier (Object)
   |      |  definition: type (builtin), type=Object
   |      +> ListDeclField [List with 0 elements]
   |      `> ListDeclMethod [List with 0 elements]
   `> EmptyMain
