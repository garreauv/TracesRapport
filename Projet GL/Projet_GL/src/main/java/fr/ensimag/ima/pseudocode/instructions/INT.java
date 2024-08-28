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
public class INT extends BinaryInstructionDValToReg {

    public INT(DVal op1, GPRegister op2) {
        super(op1, op2);
    }
    
    public void popFromStack(DecacCompiler compiler){
        if (compiler.getPoppedToStack() >= 1){
            compiler.decrementPush();            
            compiler.addInstruction(new LOAD(Register.getR(compiler.getnMaxRegister()-2), Register.getR(compiler.getnMaxRegister()-1)));
            compiler.addInstruction(new POP(Register.getR(compiler.getnMaxRegister()-2)));
            compiler.decrementPoppedToStack();
            compiler.addNCurrRegister();

        }
    }

    @Override
    public void pushToStack(DecacCompiler compiler){
        if (compiler.getPoppedToStack() >= 1){
            setOperand1(Register.getR(compiler.getnMaxRegister()-1));
            setOperand2(Register.getR(compiler.getnMaxRegister()-2));
        }
    }

}
