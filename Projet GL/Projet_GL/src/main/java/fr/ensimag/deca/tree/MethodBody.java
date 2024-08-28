package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.context.EnvironmentExp.DoubleDefException;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.ExpDefinition;
import fr.ensimag.deca.context.FieldDefinition;
import fr.ensimag.deca.context.MethodDefinition;
import fr.ensimag.deca.context.Signature;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.IMAProgram;
import fr.ensimag.ima.pseudocode.Instruction;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.LOAD;

import java.io.PrintStream;
import org.apache.commons.lang.Validate;

/**
 * Declaration of a Method 
 * 
 * @author Akram
 * @date 18/01/2023
 */
public class MethodBody extends AbstractMethodBody{
    
    final private ListDeclVar var;
    final private ListInst inst;

    public MethodBody(ListDeclVar var, ListInst inst) {
        this.inst = inst;
        this.var = var;
    }



    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        var.prettyPrint(s, prefix, false); 
        inst.prettyPrint(s, prefix, true);
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        var.iter(f);
        inst.iter(f);
    }


    @Override
    public void verifyMethodBody(DecacCompiler compiler, ClassDefinition currentClass,
                            EnvironmentExp paramEnv, Type returnType) 
                                    throws ContextualError {                              
        var.verifyListDeclVariable(compiler, paramEnv, currentClass);
        inst.verifyListInst(compiler, paramEnv, currentClass, returnType);
    }



    @Override
    public void decompile(IndentPrintStream s) {
        var.decompile(s);
        inst.decompile(s);        
    }



    @Override
    public void codeGenMethodBody(DecacCompiler compiler, IMAProgram subProgram, Label returnLabel) {
        // TO DO : POP AND PUSH


        var.codeGenListVar(compiler);
        for (AbstractInst i : inst.getList()) {
            i.setMethodLabel(returnLabel);
            compiler.resetNCurrRegister();
            i.codeGenInst(compiler);
        }
        
    }

    
    

}
