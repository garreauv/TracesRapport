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
import fr.ensimag.ima.pseudocode.InlinePortion;
import fr.ensimag.ima.pseudocode.Label;

import java.io.PrintStream;
import org.apache.commons.lang.Validate;

/**
 * Declaration of a Method 
 * 
 * @author Akram
 * @date 18/01/2023
 */
public class MethodAsmBody extends AbstractMethodBody{
    
    final private StringLiteral inst;

    public MethodAsmBody(StringLiteral inst) {
        this.inst = inst;
    }



    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        // 
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        inst.iter(f);
    }


    @Override
    public void verifyMethodBody(DecacCompiler compiler, ClassDefinition currentClass,
                                 EnvironmentExp paramEnv, Type returnType) 
                                    throws ContextualError {
        inst.verifyExpr(compiler, null, currentClass);
    }

    public void codeGenMethodBody(DecacCompiler compiler, IMAProgram subProgram
                                , Label returnLabel){
        compiler.add(new InlinePortion(inst.getValue()));
    }



    @Override
    public void decompile(IndentPrintStream s) {
        

        s.print("asm( ");
        inst.decompile(s);

        s.print(" );");
        
    }
    

}
