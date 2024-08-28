DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:30) - verify Main: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:34) - verify Main: end
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [7, 0] Program
   +> ListDeclClass [List with 1 elements]
   |  []> [5, 0] DeclClass
   |      +> [5, 6] Identifier (A)
   |      |  definition: type defined at [5, 0], type=A
   |      +> [5, 7] Identifier (Object)
   |      |  definition: type (builtin), type=Object
   |      +> ListDeclField [List with 0 elements]
   |      `> ListDeclMethod [List with 0 elements]
   `> [7, 0] Main
      +> ListDeclVar [List with 1 elements]
      |  []> [8, 6] DeclVar
      |      +> [8, 4] Identifier (A)
      |      |  definition: type defined at [5, 0], type=A
      |      +> [8, 6] Identifier (a)
      |      |  definition: variable defined at [8, 6], type=A
      |      `> [8, 10] Initialization
      |         `> [8, 10] New
      |            type: A
      |            +> [8, 14] Identifier (A)
      |            |  definition: type defined at [5, 0], type=A
      `> ListInst [List with 1 elements]
         []> [9, 6] Assign
             type: A
             +> [9, 4] Identifier (a)
             |  definition: variable defined at [8, 6], type=A
             `> [9, 8] NULL
                type: Null
