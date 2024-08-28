DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:48) - verify program: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:30) - verify Main: start
DEBUG fr.ensimag.deca.tree.Main.verifyMain(Main.java:34) - verify Main: end
DEBUG fr.ensimag.deca.tree.Program.verifyProgram(Program.java:53) - verify program: end
`> [5, 0] Program
   +> ListDeclClass [List with 0 elements]
   `> [5, 0] Main
      +> ListDeclVar [List with 0 elements]
      `> ListInst [List with 1 elements]
         []> [6, 4] IfThenElse
             +> [6, 14] Greater
             |  type: boolean
             |  +> [6, 8] BooleanLiteral (false)
             |  |  type: boolean
             |  `> [6, 16] BooleanLiteral (true)
             |     type: boolean
             +> ListInst [List with 1 elements]
             |  []> [7, 8] Print
             |      `> ListExpr [List with 1 elements]
             |         []> [7, 14] StringLiteral (error)
             |             type: string
             `> ListInst [List with 0 elements]
