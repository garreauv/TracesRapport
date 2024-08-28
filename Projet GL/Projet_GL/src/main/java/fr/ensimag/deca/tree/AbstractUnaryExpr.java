package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.WFLOAT;
import fr.ensimag.ima.pseudocode.instructions.WFLOATX;
import fr.ensimag.ima.pseudocode.instructions.WINT;

import java.io.PrintStream;
import org.apache.commons.lang.Validate;

/**
 * Unary expression.
 *
 * @author gl19
 * @date 01/01/2023
 */
public abstract class AbstractUnaryExpr extends AbstractExpr {

    public AbstractExpr getOperand() {
        return operand;
    }
    private AbstractExpr operand;
    public AbstractUnaryExpr(AbstractExpr operand) {
        Validate.notNull(operand);
        this.operand = operand;
    }


    protected abstract String getOperatorName();
  
    @Override
    public void decompile(IndentPrintStream s) {
        s.print("(");
        getOperand().decompile(s);
        s.print(" " + getOperatorName() + " )");
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        operand.iter(f);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        operand.prettyPrint(s, prefix, true);
    }

    @Override
    public void codeGenPrint(DecacCompiler compiler){
        codeGenInst(compiler);
        compiler.addInstruction(new LOAD(Register.getR(compiler.getStoreRegister()), Register.getR(1)));
        if (getType().isInt()){
            compiler.addInstruction(new WINT());
        }
        else if (getType().isFloat()){
            compiler.addInstruction(new WFLOAT());
        }
    }

    @Override
    public void codeGenPrintHex(DecacCompiler compiler){
        codeGenInst(compiler);
        compiler.addInstruction(new LOAD(Register.getR(compiler.getStoreRegister()), Register.getR(1)));
        if (getType().isInt()){
            compiler.addInstruction(new WINT());
        }
        else if (getType().isFloat()){
            compiler.addInstruction(new WFLOATX());
        }
    }

}
