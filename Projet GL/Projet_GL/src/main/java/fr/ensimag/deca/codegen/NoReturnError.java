package fr.ensimag.deca.codegen;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.instructions.ERROR;
import fr.ensimag.ima.pseudocode.instructions.WNL;
import fr.ensimag.ima.pseudocode.instructions.WSTR;

public class NoReturnError extends ExecutionError{
    protected DecacCompiler compiler;

    public NoReturnError(DecacCompiler compiler) {
        super(compiler);
        errorLabel = new Label("NoReturnError");
    }

    public void genCodeError(DecacCompiler compiler){
        compiler.addLabel(errorLabel);
        compiler.addInstruction(new WSTR("No return error"));
        compiler.addInstruction(new WNL());
        compiler.addInstruction(new ERROR());
    }
}