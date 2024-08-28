package fr.ensimag.deca.codegen;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.instructions.ADDSP;
import fr.ensimag.ima.pseudocode.instructions.BOV;
import fr.ensimag.ima.pseudocode.instructions.ERROR;
import fr.ensimag.ima.pseudocode.instructions.TSTO;
import fr.ensimag.ima.pseudocode.instructions.WNL;
import fr.ensimag.ima.pseudocode.instructions.WSTR;

public class OverFlowError extends ExecutionError{

    protected DecacCompiler compiler;

    public OverFlowError(DecacCompiler compiler) {
        super(compiler);
        errorLabel = new Label("overflow_error");
    }

    public void genCodeError(DecacCompiler compiler) {
        compiler.addLabel(errorLabel);
        compiler.addInstruction(new WSTR("Error: Overflow during arithmetic operation"));
        compiler.addInstruction(new WNL());
        compiler.addInstruction(new ERROR());
    }
    
}