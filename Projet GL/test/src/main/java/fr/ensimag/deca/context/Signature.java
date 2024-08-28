package fr.ensimag.deca.context;

import java.util.ArrayList;
import java.util.List;

/**
 * Signature of a method (i.e. list of arguments)
 *
 * @author gl19
 * @date 01/01/2023
 */
public class Signature {
    List<Type> args = new ArrayList<Type>();

    public void add(Type t) {
        args.add(t);
    }
    
    public Type paramNumber(int n) {
        return args.get(n);
    }
    
    public int size() {
        return args.size();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Signature))
            return false;
        Signature s = (Signature)o;
        //If not same size, not equal
        if (args.size() != s.args.size()) {
            return false;
        }
        // Comparing all types
        for (int i = 0; i < args.size(); i++) {
            if (!args.get(i).sameType(s.args.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Signature [args=" + args + "]";
    }

    

    

}
