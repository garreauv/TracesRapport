package fr.ensimag.deca.tree;

import fr.ensimag.deca.context.Type;
import fr.ensimag.deca.tools.IndentPrintStream;
import fr.ensimag.deca.tools.SymbolTable.Symbol;
import fr.ensimag.ima.pseudocode.DAddr;
import fr.ensimag.ima.pseudocode.ImmediateInteger;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.BEQ;
import fr.ensimag.ima.pseudocode.instructions.BNE;
import fr.ensimag.ima.pseudocode.instructions.CMP;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.STORE;

import java.io.PrintStream;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ClassType;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.Definition;
import fr.ensimag.deca.context.EnvironmentExp;
import fr.ensimag.deca.context.FieldDefinition;

/**
 * Selection, i.e. lvalue.expr.
 *
 * @author Louis
 * @date 08/01/2023
 */
public class Selection extends AbstractLValue{
    
    private final AbstractExpr expr;
    private final AbstractIdentifier field_ident;

    public AbstractExpr getExpr(){
        return this.expr;
    }

    public Selection(AbstractExpr expr, AbstractIdentifier field_ident) {
        this.expr = expr;
        this.field_ident = field_ident;
    }

    @Override
    public Type verifyExpr(DecacCompiler compiler, EnvironmentExp localEnv,
            ClassDefinition currentClass) throws ContextualError {
        Type exprType = expr.verifyExpr(compiler, localEnv, currentClass);
        exprType = compiler.environmentType.defOfType(exprType.getName()).getType();
        ClassType exprClass = exprType.asClassType(exprType.getName() + "is not a class type.", getLocation());
        EnvironmentExp fieldEnv = exprClass.getDefinition().getMembers();
        Type fieldType;
        try {
            fieldType = field_ident.verifyExpr(compiler, fieldEnv, currentClass);
        } catch (ContextualError c){
            throw new ContextualError("Class " + exprClass.getName()
                                + " does not have attribute " + field_ident.getName(), getLocation());
        }
        FieldDefinition fieldDef = field_ident.getFieldDefinition();
        ClassDefinition fieldClass = fieldDef.getContainingClass();
        Visibility fieldVisibility = fieldDef.getVisibility();
        
        if (fieldVisibility == Visibility.PROTECTED){
            if (!exprClass.isSubClassOf(currentClass.getType())){
                throw new ContextualError("Cannot access protected attribute " + field_ident.getName()
                                + ". " + exprClass.getName() + " must be a subclass of " + currentClass.getType().getName()
                                            , getLocation());
            }
            if (!currentClass.getType().isSubClassOf(fieldClass.getType())){
                throw new ContextualError("Cannot access protected attribute " + field_ident.getName()
                                + ". " + currentClass.getType().getName() + " must be a subclass of " 
                                + fieldClass.getType().getName(), getLocation());
            }
        }

        setType(fieldType);
        return fieldType;
    }

    
    @Override
    protected void codeGenInst(DecacCompiler compiler) {

        FieldDefinition fieldDefinition = getFieldDefinition();
        if(expr instanceof ThisLiteral){
            compiler.addInstruction(new LOAD(new RegisterOffset(-2, Register.LB), 
                                    Register.getR(1)));
        }else{
            expr.codeGenInst(compiler);         
            compiler.addInstruction(new LOAD(Register.getR(compiler.getNCurrRegister()), 
                                    Register.getR(1)));
        }

        
        compiler.addInstruction(new LOAD(new RegisterOffset(fieldDefinition.getIndex(), Register.getR(1)), 
                                                            Register.getR(compiler.getNCurrRegister())));

    }

    
    @Override
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
    public void decompile(IndentPrintStream s) {
        expr.decompile(s);
        s.print(".");
        field_ident.decompile(s);
        
    }

    @Override
    protected void prettyPrintChildren(PrintStream s, String prefix) {
        expr.prettyPrint(s, prefix, false);
        field_ident.prettyPrint(s, prefix, true);
        
    }

    public FieldDefinition getFieldDefinition(){
        return this.field_ident.getFieldDefinition();
    }


    @Override
    protected void iterChildren(TreeFunction f) {
        expr.iter(f);
        field_ident.iter(f);
    }



}
