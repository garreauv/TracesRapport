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
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.ADDSP;
import fr.ensimag.ima.pseudocode.instructions.BOV;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.ima.pseudocode.instructions.PUSH;
import fr.ensimag.ima.pseudocode.instructions.RTS;
import fr.ensimag.ima.pseudocode.instructions.TSTO;

import java.io.PrintStream;
import org.apache.commons.lang.Validate;

/**
 * Declaration of a Method 
 * 
 * @author Louis
 * @date 08/01/2023
 */
public class DeclMethod extends AbstractDeclMethod{
    
    final private AbstractIdentifier type;
    final private AbstractIdentifier name;
    final private ListDeclParam param;
    final private AbstractMethodBody body;

    public DeclMethod(AbstractIdentifier type, AbstractIdentifier name,ListDeclParam param, AbstractMethodBody body) {
        Validate.notNull(name);
        Validate.notNull(type);
        Validate.notNull(param);
        Validate.notNull(body);
        this.type = type;
        this.name = name;
        this.param = param;
        this.body = body;
    }

        
    @Override
    public void decompile(IndentPrintStream s) {
        type.decompile(s);
        s.print(" ");
        name.decompile(s);
        s.print("( ");
        param.decompile(s);
        s.println(" ){");
        s.indent();
        body.decompile(s);
        s.unindent();
        s.println(" }");
    }


    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        name.prettyPrint(s, prefix, false);
        type.prettyPrint(s, prefix, false);
        param.prettyPrint(s, prefix, false);
        body.prettyPrint(s, prefix, true);
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        type.iter(f);
        name.iter(f);
        param.iter(f);
        body.iter(f);
    }

    protected void verifyDeclMethod(DecacCompiler compiler, ClassDefinition currentClass) 
                    throws ContextualError{
        // Updating Label map, using LinkedHashMap allows to override while keeping in same
        // position
        currentClass.labelMap.put(name.getName(), new Label("code." + currentClass.getType().getName() + "." + name.getName()));

        Type returnType = type.verifyType(compiler);
        ClassDefinition superclassDef = currentClass.getSuperClass();
        Signature methodSignature = param.verifyListDeclParam(compiler, currentClass);

        MethodDefinition methodDefinition = new MethodDefinition(returnType, 
                                    getLocation(), methodSignature, currentClass.incNumberOfMethods());

        try {
            currentClass.getMembers().declare(name.getName(), methodDefinition);
            name.setDefinition(methodDefinition);
            name.setType(returnType);
        } catch (DoubleDefException e) {
            throw new ContextualError("Method " + name.getName() + " has already been declared."
                                    , getLocation());
        }

        ExpDefinition superMethodExpDef = superclassDef.getMembers().get(name.getName());
        if (superMethodExpDef != null){
            MethodDefinition superMethodDef = superMethodExpDef.asMethodDefinition("Method "
                                     + name.getName() + "has previously been defined as an attribute.", getLocation());
            if (!methodSignature.equals(superMethodDef.getSignature())){
                throw new ContextualError("Method " + name.getName() +
                            " cannot have a different signature from the method it overrides.", getLocation());
            }
            else if (!returnType.isCompatible(compiler, superMethodDef.getType())){
                throw new ContextualError("Method" + name.getName() +
                            " return type " + returnType.getName() + " incompatible with superclass "
                            + "method return type " + superMethodDef.getType().getName(), getLocation());
            }
        }

    }


    @Override
    public void verifyDeclMethodBody(DecacCompiler compiler, ClassDefinition classDef) 
                                    throws ContextualError {
        EnvironmentExp paramEnv = param.verifyListDeclParamBody(compiler, classDef);
        Type returnType = type.getType();
        body.verifyMethodBody(compiler, classDef, paramEnv, returnType);
    }

    public void methodDeclCodeGen(DecacCompiler compiler, IMAProgram subProgram, ClassDefinition classDef){
        // Subprogram?

        MethodDefinition methodDef = name.getMethodDefinition();

        int index = 3;
        for (AbstractDeclParam p : param.getList()){
            p.getName().getParamDefinition().setOperand(new RegisterOffset(-index, Register.LB));
            index++;
        }

        compiler.addNCurrRegister();
        compiler.addLabel(new Label("code." + classDef.getType().getName() + "." + name.getName()));
        Label returnMethodLabel = new Label("fin." + classDef.getType().getName() + "." + name.getName());

        compiler.addComment("Sauvegarde des registres : ");
        

        
        IMAProgram subProgramBis = new IMAProgram();

        compiler.setCurrentProgramme(subProgramBis);
        
        compiler.registerCount=0;
        compiler.setTSTO(0);
        compiler.resetMaxPush();
        
        body.codeGenMethodBody(compiler, subProgramBis, returnMethodLabel);



        // Should be able to manage PUSH and POP, TSTO


        compiler.addLabel(new Label("fin." + classDef.getType().getName() + "." + name.getName()));

        compiler.addComment("Restauration des registres : ");

        for(int i=0; i<compiler.registerCount-1; i++){

            compiler.addInstructionToTop(new PUSH(Register.getR(i+2)));
            compiler.addInstruction(new POP(Register.getR(i+2)));
        }
        if(compiler.getCompilerOptions().getErrorHandling()){
            compiler.addInstructionToTop(new BOV(new Label("stack_overflow_error")));
            compiler.addInstructionToTop(new TSTO(compiler.getMaxPush()+compiler.registerCount));
        }
        
        compiler.resetCurrentProgramme();

        compiler.append(subProgramBis);

        compiler.registerCount=0;

        compiler.addInstruction(new RTS());
    }
    

}
