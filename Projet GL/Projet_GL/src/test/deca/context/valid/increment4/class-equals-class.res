DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:30) - verify Main: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:34) - verify Main: end
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [9, 0] Program
   +> ListDeclClass [List with 2 elements]
   |  []> [5, 0] DeclClass
   |  ||  +> [5, 6] Identifier (A)
   |  ||  |  definition: type defined at [5, 0], type=A
   |  ||  +> [5, 7] Identifier (Object)
   |  ||  |  definition: type (builtin), type=Object
   |  ||  +> ListDeclField [List with 0 elements]
   |  ||  `> ListDeclMethod [List with 0 elements]
   |  []> [7, 0] DeclClass
   |      +> [7, 6] Identifier (B)
   |      |  definition: type defined at [7, 0], type=B
   |      +> [7, 7] Identifier (Object)
   |      |  definition: type (builtin), type=Object
   |      +> ListDeclField [List with 0 elements]
   |      `> ListDeclMethod [List with 0 elements]
   `> [9, 0] Main
      +> ListDeclVar [List with 3 elements]
      |  []> [10, 6] DeclVar
      |  ||  +> [10, 4] Identifier (A)
      |  ||  |  definition: type defined at [5, 0], type=A
      |  ||  +> [10, 6] Identifier (a)
      |  ||  |  definition: variable defined at [10, 6], type=A
      |  ||  `> [10, 10] Initialization
      |  ||     `> [10, 10] New
      |  ||        type: A
      |  ||        +> [10, 14] Identifier (A)
      |  ||        |  definition: type defined at [5, 0], type=A
      |  []> [11, 6] DeclVar
      |  ||  +> [11, 4] Identifier (B)
      |  ||  |  definition: type defined at [7, 0], type=B
      |  ||  +> [11, 6] Identifier (b)
      |  ||  |  definition: variable defined at [11, 6], type=B
      |  ||  `> [11, 10] Initialization
      |  ||     `> [11, 10] New
      |  ||        type: B
      |  ||        +> [11, 14] Identifier (B)
      |  ||        |  definition: type defined at [7, 0], type=B
      |  []> [12, 12] DeclVar
      |      +> [12, 4] Identifier (boolean)
      |      |  definition: type (builtin), type=boolean
      |      +> [12, 12] Identifier (c)
      |      |  definition: variable defined at [12, 12], type=boolean
      |      `> [12, 16] Initialization
      |         `> [12, 18] Equals
      |            type: boolean
      |            +> [12, 16] Identifier (a)
      |            |  definition: variable defined at [10, 6], type=A
      |            `> [12, 21] NULL
      |               type: Null
      `> ListInst [List with 1 elements]
         []> [13, 4] IfThenElse
             +> [13, 9] Equals
             |  type: boolean
             |  +> [13, 7] Identifier (a)
             |  |  definition: variable defined at [10, 6], type=A
             |  `> [13, 12] Identifier (b)
             |     definition: variable defined at [11, 6], type=B
             +> ListInst [List with 1 elements]
             |  []> [14, 8] Print
             |      `> ListExpr [List with 1 elements]
             |         []> [14, 14] StringLiteral (ok)
             |             type: string
             `> ListInst [List with 0 elements]
