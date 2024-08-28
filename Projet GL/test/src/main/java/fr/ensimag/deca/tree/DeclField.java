package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.context.EnvironmentExp.DoubleDefException;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.EnvironmentType;
import fr.ensimag.deca.context.ExpDefinition;
import fr.ensimag.deca.context.FieldDefinition;
import fr.ensimag.deca.context.MethodDefinition;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.IMAProgram;
import fr.ensimag.ima.pseudocode.ImmediateFloat;
import fr.ensimag.ima.pseudocode.NullOperand;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.STORE;

import java.io.PrintStream;
import org.apache.commons.lang.Validate;

/**
 * @author Louis
 * @date 08/01/2023
 */
public class DeclField extends AbstractDeclField {

    
    final private Visibility visibility;
    final private AbstractIdentifier type;
    final private AbstractIdentifier varName;
    final private AbstractInitialization initialization;

    public DeclField(Visibility visibility, AbstractIdentifier type, AbstractIdentifier varName, AbstractInitialization initialization) {
        Validate.notNull(visibility);
        Validate.notNull(type);
        Validate.notNull(varName);
        Validate.notNull(initialization);
        this.visibility = visibility;
        this.type = type;
        this.varName = varName;
        this.initialization = initialization;
    }


    protected void verifyDeclField(DecacCompiler compiler, ClassDefinition currentClass)
            throws ContextualError {
        Type fieldType = type.verifyType(compiler);
        ClassDefinition superclassDef = currentClass.getSuperClass();

        if (fieldType.isVoid()){
            throw new ContextualError("Type of " + varName.getName().getName() +
                                    " cannot be void." , getLocation());
        }

        FieldDefinition vFieldDef = new FieldDefinition(fieldType, getLocation(), visibility, currentClass, 
                                                    currentClass.incNumberOfFields());


        try {
            currentClass.getMembers().declare(varName.getName(), vFieldDef);
            varName.setDefinition(vFieldDef);
            varName.setType(fieldType);
        } catch (DoubleDefException e) {
            throw new ContextualError("Attribute " + varName.getName().getName() + " has already been declared."
                            , getLocation());
        }
        

        ExpDefinition superFieldDef = superclassDef.getMembers().get(varName.getName());
        if (superFieldDef != null){
            superFieldDef.asFieldDefinition("Attribute " + varName.getName() + " has previously been defined as method."
                                        , getLocation());
        }

        vFieldDef.setOperand(new RegisterOffset(vFieldDef.getIndex(), Register.getR(2)));
        currentClass.inheritedFields.add(vFieldDef);
    }

    @Override
    public void verifyDeclFieldBody(DecacCompiler compiler, ClassDefinition classDef)
                            throws ContextualError {
        EnvironmentExp localEnv = classDef.getMembers();
        initialization.verifyInitialization(compiler, type.getType(), localEnv, classDef);
    }
    
    @Override
    public void decompile(IndentPrintStream s) {
        
        if(visibility == Visibility.PUBLIC){
            s.print("public");
        }else{
            s.print("protected");
        }
        s.print(" ");
        type.decompile(s);
        s.print(" ");
        varName.decompile(s);
        initialization.decompile(s);
        s.print(";");
    }

    @Override
    protected
    void iterChildren(TreeFunction f) {
        type.iter(f);
        varName.iter(f);
        initialization.iter(f);
    }
    
    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        type.prettyPrint(s, prefix, false);
        varName.prettyPrint(s, prefix, false);
        initialization.prettyPrint(s, prefix, true);
    }

    @Override
    public void fieldInitCodeGen(DecacCompiler compiler, IMAProgram subProgram) {
        // TO DO : If no superclass, initialize directly.

        subProgram.addComment("Initialisation de " + varName.getFieldDefinition().getContainingClass().getType().getName() + "." + varName.getName());
        if (varName.getType().isClass()){
            subProgram.addInstruction(new LOAD(new NullOperand(), Register.R0));
        }
        else if (varName.getType().isInt()){
            subProgram.addInstruction(new LOAD(0, Register.R0));
        }
        else if (varName.getType().isFloat()){
            subProgram.addInstruction(new LOAD(new ImmediateFloat(0), Register.R0));
        }
        subProgram.addInstruction(new LOAD(new RegisterOffset(-2, Register.LB), Register.R1));
        subProgram.addInstruction(new STORE(Register.R0, new RegisterOffset(varName.getFieldDefinition().getIndex(), Register.R1)));
    }

    @Override
    public void fieldExplicitInitCodeGen(DecacCompiler compiler, IMAProgram subProgram) {
        compiler.addComment("Initialisation explicite de " + varName.getFieldDefinition().getContainingClass().getType().getName() + "." + varName.getName());
        compiler.mode = 1;
        initialization.codeGenInst(compiler, varName.getFieldDefinition());
    }

}
