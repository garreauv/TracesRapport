package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.context.TypeDefinition;
import fr.ensimag.deca.context.VariableDefinition;
import fr.ensimag.deca.context.EnvironmentExp.DoubleDefException;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.ParamDefinition;
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
public class DeclParam extends AbstractDeclParam {

    
    final private AbstractIdentifier type;
    final private AbstractIdentifier name;

    public DeclParam(AbstractIdentifier type, AbstractIdentifier name) {
        Validate.notNull(type);
        Validate.notNull(name);
        this.type = type;
        this.name = name;
    }

    @Override
    protected Type verifyDeclParam(DecacCompiler compiler,
            ClassDefinition currentClass) throws ContextualError {
        Type paramType = type.verifyType(compiler);
        name.setType(paramType);
        ParamDefinition paramDef = new ParamDefinition(paramType, getLocation());
        name.setDefinition(paramDef);
        if (paramType.isVoid()){
            throw new ContextualError("Parameter " + name.getName() + " cannot be of void type."
                                        , getLocation());
        }
        return paramType;
    }

    @Override
    public AbstractIdentifier getType(){
        return this.type;
    }

    public AbstractIdentifier getName(){
        return this.name;
    }


    @Override
    public void decompile(IndentPrintStream s) {
        getType().decompile(s);
        s.print(" ");
        getName().decompile(s);
    }

    @Override
    protected
    void iterChildren(TreeFunction f) {
        type.iter(f);
        name.iter(f);
    }
    
    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        type.prettyPrint(s, prefix, false);
        name.prettyPrint(s, prefix, false);
    }

    @Override
    public void codeGenParam(DecacCompiler compiler) {
        throw new UnsupportedOperationException("not yet implemented");
    }

    @Override
    public void verifyDeclParamBody(DecacCompiler compiler, ClassDefinition classDef, EnvironmentExp paramEnv)
            throws ContextualError {
        try {
            paramEnv.declare(name.getName(), name.getParamDefinition());
        } catch (DoubleDefException e) {
            throw new ContextualError("Parameter " + name.getName() + 
                                        " is already defined.", getLocation());
        }
    }
}
