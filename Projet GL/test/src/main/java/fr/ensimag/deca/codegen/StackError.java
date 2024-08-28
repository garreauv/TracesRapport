package fr.ensimag.deca.codegen;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.instructions.ADDSP;
import fr.ensimag.ima.pseudocode.instructions.BOV;
import fr.ensimag.ima.pseudocode.instructions.ERROR;
import fr.ensimag.ima.pseudocode.instructions.TSTO;
import fr.ensimag.ima.pseudocode.instructions.WNL;
import fr.ensimag.ima.pseudocode.instructions.WSTR;

public class StackError extends ExecutionError{

    protected DecacCompiler compiler;

    public StackError(DecacCompiler compiler) {
        super(compiler);
        errorLabel = new Label("stack_overflow_error");
    }

    public void genCodeError(DecacCompiler compiler) {

        // compiler.addInstructionToTop(new ADDSP(compiler.getStackPointer()));
        // compiler.addInstructionToTop(new BOV(errorLabel));
        // compiler.addInstructionToTop(new TSTO(compiler.getStackPointer()));

        compiler.addLabel(errorLabel);
        compiler.addInstruction(new WSTR("Error: Stack Overflow"));
        compiler.addInstruction(new WNL());
        compiler.addInstruction(new ERROR());
    }
    
}