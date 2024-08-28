package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.ima.pseudocode.IMAProgram;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;

/**
 * Field declaration
 *
 * @author Louis
 * @date 08/01/2023
 */
public abstract class AbstractDeclField extends Tree {
    
    protected abstract void verifyDeclField(DecacCompiler compiler, ClassDefinition currentClass) 
                    throws ContextualError;

    public abstract void verifyDeclFieldBody(DecacCompiler compiler, ClassDefinition classDef)
                    throws ContextualError;

    public abstract void fieldInitCodeGen(DecacCompiler compiler, IMAProgram subProgram);

    public abstract void fieldExplicitInitCodeGen(DecacCompiler compiler, IMAProgram subProgram);
    
}
