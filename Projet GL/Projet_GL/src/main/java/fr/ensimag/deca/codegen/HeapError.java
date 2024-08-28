package fr.ensimag.deca.codegen;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.instructions.ADDSP;
import fr.ensimag.ima.pseudocode.instructions.BOV;
import fr.ensimag.ima.pseudocode.instructions.ERROR;
import fr.ensimag.ima.pseudocode.instructions.TSTO;
import fr.ensimag.ima.pseudocode.instructions.WNL;
import fr.ensimag.ima.pseudocode.instructions.WSTR;

public class HeapError extends ExecutionError{

    protected DecacCompiler compiler;

    public HeapError(DecacCompiler compiler) {
        super(compiler);
        errorLabel = new Label("Heap_error");
    }

    public void genCodeError(DecacCompiler compiler) {

        // compiler.addInstruction(new BOV(errorLabel));
        compiler.addLabel(errorLabel);
        compiler.addInstruction(new WSTR("Error: Heap Error, can't allocate"));
        compiler.addInstruction(new WNL());
        compiler.addInstruction(new ERROR());
    }
    
}