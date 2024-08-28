package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.context.TypeDefinition;
import fr.ensimag.deca.context.VariableDefinition;
import fr.ensimag.deca.context.EnvironmentExp.DoubleDefException;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.deca.tools.SymbolTable.Symbol;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;

import java.io.PrintStream;
import org.apache.commons.lang.Validate;

/**
 * @author gl19
 * @date 01/01/2023
 */
public class DeclVar extends AbstractDeclVar {

    
    final private AbstractIdentifier type;
    final private AbstractIdentifier varName;
    final private AbstractInitialization initialization;

    public DeclVar(AbstractIdentifier type, AbstractIdentifier varName, AbstractInitialization initialization) {
        Validate.notNull(type);
        Validate.notNull(varName);
        Validate.notNull(initialization);
        this.type = type;
        this.varName = varName;
        this.initialization = initialization;
    }

    @Override
    protected void verifyDeclVar(DecacCompiler compiler,
            EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError {
                Type varType = type.verifyType(compiler);
                initialization.verifyInitialization(compiler, varType, localEnv, currentClass);
                if (varType.isVoid()){
                    throw new ContextualError("Declaration type cannot be void.", getLocation());
                }
                type.setType(varType);
                try {
                    VariableDefinition varDefinition = new VariableDefinition(varType, getLocation());
                    localEnv.declare(varName.getName(), varDefinition);
                } catch (DoubleDefException e) {
                    throw new ContextualError("Variable already declared.", getLocation());
                }
                varName.verifyExpr(compiler, localEnv, currentClass);
    }

    private AbstractIdentifier getType(){
        return this.type;
    }

    private AbstractIdentifier getVarName(){
        return this.varName;
    }

    private AbstractInitialization getInitialization(){
        return this.initialization;
    }

    @Override
    public void decompile(IndentPrintStream s) {
        getType().decompile(s);
        s.print(" ");
        getVarName().decompile(s);
        getInitialization().decompile(s);
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
    public void codeGenVar(DecacCompiler compiler) {
        VariableDefinition varDefinition = varName.getVariableDefinition();
        varDefinition.setOperand(new RegisterOffset(compiler.getStackPointer(), Register.GB));
        compiler.incrementStackPointer();
        compiler.setNCurrRegister(2); //reset the number of registers used to calculate an expression, excluding the scratch registers R0 and R1
        initialization.codeGenInst(compiler, varDefinition);
    }
}
