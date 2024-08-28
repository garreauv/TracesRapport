package fr.ensimag.deca.tree;

import java.io.PrintStream;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ClassType;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.DAddr;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.BSR;
import fr.ensimag.ima.pseudocode.instructions.LEA;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.NEW;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.ima.pseudocode.instructions.PUSH;
import fr.ensimag.ima.pseudocode.instructions.STORE;

import fr.ensimag.ima.pseudocode.NullOperand;

import java.io.PrintStream;

import org.apache.commons.lang.Validate;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.VariableDefinition;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.DVal;
import fr.ensimag.ima.pseudocode.Register;


public class New extends AbstractExpr{

    

    public New(AbstractIdentifier ident) {
        Validate.notNull(ident, "left operand cannot be null");
        this.ident=ident;
    }





    public AbstractIdentifier getIdent() {
        return ident;
    }


    private AbstractIdentifier ident;


    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        Type newType = ident.verifyType(compiler);
        ClassType newClass = newType.asClassType(newType.getName() + "must be a class type."
                                        , getLocation());
        setType(newClass);
        return newClass;
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler) {
        
        /* Instruction NEW to allocate a place in the heap for every field*/
        
        ClassDefinition def = compiler.getClassDef(this.ident.getName(), this.ident.getLocation());
        
        DVal size;

        size = new ImmediateInteger(def.getNumberOfFields()+1); // the +1 corresponds to the first index (0) which points towards the class of the object

        int currentRegister = compiler.getNCurrRegister();
        compiler.addInstruction(new NEW(size, Register.getR(currentRegister))); 

        DAddr adresse = def.getOperand(); //address of class in GB
        
        compiler.addInstruction(new LEA(adresse, Register.getR(0)));
        compiler.addInstruction(new STORE(Register.getR(0), new RegisterOffset(0, Register.getR(currentRegister))));
        compiler.addInstruction(new PUSH(Register.getR(currentRegister)));

        compiler.addInstruction(new BSR(new Label(new String("init." + this.ident.getName().getName()))));
        compiler.addInstruction(new POP(Register.getR(currentRegister)));

        compiler.addNCurrRegister();
        
        compiler.setStoreRegister(currentRegister);
        compiler.incrementStackPointer();
    
    }

    @Override
    public void decompile(IndentPrintStream s) {
        s.print("new ");  
        ident.decompile(s);
        s.print("()");  
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        ident.iter(f);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        ident.prettyPrint(s, prefix, false);
    }
}
