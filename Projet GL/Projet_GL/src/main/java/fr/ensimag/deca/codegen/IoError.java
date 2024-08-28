package fr.ensimag.deca.codegen;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.instructions.ADDSP;
import fr.ensimag.ima.pseudocode.instructions.BOV;
import fr.ensimag.ima.pseudocode.instructions.ERROR;
import fr.ensimag.ima.pseudocode.instructions.TSTO;
import fr.ensimag.ima.pseudocode.instructions.WNL;
import fr.ensimag.ima.pseudocode.instructions.WSTR;

public class IoError extends ExecutionError{

    protected DecacCompiler compiler;

    public IoError(DecacCompiler compiler) {
        super(compiler);
        errorLabel = new Label("io_error");
    }

    public void genCodeError(DecacCompiler compiler) {
        compiler.addLabel(errorLabel);
        compiler.addInstruction(new WSTR("Error: Input/Output Error"));
        compiler.addInstruction(new WNL());
        compiler.addInstruction(new ERROR());
    }
    
}