package fr.ensimag.deca.syntax;

import org.antlr.v4.runtime.ParserRuleContext;


public class EntryError extends DecaRecognitionException {
    private static final long serialVersionUID = 4670163376041273741L;
    private final String name;

    public EntryError(String name, DecaParser recognizer, ParserRuleContext ctx) {
        super(recognizer, ctx);
        this.name = name;
    }

    @Override
    public String getMessage() {
        return name + " is too large.";
    }
}
