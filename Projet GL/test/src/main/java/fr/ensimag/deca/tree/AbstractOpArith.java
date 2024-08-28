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
import fr.ensimag.deca.context.FloatType;
import fr.ensimag.deca.context.IntType;

/**
 * Arithmetic binary operations (+, -, /, ...)
 * 
 * @author gl19
 * @date 01/01/2023
 */
public abstract class AbstractOpArith extends AbstractBinaryExpr {

    public AbstractOpArith(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        Type lType = getLeftOperand().verifyExpr(compiler, localEnv, currentClass);
        Type rType = getRightOperand().verifyExpr(compiler, localEnv, currentClass);
        
        if (!(lType.isInt() || lType.isFloat()) || !(rType.isInt()
            || rType.isFloat())){
                throw new ContextualError("Invalid types for " + getOperatorName()
                + " : (" + lType.getName().getName() + ",  " + rType.getName().getName() + ")", getLocation());
            }


        Type result = lType.isInt() && rType.isInt() ? lType :
                      lType.isInt() && rType.isFloat() ? rType :
                      lType;
        setLeftOperand(getLeftOperand().verifyRValue(compiler, localEnv, currentClass, result));
        setRightOperand(getRightOperand().verifyRValue(compiler, localEnv, currentClass, result));              
        this.setType(result);

        return result;



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
    
    // public abstract void codeGenInst(DecacCompiler compiler);

    
}
