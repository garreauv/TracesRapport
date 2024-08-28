DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [25, 1] Program
   +> ListDeclClass [List with 3 elements]
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
   |  ||  +> [9, 6] Identifier (B)
   |  ||  |  definition: type defined at [9, 0], type=B
   |  ||  +> [9, 7] Identifier (Object)
   |  ||  |  definition: type (builtin), type=Object
   |  ||  +> ListDeclField [List with 1 elements]
   |  ||  |  []> [10, 6] DeclField
   |  ||  |      +> [10, 4] Identifier (A)
   |  ||  |      |  definition: type defined at [5, 0], type=A
   |  ||  |      +> [10, 6] Identifier (a)
   |  ||  |      |  definition: field defined at [10, 6], type=A
   |  ||  |      `> NoInitialization
   |  ||  `> ListDeclMethod [List with 0 elements]
   |  []> [13, 0] DeclClass
   |      +> [13, 6] Identifier (Parcours)
   |      |  definition: type defined at [13, 0], type=Parcours
   |      +> [13, 14] Identifier (Object)
   |      |  definition: type (builtin), type=Object
   |      +> ListDeclField [List with 0 elements]
   |      `> ListDeclMethod [List with 2 elements]
   |         []> [14, 4] DeclMethod
   |         ||  +> [14, 9] Identifier (parcoursA)
   |         ||  |  definition: method defined at [14, 4], type=void
   |         ||  +> [14, 4] Identifier (void)
   |         ||  |  definition: type (builtin), type=void
   |         ||  +> ListDeclParam [List with 1 elements]
   |         ||  |  []> [14, 19] DeclParam
   |         ||  |      +> [14, 19] Identifier (A)
   |         ||  |      |  definition: type defined at [5, 0], type=A
   |         ||  |      +> [14, 21] Identifier (a)
   |         ||  |      |  definition: parameter defined at [14, 19], type=A
   |         ||  `> [14, 23] MethodBody
   |         ||     +> ListDeclVar [List with 0 elements]
   |         ||     `> ListInst [List with 1 elements]
   |         ||        []> [15, 8] IfThenElse
   |         ||            +> [15, 13] NotEquals
   |         ||            |  type: boolean
   |         ||            |  +> [15, 11] Identifier (a)
   |         ||            |  |  definition: parameter defined at [14, 19], type=A
   |         ||            |  `> [15, 16] NULL
   |         ||            |     type: Null
   |         ||            +> ListInst [List with 1 elements]
   |         ||            |  []> [16, 12] MethodCall
   |         ||            |      type: void
   |         ||            |      +> [16, 12] this
   |         ||            |      |  type: Parcours
   |         ||            |      +> [16, 12] Identifier (parcoursB)
   |         ||            |      |  definition: method defined at [20, 4], type=void
   |         ||            |      `> ListExpr [List with 1 elements]
   |         ||            |         []> [16, 22] Selection
   |         ||            |             type: B
   |         ||            |             +> [16, 22] Identifier (a)
   |         ||            |             |  definition: parameter defined at [14, 19], type=A
   |         ||            |             `> [16, 24] Identifier (b)
   |         ||            |                definition: field defined at [6, 6], type=B
   |         ||            `> ListInst [List with 0 elements]
   |         []> [20, 4] DeclMethod
   |             +> [20, 9] Identifier (parcoursB)
   |             |  definition: method defined at [20, 4], type=void
   |             +> [20, 4] Identifier (void)
   |             |  definition: type (builtin), type=void
   |             +> ListDeclParam [List with 1 elements]
   |             |  []> [20, 19] DeclParam
   |             |      +> [20, 19] Identifier (B)
   |             |      |  definition: type defined at [9, 0], type=B
   |             |      +> [20, 21] Identifier (b)
   |             |      |  definition: parameter defined at [20, 19], type=B
   |             `> [20, 23] MethodBody
   |                +> ListDeclVar [List with 0 elements]
   |                `> ListInst [List with 1 elements]
   |                   []> [21, 8] IfThenElse
   |                       +> [21, 13] NotEquals
   |                       |  type: boolean
   |                       |  +> [21, 11] Identifier (b)
   |                       |  |  definition: parameter defined at [20, 19], type=B
   |                       |  `> [21, 16] NULL
   |                       |     type: Null
   |                       +> ListInst [List with 1 elements]
   |                       |  []> [22, 12] MethodCall
   |                       |      type: void
   |                       |      +> [22, 12] this
   |                       |      |  type: Parcours
   |                       |      +> [22, 12] Identifier (parcoursA)
   |                       |      |  definition: method defined at [14, 4], type=void
   |                       |      `> ListExpr [List with 1 elements]
   |                       |         []> [22, 22] Selection
   |                       |             type: A
   |                       |             +> [22, 22] Identifier (b)
   |                       |             |  definition: parameter defined at [20, 19], type=B
   |                       |             `> [22, 24] Identifier (a)
   |                       |                definition: field defined at [10, 6], type=A
   |                       `> ListInst [List with 0 elements]
   `> EmptyMain
