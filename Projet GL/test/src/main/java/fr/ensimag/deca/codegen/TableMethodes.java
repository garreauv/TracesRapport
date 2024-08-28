package fr.ensimag.deca.codegen;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.DVal;
import fr.ensimag.ima.pseudocode.Label;
import fr.ensimag.ima.pseudocode.LabelOperand;
import fr.ensimag.ima.pseudocode.NullOperand;
import fr.ensimag.ima.pseudocode.Register;
import fr.ensimag.ima.pseudocode.RegisterOffset;
import fr.ensimag.ima.pseudocode.instructions.BEQ;
import fr.ensimag.ima.pseudocode.instructions.BNE;
import fr.ensimag.ima.pseudocode.instructions.CMP;
import fr.ensimag.ima.pseudocode.instructions.LEA;
import fr.ensimag.ima.pseudocode.instructions.LOAD;
import fr.ensimag.ima.pseudocode.instructions.POP;
import fr.ensimag.ima.pseudocode.instructions.PUSH;
import fr.ensimag.ima.pseudocode.instructions.RTS;
import fr.ensimag.ima.pseudocode.instructions.STORE;

/**
 * This class allows us to create the start of the methods table and also generate the code for the method
 * equals from the class object
 * 
 * @author Adrien
 * @date 17/01/2023
 */
public class TableMethodes{

    public TableMethodes() {
    }

    /* Generation of the object class in the methods table: will be called ONLY ONE TIME AT THE BEGGINING */
    public void codeGenObj(DecacCompiler compiler){
        /* Methods table for object */
        compiler.addInstruction(new LOAD((DVal)new NullOperand(), Register.getR(0)));
        compiler.addInstruction(new STORE(Register.getR(0), new RegisterOffset(compiler.getStackPointer(), Register.GB)));;
        compiler.incrementStackPointer();
        compiler.incrementADDSP();
        /* We put @Object.equals in 2(GB) */
        Label ObjectEquals = new Label("code.Object.equals");
        compiler.addInstruction(new LOAD(new LabelOperand(ObjectEquals), Register.getR(0)));
        compiler.addInstruction(new STORE(Register.getR(0), new RegisterOffset(compiler.getStackPointer(), Register.GB)));
        compiler.incrementStackPointer();
        compiler.incrementADDSP();
    }   

    /* Generates the instructions for the method equals by default (from the class object) */
    public void codeGenEquals(DecacCompiler compiler){
        compiler.addLabel(new Label("code.Object.equals"));
        Label equal = new Label("object.equals.equal");
        Label notEqual = new Label("object.equals.notequal");
        Label end = new Label("object.equals.end");
        /* Saving R2 */
        compiler.addInstruction(new PUSH(Register.getR(2)));
        compiler.incrementADDSP();
        compiler.addInstruction(new LEA(new RegisterOffset(-2, Register.LB),Register.getR(2)));
        /* Comparing this and the object in parameter */
        compiler.addInstruction(new CMP(new RegisterOffset(-3, Register.LB),Register.getR(2)));
        compiler.addInstruction(new BEQ(equal));
        compiler.addInstruction(new BNE(notEqual));
        /* If the operands are equal */
        compiler.addLabel(equal);
        compiler.addInstruction(new LOAD(1, Register.getR(0)));
        /* If not equal */
        compiler.addLabel(notEqual);
        compiler.addInstruction(new LOAD(0, Register.getR(0)));
        /* End */
        compiler.addLabel(end);
        compiler.addInstruction(new POP(Register.getR(2))); //restoring R2
        compiler.addInstruction(new RTS());
    }



}