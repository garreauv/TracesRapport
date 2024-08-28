package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.BRA;
import fr.ensimag.ima.pseudocode.instructions.LOAD;

import java.io.PrintStream;
import org.apache.commons.lang.Validate;

public class Return extends AbstractInst{

    private final AbstractExpr returnExpr;

    public Return(AbstractExpr returnExpr) {
        this.returnExpr=returnExpr;
    }




    public AbstractExpr getOperand() {
        return returnExpr;
    }

  
    @Override
    public void decompile(IndentPrintStream s) {
        s.print("return ");
        getOperand().decompile(s);
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        returnExpr.iter(f);
    }

    protected void codeGenInst(DecacCompiler compiler) {
        returnExpr.codeGenInst(compiler);
        compiler.addInstruction(new LOAD(Register.getR(compiler.getStoreRegister()), Register.R0));  
        compiler.decrementNCurrRegister();
        compiler.addInstruction(new BRA(methodLabel)); 
        compiler.setHasReturn(true);  
    }


    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        returnExpr.prettyPrint(s, prefix, true);
    }




    @Override
    protected void verifyInst(DecacCompiler compiler, EnvironmentExp localEnv, ClassDefinition currentClass,
            Type returnType) throws ContextualError {
        if (returnType.isVoid()){
            throw new ContextualError("Return type must not be void.", getLocation());
        }
        returnExpr.verifyRValue(compiler, localEnv, currentClass, returnType);
    }
}
