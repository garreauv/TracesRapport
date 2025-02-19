package fr.ensimag.ima.pseudocode;

import java.io.PrintStream;
import org.apache.commons.lang.Validate;

/**
 * Base class for instructions with 2 operands.
 *
 * @author Ensimag
 * @date 01/01/2023
 */
public class BinaryInstruction extends Instruction {
    private Operand operand1, operand2;

    protected void setOperand1(Operand operand1) {
        this.operand1 = operand1;
    }

    protected void setOperand2(Operand operand2) {
        this.operand2 = operand2;
    }

    public Operand getOperand1() {
        return operand1;
    }

    public Operand getOperand2() {
        return operand2;
    }

    @Override
    public void markUsedRegister(){
        getOperand1().isPushed = true;
        getOperand2().isPushed = true;
    }

    @Override
    void displayOperands(PrintStream s) {
        s.print(" ");
        s.print(operand1);
        s.print(", ");
        s.print(operand2);
    }

    protected BinaryInstruction(Operand op1, Operand op2) {
        Validate.notNull(op1);
        Validate.notNull(op2);
        this.operand1 = op1;
        this.operand2 = op2;
    }
}
