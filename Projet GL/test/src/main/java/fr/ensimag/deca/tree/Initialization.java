package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.context.VariableDefinition;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.Definition;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.ExpDefinition;
import fr.ensimag.deca.context.FieldDefinition;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.STORE;

import java.io.PrintStream;
import org.apache.commons.lang.Validate;

/**
 * @author gl19
 * @date 01/01/2023
 */
public class Initialization extends AbstractInitialization {

    public AbstractExpr getExpression() {
        return expression;
    }

    private AbstractExpr expression;

    public void setExpression(AbstractExpr expression) {
        Validate.notNull(expression);
        this.expression = expression;
    }

    public Initialization(AbstractExpr expression) {
        Validate.notNull(expression);
        this.expression = expression;
    }

    @Override
    protected void verifyInitialization(DecacCompiler compiler, Type t,
            EnvironmentExp localEnv, ClassDefinition currentClass)
            throws ContextualError {
        Type expressionType = expression.verifyExpr(compiler, localEnv, currentClass);
        if (!t.isCompatible(compiler, expressionType)){
            throw new ContextualError("Type mismatch : Expected " + t.getName().getName()
            + " but got " + expressionType.getName().getName(), expression.getLocation());
        }
        else if(t.isFloat() && expressionType.isInt()){
            expression = new ConvFloat(expression);
            expression.verifyExpr(compiler, localEnv, currentClass);
        }
    }


    @Override
    public void decompile(IndentPrintStream s) {
        s.print("=");
        getExpression().decompile(s);
    }

    @Override
    protected
    void iterChildren(TreeFunction f) {
        expression.iter(f);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        expression.prettyPrint(s, prefix, true);
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler, ExpDefinition definition) {
        expression.codeGenInst(compiler);
        compiler.resetNCurrRegister();
        if (definition.isField()){
            FieldDefinition fieldDef = (FieldDefinition) definition;
            compiler.addInstruction(new STORE(Register.getR(compiler.getStoreRegister()), 
                                        new RegisterOffset(fieldDef.getIndex(), Register.R1)));
        }
        else {
            compiler.addInstruction(new STORE(Register.getR(compiler.getStoreRegister()),
                                                     definition.getOperand()));
        }
    }
}
