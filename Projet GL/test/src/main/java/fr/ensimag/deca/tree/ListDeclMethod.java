package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.IMAProgram;

import org.apache.log4j.Logger;

/**
 *
 * @author Louis
 * @date 08/01/2023
 */

public class ListDeclMethod extends TreeList<AbstractDeclMethod> {
    
    
    private static final Logger LOG = Logger.getLogger(ListDeclMethod.class);
    
    @Override
    public void decompile(IndentPrintStream s) {
        for (AbstractDeclMethod c : getList()) {
            c.decompile(s);
            s.println();
        }
    }

    protected void verifyListDeclMethod(DecacCompiler compiler, ClassDefinition currentClass) 
                    throws ContextualError{
        for (AbstractDeclMethod m : getList()) {
            m.verifyDeclMethod(compiler, currentClass);
        }
    }

    public void verifyListDeclMethodBody(DecacCompiler compiler, ClassDefinition classDef)
                    throws ContextualError {
        for (AbstractDeclMethod m : getList()){
            m.verifyDeclMethodBody(compiler, classDef);
            
        }
    }

    public void codeGenMethodBody(DecacCompiler compiler, IMAProgram subProgram
                                , ClassDefinition classDef){
        for (AbstractDeclMethod m : getList()){
            m.methodDeclCodeGen(compiler, subProgram, classDef);
            
        }
    }

    
}
