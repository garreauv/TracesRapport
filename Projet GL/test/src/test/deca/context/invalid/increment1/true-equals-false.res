DEBUG fr.ensimag.deca.syntax.AbstractDecaParser$1.reportError(AbstractDecaParser.java:86) - Error found by ANTLR
INFO  fr.ensimag.deca.syntax.DecacErrorListner.syntaxError(DecacErrorListner.java:42) - Use token info for Location
DEBUG fr.ensimag.deca.syntax.AbstractDecaParser.parseProgramAndManageErrors(AbstractDecaParser.java:44) - ParseCancellationException raised while compiling file:
org.antlr.v4.runtime.misc.ParseCancellationException
	at fr.ensimag.deca.syntax.DecacErrorListner.syntaxError(DecacErrorListner.java:62)
	at org.antlr.v4.runtime.ProxyErrorListener.syntaxError(ProxyErrorListener.java:41)
	at org.antlr.v4.runtime.Parser.notifyErrorListeners(Parser.java:544)
	at fr.ensimag.deca.syntax.AbstractDecaParser$1.reportError(AbstractDecaParser.java:92)
	at fr.ensimag.deca.syntax.DecaParser.assign_expr(DecaParser.java:1167)
	at fr.ensimag.deca.syntax.DecaParser.expr(DecaParser.java:1082)
	at fr.ensimag.deca.syntax.DecaParser.inst(DecaParser.java:658)
	at fr.ensimag.deca.syntax.DecaParser.list_inst(DecaParser.java:565)
	at fr.ensimag.deca.syntax.DecaParser.block(DecaParser.java:272)
	at fr.ensimag.deca.syntax.DecaParser.main(DecaParser.java:217)
	at fr.ensimag.deca.syntax.DecaParser.prog(DecaParser.java:163)
	at fr.ensimag.deca.syntax.DecaParser.parseProgram(DecaParser.java:127)
	at fr.ensimag.deca.syntax.AbstractDecaParser.parseProgramAndManageErrors(AbstractDecaParser.java:40)
	at fr.ensimag.deca.context.ManualTestContext.main(ManualTestContext.java:29)
Caused by: fr.ensimag.deca.tree.LocationException: left-hand side of assignment is not an lvalue
	at fr.ensimag.deca.syntax.DecacErrorListner.syntaxError(DecacErrorListner.java:63)
	... 13 more
