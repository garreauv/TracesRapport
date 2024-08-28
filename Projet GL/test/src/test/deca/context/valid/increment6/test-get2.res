DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:30) - verify Main: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:34) - verify Main: end
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [13, 0] Program
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
   |             +> [8, 8] Identifier (getX)
   |             |  definition: method defined at [8, 4], type=int
   |             +> [8, 4] Identifier (int)
   |             |  definition: type (builtin), type=int
   |             +> ListDeclParam [List with 0 elements]
   |             `> [8, 14] MethodBody
   |                +> ListDeclVar [List with 0 elements]
   |                `> ListInst [List with 1 elements]
   |                   []> [9, 8] Return
   |                       `> [9, 15] Selection
   |                          type: int
   |                          +> [9, 15] this
   |                          |  type: A
   |                          `> [9, 20] Identifier (x)
   |                             definition: field defined at [6, 18], type=int
   `> [13, 0] Main
      +> ListDeclVar [List with 2 elements]
      |  []> [14, 6] DeclVar
      |  ||  +> [14, 4] Identifier (A)
      |  ||  |  definition: type defined at [5, 0], type=A
      |  ||  +> [14, 6] Identifier (a)
      |  ||  |  definition: variable defined at [14, 6], type=A
      |  ||  `> [14, 10] Initialization
      |  ||     `> [14, 10] New
      |  ||        type: A
      |  ||        +> [14, 14] Identifier (A)
      |  ||        |  definition: type defined at [5, 0], type=A
      |  []> [16, 8] DeclVar
      |      +> [16, 4] Identifier (int)
      |      |  definition: type (builtin), type=int
      |      +> [16, 8] Identifier (x)
      |      |  definition: variable defined at [16, 8], type=int
      |      `> [16, 12] Initialization
      |         `> [16, 12] MethodCall
      |            type: int
      |            +> [16, 12] Identifier (a)
      |            |  definition: variable defined at [14, 6], type=A
      |            +> [16, 14] Identifier (getX)
      |            |  definition: method defined at [8, 4], type=int
      |            `> [16, 19] ListExpr [List with 0 elements]
      `> ListInst [List with 0 elements]
