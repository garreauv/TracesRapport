package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.MethodDefinition;
import fr.ensimag.deca.context.Type;
import fr.ensimag.ima.pseudocode.IMAProgram;
import fr.ensimag.ima.pseudocode.Label;


/**
 * Method body
 *
 * @author Akram
 * @date 18/01/2023
 */
public abstract class AbstractMethodBody extends Tree {

    protected abstract void verifyMethodBody(DecacCompiler compiler, ClassDefinition currentClass,
                                             EnvironmentExp paramEnv, Type returnType) 
                    throws ContextualError;

    public abstract void codeGenMethodBody(DecacCompiler compiler, IMAProgram subProgram
                                , Label returnLabel);

}
