package fr.ensimag.ima.pseudocode.instructions;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.BinaryInstructionDValToReg;
import fr.ensimag.ima.pseudocode.DVal;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.ima.pseudocode.Register;

/**
 * @author Ensimag
 * @date 01/01/2023
 */
public class LOAD extends BinaryInstructionDValToReg {

    public LOAD(DVal op1, GPRegister op2) {
        super(op1, op2);
    }

    public LOAD(int i, GPRegister r) {
        this(new ImmediateInteger(i), r);
    }

    @Override
    public void pushToStack(DecacCompiler compiler){
        if (compiler.getNCurrRegister() >= compiler.getnMaxRegister()){

            compiler.incrementPush();

            compiler.addInstruction(new PUSH(Register.getR(compiler.getnMaxRegister()-2)));

            compiler.decrementNCurrRegister();

            setOperand2(Register.getR(compiler.getNCurrRegister()));

            compiler.addInstruction(new LOAD(Register.getR(compiler.getNCurrRegister()), Register.getR(compiler.getnMaxRegister()-2)));

            compiler.incrementPoppedToStack();

        }
    }


}
