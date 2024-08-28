package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.FLOAT;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;

/**
 * Cast
 * 
 * @author gl19
 * @date 18/01/2023
 */
public class Cast extends AbstractUnaryExpr {
    final private AbstractIdentifier type;

    public Cast(AbstractIdentifier type, AbstractExpr operand) {
        super(operand);
        this.type = type;
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        Type castType = type.verifyType(compiler);
        Type exprType = getOperand().verifyExpr(compiler, localEnv, currentClass);
        if (!castType.castCompatible(compiler, exprType)){
            throw new ContextualError("Cannot cast " + exprType.getName() 
                                    + " to " + castType.getName(), getLocation());       
        }
        return castType;
    }

    @Override
    public void decompile(IndentPrintStream s) {
        s.print(getOperatorName());
        s.print("(");
        getOperand().decompile(s);
        s.print(")");
    }

    @Override
    protected String getOperatorName() {
        return "("+type.getName()+")";
    }

    @Override
    protected void codeGenInst(DecacCompiler compiler) {
        throw new UnsupportedOperationException();
    }

}
