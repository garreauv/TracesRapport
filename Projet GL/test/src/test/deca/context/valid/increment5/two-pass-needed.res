DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [13, 0] Program
   +> ListDeclClass [List with 2 elements]
   |  []> [5, 0] DeclClass
   |  ||  +> [5, 6] Identifier (A)
   |  ||  |  definition: type defined at [5, 0], type=A
   |  ||  +> [5, 7] Identifier (Object)
   |  ||  |  definition: type (builtin), type=Object
   |  ||  +> ListDeclField [List with 1 elements]
   |  ||  |  []> [6, 6] DeclField
   |  ||  |      +> [6, 4] Identifier (B)
   |  ||  |      |  definition: type defined at [9, 0], type=B
   |  ||  |      +> [6, 6] Identifier (b)
   |  ||  |      |  definition: field defined at [6, 6], type=B
   |  ||  |      `> NoInitialization
   |  ||  `> ListDeclMethod [List with 0 elements]
   |  []> [9, 0] DeclClass
   |      +> [9, 6] Identifier (B)
   |      |  definition: type defined at [9, 0], type=B
   |      +> [9, 7] Identifier (Object)
   |      |  definition: type (builtin), type=Object
   |      +> ListDeclField [List with 1 elements]
   |      |  []> [10, 6] DeclField
   |      |      +> [10, 4] Identifier (A)
   |      |      |  definition: type defined at [5, 0], type=A
   |      |      +> [10, 6] Identifier (a)
   |      |      |  definition: field defined at [10, 6], type=A
   |      |      `> NoInitialization
   |      `> ListDeclMethod [List with 0 elements]
   `> EmptyMain
