package fr.ensimag.deca.tree;

import java.io.PrintStream;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.DAddr;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.STORE;

import fr.ensimag.ima.pseudocode.NullOperand;

/**
 *
 * @author gl19
 * @date 01/01/2023
 */
public class ThisLiteral extends AbstractExpr {


    public ThisLiteral() {
    }


    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        if (currentClass == null){
            throw new ContextualError("Cannot use This operator in Main block.", getLocation());
        }
        setType(currentClass.getType());
        return getType();
    }


    @Override
    public void decompile(IndentPrintStream s) {
        s.print("this");
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        // leaf node => nothing to do
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        // leaf node => nothing to do
    }

    @Override
    String prettyPrintNode() {
        return "this";
    }

    @Override
	public void codeGenInst(DecacCompiler compiler) {	
        compiler.addInstruction(new LOAD(new RegisterOffset(-2, Register.LB), Register.getR(compiler.getNCurrRegister())));
	}
}
