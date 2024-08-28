package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.codegen.DivisionByZeroError;
import fr.ensimag.deca.codegen.ExecutionError;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.DecacCompiler;

import fr.ensimag.ima.pseudocode.*;
import fr.ensimag.ima.pseudocode.instructions.*;
/**
 *
 * @author gl19
 * @date 01/01/2023
 */
public class Modulo extends AbstractOpArith {

    public Modulo(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        Type lType = getLeftOperand().verifyExpr(compiler, localEnv, currentClass);
        Type rType = getRightOperand().verifyExpr(compiler, localEnv, currentClass);

        if (!(lType.isInt() && rType.isInt())){
            throw new ContextualError("Invalid types for " + getOperatorName()
            + " : (" + lType.getName().getName() + ",  " + rType.getName().getName() + ")", getLocation());
        }
        this.setType(lType);
        return lType;
    }


    @Override
    protected String getOperatorName() {
        return "%";
    }

    
    @Override
    protected void codeGenInst(DecacCompiler compiler) {
        int storeRegisterNumber = compiler.getNCurrRegister();
        getLeftOperand().codeGenInst(compiler);
        compiler.addNCurrRegister();
        getRightOperand().codeGenInst(compiler);
        if (compiler.getCompilerOptions().getErrorHandling()){
            ExecutionError divisionError = new DivisionByZeroError(compiler);
            compiler.addInstruction(new CMP(0, Register.getR(compiler.getNCurrRegister())));
            compiler.addInstruction(new BEQ(divisionError.errorLabel));
            compiler.getHandledError().add(divisionError);
        }
		compiler.addInstruction(new REM(Register.getR(compiler.getNCurrRegister()), Register.getR(storeRegisterNumber)));
        compiler.decrementNCurrRegister();
        compiler.setStoreRegister(storeRegisterNumber);
    }
}
