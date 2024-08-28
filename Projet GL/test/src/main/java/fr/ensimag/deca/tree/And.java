package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.codegen.OverFlowError;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.*;

/**
 *
 * @author gl19
 * @date 01/01/2023
 */
public class And extends AbstractOpBool {

    public And(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    protected String getOperatorName() {
        return "&&";
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler) {
        int storeRegisterNumber = compiler.getNCurrRegister();
        getLeftOperand().codeGenInst(compiler);
        compiler.addNCurrRegister();
        getRightOperand().codeGenInst(compiler);
        compiler.addInstruction(new MUL(Register.getR(compiler.getNCurrRegister()), Register.getR(storeRegisterNumber)));
        compiler.decrementNCurrRegister();
        compiler.setStoreRegister(storeRegisterNumber);
    }

    @Override
    protected void codeGenCondition(DecacCompiler compiler, boolean bool, 
                Label branchLabel){
        if (bool) {
            Label endLabel = new Label("E_Fin." + compiler.getElseLabelIndex() 
                                      + compiler.getLabelIndex());
            compiler.incrementLabelIndex();
            getLeftOperand().codeGenCondition(compiler, false, endLabel);
            getRightOperand().codeGenCondition(compiler, true, branchLabel);
            compiler.addLabel(endLabel);
        }
        else {
            getLeftOperand().codeGenCondition(compiler, false, branchLabel);
            getRightOperand().codeGenCondition(compiler, false, branchLabel);
        }
    }

}
