package fr.ensimag.deca.codegen;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.ima.pseudocode.Label;

public abstract class ExecutionError{

    protected DecacCompiler compiler;
    public Label errorLabel;

    public ExecutionError(DecacCompiler compiler) {
        this.compiler = compiler;
    }

    public abstract void genCodeError(DecacCompiler compiler);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExecutionError executionError = (ExecutionError) o;
        return errorLabel == executionError.errorLabel || (errorLabel != null && errorLabel.equals(executionError.errorLabel));
    }

    @Override
    public int hashCode() {
        return errorLabel != null ? errorLabel.hashCode() : 0;
    }
    
}