package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.*;

import java.io.PrintStream;
import org.apache.commons.lang.Validate;

/**
 * Full if/else if/else statement.
 *
 * @author gl19
 * @date 01/01/2023
 */
public class IfThenElse extends AbstractInst {
    
    private final AbstractExpr condition; 
    private final ListInst thenBranch;
    private ListInst elseBranch;

    public IfThenElse(AbstractExpr condition, ListInst thenBranch, ListInst elseBranch) {
        Validate.notNull(condition);
        Validate.notNull(thenBranch);
        Validate.notNull(elseBranch);
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }
    
    public void changeElseBranch(ListInst elseBranch){
        Validate.notNull(elseBranch);
        this.elseBranch = elseBranch;
    }

    @Override
    public void setMethodLabel(Label l){
        elseBranch.setMethodLabel(l);
        thenBranch.setMethodLabel(l);
        methodLabel = l;
    }

    public AbstractExpr getCondition(){
        return this.condition;
    }

    public ListInst getThenBranch(){
        return this.thenBranch;
    }

    public ListInst getElseBranch(){
        return this.elseBranch;
    }

    @Override
    protected void verifyInst(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass, Type returnType)
            throws ContextualError {
        condition.verifyCondition(compiler, localEnv, currentClass);
        thenBranch.verifyListInst(compiler, localEnv, currentClass, returnType);
        elseBranch.verifyListInst(compiler, localEnv, currentClass, returnType);
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler) {
        Label elseLabel = new Label("E_Sinon." + compiler.getElseLabelIndex() 
                                    + compiler.getLabelIndex());
        Label endIfLabel = new Label("E_Fin." + compiler.getElseLabelIndex());
        compiler.incrementElseLabelIndex();
        compiler.incrementLabelIndex();
        condition.codeGenCondition(compiler, false, elseLabel);
        thenBranch.codeGenListInst(compiler);
        compiler.addInstruction(new BRA(endIfLabel));
        compiler.addLabel(elseLabel);
        elseBranch.codeGenListInst(compiler);
        compiler.addLabel(endIfLabel);
    }

    @Override
    public void decompile(IndentPrintStream s) {
        s.print("if (");
        getCondition().decompile(s);
        s.print(") { ");

        s.println();
        s.indent();
        getThenBranch().decompile(s);
        s.unindent();
        
        s.print("} else { ");

        s.indent();
        s.println();
        getElseBranch().decompile(s);
        s.unindent();

        s.print("}");
    }

    @Override
    protected
    void iterChildren(TreeFunction f) {
        condition.iter(f);
        thenBranch.iter(f);
        elseBranch.iter(f);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        condition.prettyPrint(s, prefix, false);
        thenBranch.prettyPrint(s, prefix, false);
        elseBranch.prettyPrint(s, prefix, true);
    }
}
