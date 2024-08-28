package fr.ensimag.deca.tree;

import java.io.PrintStream;

import org.apache.commons.lang.Validate;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.DAddr;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.BEQ;
import fr.ensimag.ima.pseudocode.instructions.BNE;
import fr.ensimag.ima.pseudocode.instructions.CMP;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.STORE;

import fr.ensimag.ima.pseudocode.NullOperand;

/**
 *
 * @author gl19
 * @date 01/01/2023
 */
public class InstanceOf extends AbstractExpr {

    private final AbstractExpr expr;
    private final AbstractIdentifier type;




    public InstanceOf(AbstractExpr expr, AbstractIdentifier type) {
        Validate.notNull(type);
        Validate.notNull(expr);
        this.expr = expr;
        this.type = type;
    }


    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        Type exprType = expr.verifyExpr(compiler, localEnv, currentClass);
        Type instanceType = type.verifyType(compiler);
        if (!exprType.instanceof_op(compiler, exprType)){
            throw new ContextualError("Types " + exprType.getName() +
                            " and " + instanceType.getName() + " are not compatible for instanceOf operator."
                                        , getLocation());  
        }
        return (compiler.environmentType.BOOLEAN);

    }



    @Override
    protected void codeGenInst(DecacCompiler compiler) {

        
        int storeRegisterNumber = compiler.getNCurrRegister();
        compiler.addInstruction(new LOAD(0, Register.getR(storeRegisterNumber)));

        //R1 = ADDR TYPE TO CMP
        compiler.addInstruction(new LOAD(type.getClassDefinition().getOperand(), Register.getR(1)));

        if( this.expr instanceof Identifier) {
            Identifier lValue = (Identifier)this.expr;
            compiler.addInstruction(new LOAD(lValue.getClassDefinition().getOperand(),
            Register.getR(0)));
        }
        
        //METHOD AND SELECTION RETURN ON R0!!!    
    
        Label whileLabel = new Label("E_Debut." + compiler.getElseLabelIndex());
        Label conditionLabel = new Label("E_Cond." + compiler.getElseLabelIndex());
        compiler.incrementElseLabelIndex();

        this.codeGenCondition(compiler, true, whileLabel);

        compiler.addLabel(whileLabel);


        compiler.addInstruction(new LOAD (Register.getR(0),Register.getR(0)));

        compiler.addLabel(conditionLabel);

        this.codeGenCondition(compiler, true, whileLabel);

    }

    @Override
    protected void codeGenCondition(DecacCompiler compiler, boolean bool, 
                Label branchLabel){

        Label endLabel = new Label("E_Fin." + compiler.getElseLabelIndex() 
                    + compiler.getLabelIndex());
        compiler.incrementLabelIndex();

        compiler.addInstruction(new CMP(null, Register.getR(0)));
        compiler.addInstruction(new BEQ(endLabel));
        
        compiler.addInstruction(new CMP(Register.getR(0), Register.getR(1)));
        compiler.addInstruction(new BNE(branchLabel));
        
        // compiler.addInstruction(new LOAD(1, Register.getR(storeRegisterNumber)));

        compiler.addLabel(endLabel);


    }
    
        
    


    @Override
    public void decompile(IndentPrintStream s) {
        expr.decompile(s);
        s.print(" instanceof ");
        type.decompile(s);
    }


    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        expr.prettyPrint(s, prefix, false);
        expr.prettyPrint(s, prefix, true);
        
    }


    @Override
    protected void iterChildren(TreeFunction f) {
        expr.iter(f);
        type.iter(f);
        
    }

}
