package fr.ensimag.deca.codegen;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.instructions.ERROR;
import fr.ensimag.ima.pseudocode.instructions.WNL;
import fr.ensimag.ima.pseudocode.instructions.WSTR;
import fr.ensimag.ima.pseudocode.Label;

public class DeferencementNull extends ExecutionError{
    protected DecacCompiler compiler;

    
    public DeferencementNull(DecacCompiler compiler){
        super(compiler);
        errorLabel = new Label("NullDeferenceError");
    }

    public void genCodeError(DecacCompiler compiler){
        compiler.addLabel(errorLabel);
        compiler.addInstruction(new WSTR("Error: deferencement null"));
        compiler.addInstruction(new WNL());
        compiler.addInstruction(new ERROR());
    }
}