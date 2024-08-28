package fr.ensimag.deca.syntax;

import java.io.FileWriter;
import fr.ensimag.deca.CompilerOptions;
import fr.ensimag.deca.DecacCompiler;
import fr.ensimag.deca.tree.AbstractProgram;
import java.io.File;
import java.io.IOException;
import org.antlr.v4.runtime.CommonTokenStream;

public class DecompileTest {
    public static void main(String[] args) throws IOException {
        // Uncomment the following line to activate debug traces
        // unconditionally for test_synt
        // Logger.getRootLogger().setLevel(Level.DEBUG);
        DecaLexer lex = AbstractDecaLexer.createLexerFromArgs(args);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        DecaParser parser = new DecaParser(tokens);
        File file = null;
        if (lex.getSourceName() != null) {
            file = new File(lex.getSourceName());
        }
        final DecacCompiler decacCompiler = new DecacCompiler(new CompilerOptions(), file);
        parser.setDecacCompiler(decacCompiler);
        AbstractProgram prog = parser.parseProgramAndManageErrors(System.err);

        String progDecomp;
        progDecomp = prog.decompile();
        String name = lex.getSourceName().replace(".deca", "") + "_decompile.deca";
        try {
            File myObj = new File(name);
            myObj.createNewFile();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

        FileWriter myWriter = new FileWriter(name);
        myWriter.write(progDecomp);
        myWriter.close();
        


    }
}
