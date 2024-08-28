package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;

import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.IMAProgram;

import java.io.PrintStream;
import org.apache.commons.lang.Validate;

/**
 * Method declaration
 *
 * @author Louis
 * @date 08/01/2023
 */
public abstract class AbstractDeclMethod extends Tree {

    protected abstract void verifyDeclMethod(DecacCompiler compiler, ClassDefinition currentClass) 
                    throws ContextualError;

    public abstract void verifyDeclMethodBody(DecacCompiler compiler, ClassDefinition classDef)
                    throws ContextualError;

    public abstract void methodDeclCodeGen(DecacCompiler compiler, IMAProgram subProgram, ClassDefinition classDef);
                    
}
