package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.codegen.OverFlowError;
import fr.ensimag.deca.context.VariableDefinition;
import fr.ensimag.ima.pseudocode.DVal;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.BOV;
import fr.ensimag.ima.pseudocode.instructions.SUB;
/**
 * @author gl19
 * @date 01/01/2023
 */
public class Minus extends AbstractOpArith {
    public Minus(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }


    @Override
    protected String getOperatorName() {
        return "-";
    }
    
    @Override
    protected void codeGenInst(DecacCompiler compiler) {
        int storeRegisterNumber = compiler.getNCurrRegister();
        getLeftOperand().codeGenInst(compiler);
        compiler.addNCurrRegister();
        getRightOperand().codeGenInst(compiler);
		compiler.addInstruction(new SUB(Register.getR(compiler.getNCurrRegister()), Register.getR(storeRegisterNumber)));
        if (compiler.getCompilerOptions().getErrorHandling() && getType().isFloat()){
            OverFlowError overFlowError = new OverFlowError(compiler);
            compiler.addInstruction(new BOV(overFlowError.errorLabel));
            compiler.addError(overFlowError);
        }
        compiler.decrementNCurrRegister();
        compiler.setStoreRegister(storeRegisterNumber);
    }
    
}
