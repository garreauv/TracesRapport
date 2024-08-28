package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;

/**
 *
 * @author gl19
 * @date 01/01/2023
 */
public abstract class AbstractOpBool extends AbstractBinaryExpr {

    public AbstractOpBool(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        Type lType = getLeftOperand().verifyExpr(compiler, localEnv, currentClass);
        Type rType = getRightOperand().verifyExpr(compiler, localEnv, currentClass);

        if (!(lType.isBoolean() && rType.isBoolean())){
            throw new ContextualError("Invalid types for " + getOperatorName()
            + " : (" + lType.getName().getName() + ",  " + rType.getName().getName() + ")", getLocation());
        }
        this.setType(lType);
        return lType;
    }

}
