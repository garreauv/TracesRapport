package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.*;

/**
 *
 * @author gl19
 * @date 01/01/2023
 */
public class LowerOrEqual extends AbstractOpIneq {
    public LowerOrEqual(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }


    @Override
    protected String getOperatorName() {
        return "<=";
    }


    @Override
    protected void codeGenInst(DecacCompiler compiler) {
        int storeRegisterNumber = compiler.getNCurrRegister();
        getLeftOperand().codeGenInst(compiler);
        compiler.addNCurrRegister();
        getRightOperand().codeGenInst(compiler);
        compiler.addInstruction(new LOAD(0, Register.getR(storeRegisterNumber+2)));
		compiler.addInstruction(new CMP(Register.getR(compiler.getNCurrRegister()), Register.getR(storeRegisterNumber)));
        Label assignLabel = new Label("Assign" + compiler.getLabelIndex());
        compiler.incrementLabelIndex();
        compiler.addInstruction(new BGT(assignLabel));
        compiler.addInstruction(new LOAD(1, Register.getR(storeRegisterNumber+2)));
        compiler.addLabel(assignLabel);
        compiler.setStoreRegister(storeRegisterNumber+2);
    }

    @Override
    protected void codeGenCondition(DecacCompiler compiler, boolean bool, 
                Label branchLabel){
        int storeRegisterNumber = compiler.getNCurrRegister();
        getLeftOperand().codeGenInst(compiler);
        compiler.addNCurrRegister();
        getRightOperand().codeGenInst(compiler);
        compiler.addInstruction(new CMP(Register.getR(compiler.getNCurrRegister()), Register.getR(storeRegisterNumber)));
        if (bool){
            compiler.addInstruction(new BLE(branchLabel));
        }
        else {
            compiler.addInstruction(new BGT(branchLabel));
        }
    }

}
