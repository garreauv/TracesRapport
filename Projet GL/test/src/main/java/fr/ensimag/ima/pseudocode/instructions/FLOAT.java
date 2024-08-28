package fr.ensimag.ima.pseudocode.instructions;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.BinaryInstructionDValToReg;
import fr.ensimag.ima.pseudocode.DVal;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.Register;

/**
 *
 * @author Ensimag
 * @date 01/01/2023
 */
public class FLOAT extends BinaryInstructionDValToReg {

    public FLOAT(DVal op1, GPRegister op2) {
        super(op1, op2);
    }
    
    public void popFromStack(DecacCompiler compiler){
        if (compiler.getPoppedToStack() >= 1){

        }
    }

    @Override
    public void pushToStack(DecacCompiler compiler){
        if (compiler.getPoppedToStack() >= 1){
        }
    }

}
