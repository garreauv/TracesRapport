DEBUG fr.ensimag.deca.syntax.AbstractDecaParser$1.reportError(AbstractDecaParser.java:86) - Error found by ANTLR
INFO  fr.ensimag.deca.syntax.DecacErrorListner.syntaxError(DecacErrorListner.java:42) - Use token info for Location
DEBUG fr.ensimag.deca.syntax.AbstractDecaParser.parseProgramAndManageErrors(AbstractDecaParser.java:44) - ParseCancellationException raised while compiling file:
org.antlr.v4.runtime.misc.ParseCancellationException
	at fr.ensimag.deca.syntax.DecacErrorListner.syntaxError(DecacErrorListner.java:62)
	at org.antlr.v4.runtime.ProxyErrorListener.syntaxError(ProxyErrorListener.java:41)
	at org.antlr.v4.runtime.Parser.notifyErrorListeners(Parser.java:544)
	at org.antlr.v4.runtime.DefaultErrorStrategy.reportNoViableAlternative(DefaultErrorStrategy.java:310)
	at org.antlr.v4.runtime.DefaultErrorStrategy.reportError(DefaultErrorStrategy.java:136)
	at fr.ensimag.deca.syntax.AbstractDecaParser$1.reportError(AbstractDecaParser.java:94)
	at fr.ensimag.deca.syntax.DecaParser.class_body(DecaParser.java:2766)
	at fr.ensimag.deca.syntax.DecaParser.class_decl(DecaParser.java:2614)
	at fr.ensimag.deca.syntax.DecaParser.list_classes(DecaParser.java:2550)
	at fr.ensimag.deca.syntax.DecaParser.prog(DecaParser.java:161)
	at fr.ensimag.deca.syntax.DecaParser.parseProgram(DecaParser.java:127)
	at fr.ensimag.deca.syntax.AbstractDecaParser.parseProgramAndManageErrors(AbstractDecaParser.java:40)
	at fr.ensimag.deca.context.ManualTestContext.main(ManualTestContext.java:29)
Caused by: fr.ensimag.deca.tree.LocationException: no viable alternative at input 'publicvoiderr'
	at fr.ensimag.deca.syntax.DecacErrorListner.syntaxError(DecacErrorListner.java:63)
	... 12 more
