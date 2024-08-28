package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ClassType;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.codegen.ExecutionError;
import fr.ensimag.deca.codegen.StackError;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentType;
import fr.ensimag.deca.context.FieldDefinition;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.IMAProgram;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.LabelOperand;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.BOV;
import fr.ensimag.ima.pseudocode.instructions.BSR;
import fr.ensimag.ima.pseudocode.instructions.LEA;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.ima.pseudocode.instructions.PUSH;
import fr.ensimag.ima.pseudocode.instructions.RTS;
import fr.ensimag.ima.pseudocode.instructions.STORE;
import fr.ensimag.ima.pseudocode.instructions.SUBSP;
import fr.ensimag.ima.pseudocode.instructions.TSTO;

import java.io.PrintStream;
import java.util.ListIterator;

import org.apache.commons.lang.Validate;

/**
 * Declaration of a class (<code>class name extends superClass {members}<code>).
 * 
 * @author gl19
 * @date 01/01/2023
 */
public class DeclClass extends AbstractDeclClass {

    final private AbstractIdentifier name;
    final private AbstractIdentifier superclass;
    final private ListDeclField fields;
    final private ListDeclMethod meths;

    public DeclClass(AbstractIdentifier name, AbstractIdentifier superclass, ListDeclField fields, ListDeclMethod meths) {
        Validate.notNull(name);
        Validate.notNull(superclass);
        Validate.notNull(fields);
        Validate.notNull(meths);
        this.name = name;
        this.superclass = superclass;
        this.fields = fields;
        this.meths = meths;
    }

    @Override
    public void decompile(IndentPrintStream s) {
        s.print("class ");
        name.decompile(s);
        if(superclass.getName().getName().compareTo("Object")!=0){
            s.print(" extends ");
            superclass.decompile(s);
        }
        s.println(" {");
        s.indent();
        fields.decompile(s);
        meths.decompile(s);
        s.unindent();
        s.println(" }");
    }

    @Override
    protected void verifyClass(DecacCompiler compiler) throws ContextualError {
        
        if (compiler.environmentType.containsSymbol(name.getName())){
            throw new ContextualError("Class " + name.getName().getName() + 
                                    " is already declared.", getLocation());
        }
        else if (!compiler.environmentType.containsSymbol(superclass.getName())){
            throw new ContextualError("Class " + superclass.getName().getName() +
                                     " is not declared.", getLocation());    
        }
        ClassDefinition superClassDef = compiler.getClassDef(superclass.getName(), getLocation());
        superclass.setDefinition(superClassDef);
        ClassType classType = new ClassType(name.getName(), getLocation(), superClassDef);
        ClassDefinition classDefinition = new ClassDefinition(classType, getLocation(), superClassDef);
        classDefinition.getMembers().setParentEnvironment(superClassDef.getMembers());
        name.setDefinition(classDefinition);
        name.setType(classType);
        compiler.environmentType.declareClass(name.getName(), classDefinition);
    }

    @Override
    protected void verifyClassMembers(DecacCompiler compiler)
            throws ContextualError {
        ClassDefinition classDef = compiler.getClassDef(name.getName(), getLocation());
        ClassDefinition superClass = compiler.getClassDef(superclass.getName(), getLocation());
        // Inheriting all super class methods, with old labels
        classDef.labelMap.putAll(superClass.labelMap);
        // Inheriting all fields
        if (superclass.getName() != compiler.createSymbol("Object")){
            classDef.inheritedFields.addAll(superClass.inheritedFields);
        }
        classDef.setNumberOfFields(superClass.getNumberOfFields());
        fields.verifyListDeclField(compiler, classDef);
        classDef.setNumberOfMethods(superClass.getNumberOfMethods());
        meths.verifyListDeclMethod(compiler, classDef);
        
    }
    
