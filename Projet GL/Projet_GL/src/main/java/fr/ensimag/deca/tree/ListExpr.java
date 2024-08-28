package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;
import java.util.Iterator;
/**
 * List of expressions (eg list of parameters).
 *
 * @author gl19
 * @date 01/01/2023
 */
public class ListExpr extends TreeList<AbstractExpr> {

    @Override
    public void decompile(IndentPrintStream s) {
    if(!getList().isEmpty()){
        int i;
        for (i=0;i<(getList().size())-1;i++) {
            getList().get(i).decompile(s);
            s.print(", ");
        }
        getList().get(i).decompile(s);
    }
    }
}
