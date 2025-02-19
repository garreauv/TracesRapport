package fr.ensimag.ima.pseudocode;

/**
 * Operand of an IMA Instruction.
 *
 * @author Ensimag
 * @date 01/01/2023
 */
public abstract class Operand {
    @Override
    public abstract String toString();

    // Mark registers that need to be pushed then popped when calling
    // a method
    public boolean isPushed = false;
}
