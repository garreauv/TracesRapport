package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.codegen.OverFlowError;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.*;

/**
 * @author gl19
 * @date 01/01/2023
 */
public class Plus extends AbstractOpArith {
    public Plus(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }
 

    @Override
    protected String getOperatorName() {
        return "+";
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler) {
        int storeRegisterNumber = compiler.getNCurrRegister();
        getLeftOperand().codeGenInst(compiler);
        compiler.addNCurrRegister();
        getRightOperand().codeGenInst(compiler);
		compiler.addInstruction(new ADD(Register.getR(compiler.getNCurrRegister()), Register.getR(storeRegisterNumber)));
        if (compiler.getCompilerOptions().getErrorHandling() && getType().isFloat()){
            OverFlowError overFlowError = new OverFlowError(compiler);
            compiler.addInstruction(new BOV(overFlowError.errorLabel));
            compiler.addError(overFlowError);
        }
        compiler.decrementNCurrRegister();
        compiler.setStoreRegister(storeRegisterNumber);
    }

}
