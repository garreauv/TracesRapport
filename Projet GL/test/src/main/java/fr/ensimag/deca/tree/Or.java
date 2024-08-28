package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.ADD;

/**
 *
 * @author gl19
 * @date 01/01/2023
 */
public class Or extends AbstractOpBool {

    public Or(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    protected String getOperatorName() {
        return "||";
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler) {
        int storeRegisterNumber = compiler.getNCurrRegister();
        getLeftOperand().codeGenInst(compiler);
        compiler.addNCurrRegister();
        getRightOperand().codeGenInst(compiler);
        compiler.addInstruction(new ADD(Register.getR(compiler.getNCurrRegister()), Register.getR(storeRegisterNumber)));
        compiler.decrementNCurrRegister();
        compiler.setStoreRegister(storeRegisterNumber);
    }

    @Override
    protected void codeGenCondition(DecacCompiler compiler, boolean bool, 
                Label branchLabel){
        if (bool) {
            getLeftOperand().codeGenCondition(compiler, true, branchLabel);
            getRightOperand().codeGenCondition(compiler, true, branchLabel);
        }
        else {
            Label endLabel = new Label("E_Fin." + compiler.getElseLabelIndex() 
            + compiler.getLabelIndex());
            compiler.incrementLabelIndex();
            getLeftOperand().codeGenCondition(compiler, true, endLabel);
            getRightOperand().codeGenCondition(compiler, false, branchLabel);
            compiler.addLabel(endLabel);
        }
    }

}