    @Override
    protected void verifyClassBody(DecacCompiler compiler) throws ContextualError {
        ClassDefinition classDef = compiler.getClassDef(name.getName(), getLocation());
        fields.verifyListDeclFieldBody(compiler, classDef);
        meths.verifyListDeclMethodBody(compiler, classDef);

    }


    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        name.prettyPrint(s, prefix, false);
        superclass.prettyPrint(s, prefix, false);
        fields.prettyPrint(s, prefix, false);
        meths.prettyPrint(s, prefix, true);
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        name.iter(f);
        superclass.iter(f);
        fields.iter(f);
        meths.iter(f);
    }
    
    protected void methodTableCodeGen(DecacCompiler compiler){
        compiler.addComment("Code de la table des méthodes de " + name.getName());

        ClassDefinition classDef = compiler.getClassDef(name.getName(), getLocation());
        ClassDefinition superDef = compiler.getClassDef(superclass.getName(), getLocation());

        classDef.setOperand(new RegisterOffset(compiler.getStackPointer(), Register.GB));
        compiler.addInstruction(new LEA(superDef.getOperand(), Register.R0));
        compiler.addInstruction(new STORE(Register.R0, new RegisterOffset(compiler.getStackPointer(), Register.GB)));

        for (Label l : classDef.labelMap.values()){
            compiler.addInstruction(new LOAD(new LabelOperand(l), Register.R0));
            compiler.incrementStackPointer();
            compiler.incrementADDSP();
            compiler.addInstruction(new STORE(Register.R0, new RegisterOffset(compiler.getStackPointer(), Register.GB)));
        }

        compiler.incrementStackPointer();
        compiler.incrementADDSP();
    }

    @Override
    protected void fieldInitCodeGen(DecacCompiler compiler) {
        IMAProgram subProgram = new IMAProgram();
        subProgram.addLabel(new Label("init." + name.getName()));
        ClassDefinition superClassDef = compiler.getClassDef(name.getName(), getLocation()).getSuperClass();
        
        for (AbstractDeclField f : fields.getList()){
            f.fieldInitCodeGen(compiler, subProgram);
        }


        if (superClassDef.getType() != compiler.environmentType.OBJECT){
            subProgram.addComment("Appel de l'initialisation des champs hérités de " + superclass.getName());
            subProgram.addInstruction(new PUSH(Register.R1));
            subProgram.addInstruction(new BSR(new Label("init." + superClassDef.getType().getName())));
            subProgram.addInstruction(new SUBSP(1));
        }

        compiler.append(subProgram);


        IMAProgram subProgramBis = new IMAProgram();

        compiler.setCurrentProgramme(subProgramBis);
        // Setting compiler mode to 1 allows us to get the registers that were used
        compiler.registerCount=0;
        compiler.setTSTO(0);
        compiler.resetMaxPush();
        

        for (AbstractDeclField f : fields.getList()){
            f.fieldExplicitInitCodeGen(compiler, subProgramBis);
        }

        for(int i=0; i<compiler.registerCount-1; i++){

            compiler.addInstructionToTop(new PUSH(Register.getR(i+2)));
            compiler.addInstruction(new POP(Register.getR(i+2)));
        }
        if(compiler.getCompilerOptions().getErrorHandling()){
            // compiler.addInstructionToTop(new BOV(new Label("stack_overflow_error")));
            // ExecutionError stackError = new StackError(compiler);
            // compiler.getHandledError().add(stackError);
        }
        compiler.addInstructionToTop(new TSTO(compiler.getMaxPush()+compiler.registerCount));
        compiler.resetCurrentProgramme();

        compiler.append(subProgramBis);

        compiler.registerCount=0;

        compiler.addInstruction(new RTS());
        
    }

    @Override
    protected void methodCodeGen(DecacCompiler compiler) {
            IMAProgram subProgram = new IMAProgram();
            meths.codeGenMethodBody(compiler, subProgram, compiler.getClassDef(name.getName(), getLocation()));
    }



}
