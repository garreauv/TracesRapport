DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:30) - verify Main: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:34) - verify Main: end
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [5, 0] Program
   +> ListDeclClass [List with 0 elements]
   `> [5, 0] Main
      +> ListDeclVar [List with 1 elements]
      |  []> [6, 8] DeclVar
      |      +> [6, 4] Identifier (int)
      |      |  definition: type (builtin), type=int
      |      +> [6, 8] Identifier (a)
      |      |  definition: variable defined at [6, 8], type=int
      |      `> NoInitialization
      `> ListInst [List with 1 elements]
         []> [8, 7] Assign
             type: int
             +> [8, 5] Identifier (a)
             |  definition: variable defined at [6, 8], type=int
             `> [8, 9] ReadInt
                type: int
