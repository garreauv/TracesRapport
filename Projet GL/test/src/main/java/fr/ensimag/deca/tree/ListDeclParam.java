package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Signature;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import java.util.Iterator;


public class ListDeclParam extends TreeList<AbstractDeclParam> {

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

 
    public Signature verifyListDeclParam(DecacCompiler compiler, ClassDefinition currentClass)
                 throws ContextualError {
        Signature methodSignature = new Signature();
        for (AbstractDeclParam p : getList()){
            Type paramType = p.verifyDeclParam(compiler, currentClass);
            methodSignature.add(paramType);
        }
        return methodSignature;
    }


    public EnvironmentExp verifyListDeclParamBody(DecacCompiler compiler, ClassDefinition classDef)
                throws ContextualError {
        EnvironmentExp paramEnv = new EnvironmentExp(null);
        for (AbstractDeclParam p : getList()){
            p.verifyDeclParamBody(compiler, classDef, paramEnv);
        }
        return paramEnv;
    }


}
