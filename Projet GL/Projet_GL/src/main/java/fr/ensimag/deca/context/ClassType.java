package fr.ensimag.deca.context;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.tools.SymbolTable.Symbol;
import fr.ensimag.deca.tree.Location;
import org.apache.commons.lang.Validate;

/**
 * Type defined by a class.
 *
 * @author gl19
 * @date 01/01/2023
 */
public class ClassType extends Type {
    
    protected ClassDefinition definition;
    
    public ClassDefinition getDefinition() {
        return this.definition;
    }
            
    @Override
    public ClassType asClassType(String errorMessage, Location l) {
        return this;
    }

    @Override
    public boolean isClass() {
        return true;
    }

    @Override
    public boolean isClassOrNull() {
        return true;
    }

    /**
     * Standard creation of a type class.
     */
    public ClassType(Symbol className, Location location, ClassDefinition superClass) {
        super(className);
        this.definition = new ClassDefinition(this, location, superClass);
    }

    /**
     * Creates a type representing a class className.
     * (To be used by subclasses only)
     */
    protected ClassType(Symbol className) {
        super(className);
    }
    

    @Override
    public boolean sameType(Type otherType) {
        if (!otherType.isClass()){
            return false;
        }
        return getName() == otherType.getName();
    }

    /**
     * Return true if potentialSuperClass is a superclass of this class.
     */
    public boolean isSubClassOf(ClassType potentialSuperClass) {
        if (definition.getType().sameType(potentialSuperClass)){
            return true;
        }
        else if (definition.getSuperClass() != null){
            return definition.getSuperClass().getType().isSubClassOf(potentialSuperClass);
        }
        else {
            return false;
        }
    }

    @Override
    public boolean isCompatible(DecacCompiler compiler, Type rType){
        ClassType potentialSuperClass;
        if (rType.isNull()){
            return true;
        }
        try {
        potentialSuperClass = rType.asClassType("", Location.BUILTIN);
        } catch (ContextualError c){
            return false;
        }
        return isSubClassOf(potentialSuperClass);
    }


}
