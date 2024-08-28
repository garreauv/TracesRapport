package fr.ensimag.deca.tree;

import java.io.PrintStream;

import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.codegen.ExecutionError;
import fr.ensimag.deca.codegen.StackError;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.tools.IndentPrintStream;
// import fr.ensimag.ima.pseudocode.GPRegister;
// import fr.ensimag.ima.pseudocode.Register;
// import fr.ensimag.ima.pseudocode.RegisterOffset;
// import fr.ensimag.ima.pseudocode.instructions.HALT;
// import fr.ensimag.ima.pseudocode.instructions.LOAD;

import fr.ensimag.ima.pseudocode.*;
import fr.ensimag.ima.pseudocode.instructions.*;
/**
 * Deca complete program (class definition plus main block)
 *
 * @author gl19
 * @date 01/01/2023
 */
public class Program extends AbstractProgram {
    private static final Logger LOG = Logger.getLogger(Program.class);
    
    public Program(ListDeclClass classes, AbstractMain main) {
        //Validate.notNull(classes);
        Validate.notNull(main);
        this.classes = classes;
        this.main = main;
    }
    public ListDeclClass getClasses() {
        return classes;
    }
    public AbstractMain getMain() {
        return main;
    }
    private ListDeclClass classes;
    private AbstractMain main;

    @Override
    public void verifyProgram(DecacCompiler compiler) throws ContextualError {
        LOG.debug("verify program: start");
        classes.verifyListClass(compiler);
        classes.verifyListClassMembers(compiler);
        classes.verifyListClassBody(compiler);
        main.verifyMain(compiler);
        LOG.debug("verify program: end");
    }

    @Override
    public void codeGenProgram(DecacCompiler compiler) {
        


        compiler.setADDSP(0);
        compiler.setTSTO(0);
        compiler.resetMaxPush();
        if(compiler.getCompilerOptions().getErrorHandling()){
            // compiler.addInstructionToTop(new BOV(new Label("stack_overflow_error")));
            ExecutionError stackError = new StackError(compiler);
            compiler.getHandledError().add(stackError);
        }

        objectMethodTableGen(compiler);
        classes.methodTableCodeGen(compiler);

        
        compiler.addComment("Start main program");
        main.codeGenMain(compiler);
        compiler.addInstruction(new HALT());

        compiler.addComment("End main program");

        if(compiler.getCompilerOptions().getErrorHandling()){
            compiler.addInstructionToTop(new BOV(new Label("stack_overflow_error")));
        }
        compiler.addInstructionToTop(new TSTO(compiler.getTSTO()+compiler.getMaxPush()+compiler.getADDSP()));
        compiler.addInstructionToTop(new ADDSP(compiler.getADDSP()));

        equalsCodeGen(compiler);
        classes.fieldInitCodeGen(compiler);
        classes.methodCodeGen(compiler);

        for (ExecutionError e : compiler.getHandledError()){
            e.genCodeError(compiler);
        } 

    }

    public void objectMethodTableGen(DecacCompiler compiler){
        compiler.addComment("Code de la table des méthodes de Object");
        ClassDefinition objectDef = compiler.getClassDef(compiler.createSymbol("Object"), getLocation());


        objectDef.setOperand(new RegisterOffset(1, Register.GB));
        compiler.incrementStackPointer();
        compiler.incrementADDSP();

        compiler.addInstruction(new LOAD(new NullOperand(), Register.R0));
        compiler.addInstruction(new STORE(Register.R0, new RegisterOffset(1, Register.GB)));
        compiler.addInstruction(new LOAD(new LabelOperand(new Label("code.Object.equals")), Register.R0));
        compiler.addInstruction(new STORE(Register.getR(0), new RegisterOffset(2, Register.GB)));

        compiler.incrementStackPointer();
        compiler.incrementADDSP();

    }

    public void equalsCodeGen(DecacCompiler compiler){
        compiler.addLabel(new Label("code.Object.equals"));
        compiler.addInstruction(new LOAD(new RegisterOffset(-2, Register.LB), Register.R0));
        compiler.addInstruction(new CMP(new RegisterOffset(-3, Register.LB), Register.R0));
        compiler.addInstruction(new SEQ(Register.R0));
        compiler.addInstruction(new RTS());
    }

    @Override
    public void decompile(IndentPrintStream s) {
        getClasses().decompile(s);
        getMain().decompile(s);
    }
    
    @Override
    protected void iterChildren(TreeFunction f) {
        classes.iter(f);
        main.iter(f);
    }
    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        classes.prettyPrint(s, prefix, false);
        main.prettyPrint(s, prefix, true);
    }
}
