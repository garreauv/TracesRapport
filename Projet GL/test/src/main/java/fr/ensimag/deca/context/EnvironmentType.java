package fr.ensimag.deca.context;

import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.context.EnvironmentExp.DoubleDefException;

import java.util.HashMap;
import java.util.Map;
import fr.ensimag.deca.tools.SymbolTable.Symbol;
import fr.ensimag.deca.tree.Location;
import fr.ensimag.ima.pseudocode.Label;

/**
 * Environment containing types. Initially contains predefined identifiers, more
 * classes can be added with declareClass().
 *
 * @author gl19
 * @date 01/01/2023
 */
public class EnvironmentType {
    public EnvironmentType(DecacCompiler compiler){
        
        envTypes = new HashMap<Symbol, TypeDefinition>();
        
        Symbol intSymb = compiler.createSymbol("int");
        INT = new IntType(intSymb);
        envTypes.put(intSymb, new TypeDefinition(INT, Location.BUILTIN));

        Symbol floatSymb = compiler.createSymbol("float");
        FLOAT = new FloatType(floatSymb);
        envTypes.put(floatSymb, new TypeDefinition(FLOAT, Location.BUILTIN));

        Symbol voidSymb = compiler.createSymbol("void");
        VOID = new VoidType(voidSymb);
        envTypes.put(voidSymb, new TypeDefinition(VOID, Location.BUILTIN));

        Symbol booleanSymb = compiler.createSymbol("boolean");
        BOOLEAN = new BooleanType(booleanSymb);
        envTypes.put(booleanSymb, new TypeDefinition(BOOLEAN, Location.BUILTIN));

        Symbol stringSymb = compiler.createSymbol("string");
        STRING = new StringType(stringSymb);
        // not added to envTypes, it's not visible for the user.
        
        Symbol objectSymbol = compiler.createSymbol("Object");
        OBJECT = new ClassType(objectSymbol);
        // creating equals method signature
        Signature equalsSignature = new Signature();
        equalsSignature.add(OBJECT);
        // creating equals method definition
        Label equalsLabel = new Label("equals");
        MethodDefinition equalsMethodDefinition = new MethodDefinition(BOOLEAN, Location.BUILTIN, equalsSignature, 0);
        equalsMethodDefinition.setLabel(equalsLabel);
        // creating Object class
        ClassDefinition objClassDefinition = new ClassDefinition(OBJECT, Location.BUILTIN, null);
        objClassDefinition.setNumberOfMethods(1);
        Symbol equalsSymbol = compiler.createSymbol("equals");
        objClassDefinition.labelMap.put(equalsSymbol, new Label("code.Object.equals"));
        OBJECT.definition = objClassDefinition;
        try {
            objClassDefinition.getMembers().declare(equalsSymbol, equalsMethodDefinition);
        } catch (DoubleDefException e) {
            // Nothing to do
        }
        envTypes.put(objectSymbol, objClassDefinition);
    }

    private final Map<Symbol, TypeDefinition> envTypes;

    public Map<Symbol, TypeDefinition> getEnvTypes() {
        return envTypes;
    }
    public TypeDefinition defOfType(Symbol s) {
        return envTypes.get(s);
    }

    public boolean containsSymbol(Symbol name){
        return envTypes.containsKey(name);
    }

    public void declareClass(Symbol classSymbol, ClassDefinition classDefinition){
        envTypes.put(classSymbol, classDefinition);
    }

    public final VoidType    VOID;
    public final IntType     INT;
    public final FloatType   FLOAT;
    public final StringType  STRING;
    public final BooleanType BOOLEAN;
    public final ClassType OBJECT;
}
