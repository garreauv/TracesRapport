DEBUG fr.ensimag.deca.syntax.AbstractDecaParser$1.reportError(AbstractDecaParser.java:86) - Error found by ANTLR
INFO  fr.ensimag.deca.syntax.DecacErrorListner.syntaxError(DecacErrorListner.java:42) - Use token info for Location
DEBUG fr.ensimag.deca.syntax.AbstractDecaParser.parseProgramAndManageErrors(AbstractDecaParser.java:44) - ParseCancellationException raised while compiling file:
org.antlr.v4.runtime.misc.ParseCancellationException
	at fr.ensimag.deca.syntax.DecacErrorListner.syntaxError(DecacErrorListner.java:62)
	at org.antlr.v4.runtime.ProxyErrorListener.syntaxError(ProxyErrorListener.java:41)
	at org.antlr.v4.runtime.Parser.notifyErrorListeners(Parser.java:544)
	at org.antlr.v4.runtime.DefaultErrorStrategy.reportInputMismatch(DefaultErrorStrategy.java:327)
	at org.antlr.v4.runtime.DefaultErrorStrategy.reportError(DefaultErrorStrategy.java:139)
	at fr.ensimag.deca.syntax.AbstractDecaParser$1.reportError(AbstractDecaParser.java:94)
	at fr.ensimag.deca.syntax.DecaParser.ident(DecaParser.java:2508)
	at fr.ensimag.deca.syntax.DecaParser.class_extension(DecaParser.java:2665)
	at fr.ensimag.deca.syntax.DecaParser.class_decl(DecaParser.java:2610)
	at fr.ensimag.deca.syntax.DecaParser.list_classes(DecaParser.java:2550)
	at fr.ensimag.deca.syntax.DecaParser.prog(DecaParser.java:161)
	at fr.ensimag.deca.syntax.DecaParser.parseProgram(DecaParser.java:127)
	at fr.ensimag.deca.syntax.AbstractDecaParser.parseProgramAndManageErrors(AbstractDecaParser.java:40)
	at fr.ensimag.deca.context.ManualTestContext.main(ManualTestContext.java:29)
Caused by: fr.ensimag.deca.tree.LocationException: mismatched input 'print' expecting IDENT
	at fr.ensimag.deca.syntax.DecacErrorListner.syntaxError(DecacErrorListner.java:63)
	... 13 more
