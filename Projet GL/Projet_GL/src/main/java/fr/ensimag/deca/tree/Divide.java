package fr.ensimag.deca.tree;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.codegen.DivisionByZeroError;
import fr.ensimag.deca.codegen.ExecutionError;
import fr.ensimag.ima.pseudocode.*;
import fr.ensimag.ima.pseudocode.instructions.*;

/**
 *
 * @author gl19
 * @date 01/01/2023
 */
public class Divide extends AbstractOpArith {
    public Divide(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }


    @Override
    protected String getOperatorName() {
        return "/";
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler) {
        int storeRegisterNumber = compiler.getNCurrRegister();
        getLeftOperand().codeGenInst(compiler);
        compiler.addNCurrRegister();
        getRightOperand().codeGenInst(compiler);
        if (getType().isInt()){
            if (compiler.getCompilerOptions().getErrorHandling()){
                ExecutionError divisionError = new DivisionByZeroError(compiler);
                compiler.addInstruction(new CMP(0, Register.getR(compiler.getNCurrRegister())));
                compiler.addInstruction(new BEQ(divisionError.errorLabel));
                compiler.getHandledError().add(divisionError);
            }
		    compiler.addInstruction(new QUO(Register.getR(compiler.getNCurrRegister()), 
                                    Register.getR(storeRegisterNumber)));
        }
        else if (getType().isFloat()){
            if (compiler.getCompilerOptions().getErrorHandling()){
                ExecutionError divisionError = new DivisionByZeroError(compiler);
                compiler.addInstruction(new CMP(new ImmediateFloat(0), Register.getR(compiler.getNCurrRegister())));
                compiler.addInstruction(new BEQ(divisionError.errorLabel));
                compiler.getHandledError().add(divisionError);
            }
            compiler.addInstruction(new DIV(Register.getR(compiler.getNCurrRegister()), 
                                    Register.getR(storeRegisterNumber)));
        }
        compiler.decrementNCurrRegister();
        compiler.setStoreRegister(storeRegisterNumber);
    }
}
