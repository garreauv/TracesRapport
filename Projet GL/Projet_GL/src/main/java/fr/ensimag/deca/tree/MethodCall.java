package fr.ensimag.deca.tree;

import java.io.PrintStream;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.codegen.DeferencementNull;
import fr.ensimag.deca.codegen.ExecutionError;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ClassType;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.MethodDefinition;
import fr.ensimag.deca.context.Signature;
import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.DAddr;
import fr.ensimag.ima.pseudocode.GPRegister;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.ADDSP;
import fr.ensimag.ima.pseudocode.instructions.BEQ;
import fr.ensimag.ima.pseudocode.instructions.BNE;
import fr.ensimag.ima.pseudocode.instructions.BSR;
import fr.ensimag.ima.pseudocode.instructions.CMP;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.ima.pseudocode.instructions.PUSH;
import fr.ensimag.ima.pseudocode.instructions.STORE;
import fr.ensimag.ima.pseudocode.instructions.SUBSP;
import fr.ensimag.ima.pseudocode.instructions.WINT;
import fr.ensimag.ima.pseudocode.NullOperand;

import java.io.PrintStream;

import org.apache.commons.lang.Validate;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.VariableDefinition;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.ima.pseudocode.DVal;
import fr.ensimag.ima.pseudocode.Register;

/**
 *
 * @author gl19
 * @date 01/01/2023
 */
public class MethodCall extends AbstractExpr{

    private ListExpr param;

    public MethodCall(AbstractExpr leftOperand, AbstractIdentifier rightOperand, ListExpr param) {
        Validate.notNull(leftOperand, "left operand cannot be null");
        Validate.notNull(rightOperand, "right operand cannot be null");
        Validate.isTrue(leftOperand != rightOperand, "Sharing subtrees is forbidden");
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.param=param;
    }

    public ListExpr getParam() {
        return param;
    }


    public AbstractExpr getLeftOperand() {
        return leftOperand;
    }

    public AbstractIdentifier getRightOperand() {
        return rightOperand;
    }

    protected void setLeftOperand(AbstractExpr leftOperand) {
        Validate.notNull(leftOperand);
        this.leftOperand = leftOperand;
    }

    protected void setRightOperand(AbstractIdentifier rightOperand) {
        Validate.notNull(rightOperand);
        this.rightOperand = rightOperand;
    }

    private AbstractExpr leftOperand;
    private AbstractIdentifier rightOperand;


    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        ClassType classType = leftOperand.verifyExpr(compiler, localEnv, currentClass)
                            .asClassType(leftOperand.getType().getName() + " is not a class type.", getLocation());
        EnvironmentExp env_exp2 = compiler.getClassDef(classType.getName(), getLocation()).getMembers();
        Type methodType = rightOperand.verifyExpr(compiler, env_exp2, currentClass);
        MethodDefinition methodDefinition = rightOperand.getMethodDefinition();
        Signature methodSignature = methodDefinition.getSignature();
        if (param.getList().size() != methodSignature.size()){
            throw new ContextualError("Method " + rightOperand.getName() 
                        + " declared in class " + classType.getName() + " called with wrong signature.", getLocation());
        }
        int i = 0;
        for (AbstractExpr e : param.getList()){
            try {
                e.verifyRValue(compiler, localEnv, currentClass, methodSignature.paramNumber(i));
            } catch (ContextualError c){
                throw new ContextualError("Method " + rightOperand.getName() 
                        + " declared in class " + classType.getName() + " called with wrong signature.", getLocation());
            }
            i++;
        }

        setType(methodType);
        return methodType;
    }

    
    protected void codeGenCondition(DecacCompiler compiler, boolean bool, 
    Label branchLabel){
        this.codeGenInst(compiler);
        
        compiler.addInstruction(new CMP(new ImmediateInteger(1) ,Register.getR(compiler.getNCurrRegister())));
        if (bool){
            compiler.addInstruction(new BEQ(branchLabel));
        }
        else {
            compiler.addInstruction(new BNE(branchLabel));
        }

    }

    @Override
    protected void codeGenInst(DecacCompiler compiler) {        

        
        compiler.addComment("Appel de méthode :");

        int size = this.param.getList().size();
        
        compiler.addInstruction(new ADDSP(size+1));  
    
        
        int n = compiler.getNCurrRegister();

        getLeftOperand().codeGenInst(compiler);
        compiler.addInstruction(new STORE(Register.getR(n), new RegisterOffset(0, Register.SP)));
        
        // Storing every parameter in the pile in a decreasing order/
        int i = -1;
        for(AbstractExpr p : this.param.getList()){
            p.codeGenInst(compiler);
            compiler.addInstruction(new STORE(Register.getR(compiler.getNCurrRegister()), 
                    new RegisterOffset(i, Register.SP)));
            compiler.addNCurrRegister();
            i--;
        } 
        // On load le paramètre implicite (auquel s'applique la méthode) /
        compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.SP),Register.getR(n)));
        // Vérification dérérencement null /
        compiler.addInstruction(new CMP(new NullOperand(), Register.getR(n)));
        compiler.addInstruction(new BEQ(new Label("NullDeferenceError")));
        ExecutionError defNull = new DeferencementNull(compiler);
        compiler.getHandledError().add(defNull);

        //ExecutionError defNull = new DeferencementNull(compiler);
        //compiler.getHandledError().add(defNull);
        
        //Get the adress of the method /
        compiler.addInstruction(new LOAD(new RegisterOffset(0, Register.getR(n)), 
                Register.getR(n)));

        int preCurrRegister = compiler.getNCurrRegister();
                
                
        // Find the offset value stored when declaring the methods /
        int index = this.rightOperand.getMethodDefinition().getIndex();
        
        compiler.addInstruction(new BSR(new RegisterOffset(index, Register.getR(n))));
        compiler.incrementTSTO();
        compiler.addInstruction(new SUBSP(size));

        compiler.setNCurrRegister(preCurrRegister);
        compiler.addInstruction(new LOAD(Register.getR(0), Register.getR(compiler.getStoreRegister())));


    }

    @Override
    public void decompile(IndentPrintStream s) {
        getLeftOperand().decompile(s);
        s.print(".");  
        getRightOperand().decompile(s);
        s.print("( ");  
        param.decompile(s);
        s.print(" )");  
    }

    @Override
    protected void iterChildren(TreeFunction f) {
        leftOperand.iter(f);
        rightOperand.iter(f);
        param.iter(f);
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        leftOperand.prettyPrint(s, prefix, false);
        rightOperand.prettyPrint(s, prefix, false);
        param.prettyPrint(s, prefix, true);
    }

    protected void codeGenPrint(DecacCompiler compiler) {
        codeGenInst(compiler); 
        compiler.addInstruction(new LOAD(Register.getR(compiler.getNCurrRegister()), Register.getR(1)));
        compiler.addInstruction(new WINT());
        
    }
}
