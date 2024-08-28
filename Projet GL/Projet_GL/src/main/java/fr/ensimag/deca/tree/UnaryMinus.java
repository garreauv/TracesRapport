package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.ima.pseudocode.ImmediateFloat;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.*;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;

/**
 * @author gl19
 * @date 01/01/2023
 */
public class UnaryMinus extends AbstractUnaryExpr {

    public UnaryMinus(AbstractExpr operand) {
        super(operand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        Type operandType = this.getOperand().verifyExpr(compiler, localEnv, currentClass);
        if (!(operandType.isInt() || operandType.isFloat())){
            throw new ContextualError("Invalid type for Minus operator"
            + " : expected boolean but got " + operandType.getName().getName(), getLocation());
        }
        this.setType(operandType);
        return operandType;
    }


    @Override
    protected String getOperatorName() {
        return "-";
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler) {
        // Grosse merde
        int storeRegisterNumber = compiler.getNCurrRegister();
        getOperand().codeGenInst(compiler);
        compiler.addNCurrRegister();
        if (getOperand().getType().isInt()) {
            compiler.addInstruction(new LOAD(0, Register.getR(compiler.getNCurrRegister())));
        }
        else if (getOperand().getType().isFloat()) {
            compiler.addInstruction(new LOAD(new ImmediateFloat(0),
                                        Register.getR(compiler.getNCurrRegister())));
        }
        compiler.addInstruction(new ADD(Register.getR(compiler.getNCurrRegister()), Register.getR(storeRegisterNumber)));
        compiler.addInstruction(new OPP(Register.getR(storeRegisterNumber), Register.getR(storeRegisterNumber)));
        compiler.decrementNCurrRegister();
        compiler.setStoreRegister(storeRegisterNumber);


    }

}
