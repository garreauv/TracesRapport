DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:30) - verify Main: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:34) - verify Main: end
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [9, 0] Program
   +> ListDeclClass [List with 1 elements]
   |  []> [5, 0] DeclClass
   |      +> [5, 6] Identifier (A)
   |      |  definition: type defined at [5, 0], type=A
   |      +> [5, 7] Identifier (Object)
   |      |  definition: type (builtin), type=Object
   |      +> ListDeclField [List with 1 elements]
   |      |  []> [6, 8] DeclField
   |      |      +> [6, 4] Identifier (int)
   |      |      |  definition: type (builtin), type=int
   |      |      +> [6, 8] Identifier (x)
   |      |      |  definition: field defined at [6, 8], type=int
   |      |      `> NoInitialization
   |      `> ListDeclMethod [List with 0 elements]
   `> [9, 0] Main
      +> ListDeclVar [List with 1 elements]
      |  []> [10, 6] DeclVar
      |      +> [10, 4] Identifier (A)
      |      |  definition: type defined at [5, 0], type=A
      |      +> [10, 6] Identifier (a)
      |      |  definition: variable defined at [10, 6], type=A
      |      `> [10, 10] Initialization
      |         `> [10, 10] New
      |            type: A
      |            +> [10, 14] Identifier (A)
      |            |  definition: type defined at [5, 0], type=A
      `> ListInst [List with 1 elements]
         []> [11, 4] IfThenElse
             +> [11, 9] Equals
             |  type: boolean
             |  +> [11, 7] Identifier (a)
             |  |  definition: variable defined at [10, 6], type=A
             |  `> [11, 12] NULL
             |     type: Null
             +> ListInst [List with 1 elements]
             |  []> [12, 8] Print
             |      `> ListExpr [List with 1 elements]
             |         []> [12, 14] StringLiteral (a nul)
             |             type: string
             `> ListInst [List with 1 elements]
                []> [15, 8] Print
                    `> ListExpr [List with 1 elements]
                       []> [15, 14] StringLiteral (a pas nul)
                           type: string
