package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;


public class ListDeclField extends TreeList<AbstractDeclField> {

    @Override
    public void decompile(IndentPrintStream s) {
        for (AbstractDeclField v : getList()) {
            v.decompile(s);
            s.println();
        }
    }

    protected void verifyListDeclField(DecacCompiler compiler, ClassDefinition currentClass)
                    throws ContextualError {
        for (AbstractDeclField v : getList()) {
            v.verifyDeclField(compiler, currentClass);
        }
    }

    public void verifyListDeclFieldBody(DecacCompiler compiler, ClassDefinition classDef)
                    throws ContextualError {
        for (AbstractDeclField v : getList()) {
            v.verifyDeclFieldBody(compiler, classDef);
        }
    } 

}
