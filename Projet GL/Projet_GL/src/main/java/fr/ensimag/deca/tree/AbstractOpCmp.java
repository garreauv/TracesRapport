package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.WFLOAT;
import fr.ensimag.ima.pseudocode.instructions.WFLOATX;
import fr.ensimag.ima.pseudocode.instructions.WINT;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;

/**
 *
 * @author gl19
 * @date 01/01/2023
 */
public abstract class AbstractOpCmp extends AbstractBinaryExpr {

    public AbstractOpCmp(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        Type lType = getLeftOperand().verifyExpr(compiler, localEnv, currentClass);
        Type rType = getRightOperand().verifyExpr(compiler, localEnv, currentClass);

        if (lType.isBoolean() && rType.isBoolean()){
            this.setType(lType);
            return lType;
        }
        else if ((lType.isInt() || lType.isFloat()) && (rType.isInt() || rType.isFloat())){
            setLeftOperand(getLeftOperand().verifyRValue(compiler, localEnv, currentClass, rType));
            setRightOperand(getRightOperand().verifyRValue(compiler, localEnv, currentClass, lType));    
            this.setType(compiler.environmentType.BOOLEAN);
            return this.getType();
        }
        else {
            throw new ContextualError("Invalid types for " + getOperatorName() 
            + " : (" + lType.getName().getName() + ",  " + rType.getName().getName() + ")", getLocation());
        }
    }

    @Override
    public void codeGenPrint(DecacCompiler compiler){
        codeGenInst(compiler);
        compiler.addInstruction(new LOAD(Register.getR(compiler.getStoreRegister()), Register.getR(1)));
        if (getType().isInt()){
            compiler.addInstruction(new WINT());
        }
        else if (getType().isFloat()){
            compiler.addInstruction(new WFLOAT());
        }
    }

    @Override
    public void codeGenPrintHex(DecacCompiler compiler){
        codeGenInst(compiler);
        compiler.addInstruction(new LOAD(Register.getR(compiler.getStoreRegister()), Register.getR(1)));
        if (getType().isInt()){
            compiler.addInstruction(new WINT());
        }
        else if (getType().isFloat()){
            compiler.addInstruction(new WFLOATX());
        }
    }


}
