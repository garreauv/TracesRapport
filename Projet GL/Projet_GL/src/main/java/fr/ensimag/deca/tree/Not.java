package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.*;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;

/**
 *
 * @author gl19
 * @date 01/01/2023
 */
public class Not extends AbstractUnaryExpr {

    public Not(AbstractExpr operand) {
        super(operand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        Type operandType = this.getOperand().verifyExpr(compiler, localEnv, currentClass);
        if (!operandType.isBoolean()){
            throw new ContextualError("Invalid type for Not operator"
            + " : expected boolean but got " + operandType.getName().getName(), getLocation());
        }
        this.setType(operandType);
        return operandType;
    }


    @Override
    protected String getOperatorName() {
        return "!";
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler) {
        int storeRegisterNumber = compiler.getNCurrRegister();
        getOperand().codeGenInst(compiler);
        compiler.addNCurrRegister();
        compiler.addInstruction(new LOAD(-1, Register.getR(compiler.getNCurrRegister())));
        compiler.addInstruction(new ADD(Register.getR(compiler.getNCurrRegister()), Register.getR(storeRegisterNumber)));
        compiler.decrementNCurrRegister();
        compiler.setStoreRegister(storeRegisterNumber);

    }

    @Override
    protected void codeGenCondition(DecacCompiler compiler, boolean bool, 
                Label branchLabel){
        getOperand().codeGenCondition(compiler, !bool, branchLabel);
    }
}
