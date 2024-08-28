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
import fr.ensimag.ima.pseudocode.*;
import fr.ensimag.ima.pseudocode.instructions.*;
/**
 * Assignment, i.e. lvalue = expr.
 *
 * @author gl19
 * @date 01/01/2023
 */
public class Assign extends AbstractBinaryExpr {

    @Override
    public AbstractLValue getLeftOperand() {
        // The cast succeeds by construction, as the leftOperand has been set
        // as an AbstractLValue by the constructor.
        return (AbstractLValue)super.getLeftOperand();
    }

    public Assign(AbstractExpr leftOperand, AbstractExpr rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        AbstractLValue lValue = getLeftOperand();
        AbstractExpr expr = getRightOperand();

        Type lValueType = lValue.verifyExpr(compiler, localEnv, currentClass);
        Type exprType = expr.verifyExpr(compiler, localEnv, currentClass);

        if (!lValueType.isCompatible(compiler, exprType)){
            throw new ContextualError("Type mismatch, cannot assign " + lValueType.getName().getName()
                                + " to " + exprType.getName().getName(), getLocation());
        }

        this.setType(lValueType);
        return lValueType;
    }


    @Override
    protected String getOperatorName() {
        return "=";
    }

    @Override
    public void codeGenInst(DecacCompiler compiler){

    if( getLeftOperand() instanceof Identifier ) {

        Identifier lValue = (Identifier)getLeftOperand();

        if( ! (lValue.getDefinition() instanceof FieldDefinition) ){

        VariableDefinition variableDefinition = lValue.getVariableDefinition();
        getRightOperand().codeGenInst(compiler);
        compiler.resetNCurrRegister();
        compiler.addInstruction(new STORE(Register.getR(compiler.getStoreRegister()),
                                                    variableDefinition.getOperand()));
       
        }else{

            DAddr addr;
            FieldDefinition fieldDefinition = lValue.getFieldDefinition();
            getRightOperand().codeGenInst(compiler);
            compiler.resetNCurrRegister();
        
            addr = new RegisterOffset(-2, Register.LB);
         
            compiler.addInstruction(new LOAD(addr, Register.getR(1)));
            compiler.addInstruction(new STORE(Register.getR(compiler.getStoreRegister()),
                    new RegisterOffset(fieldDefinition.getIndex(), Register.getR(1))));

        }

    }else{
        DAddr addr;
        Selection lValue = (Selection)getLeftOperand();
        FieldDefinition fieldDefinition = lValue.getFieldDefinition();
        getRightOperand().codeGenInst(compiler);
        compiler.resetNCurrRegister();
    
        if(lValue.getExpr() instanceof ThisLiteral){
            addr = new RegisterOffset(-2, Register.LB);
        }else{
            addr = fieldDefinition.getContainingClass().getOperand();
        }
    
        compiler.addInstruction(new LOAD(addr, Register.getR(1)));
        compiler.addInstruction(new STORE(Register.getR(compiler.getStoreRegister()),
                new RegisterOffset(fieldDefinition.getIndex(), Register.getR(1))));
        
    }

  
       
    

    }

}
