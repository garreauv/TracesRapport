package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;

/**
 * Variable declaration
 *
 * @author gl19
 * @date 01/01/2023
 */
public abstract class AbstractDeclParam extends Tree {
    

    protected abstract Type verifyDeclParam(DecacCompiler compiler,
                                        ClassDefinition currentClass)
            throws ContextualError;

    public abstract void codeGenParam(DecacCompiler compiler);

    public abstract void verifyDeclParamBody(DecacCompiler compiler,
                        ClassDefinition classDef, EnvironmentExp paramEnv)
                        throws ContextualError;

    public AbstractIdentifier getType(){
        return null;
    }    

    public AbstractIdentifier getName(){
        return null;
    }
    
}
