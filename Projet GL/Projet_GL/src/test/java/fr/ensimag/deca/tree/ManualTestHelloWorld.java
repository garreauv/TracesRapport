/* A manual test for the initial sketch of code generation included in 
 * students skeleton.
 * 
 * It is not intended to still work when code generation has been updated.
 */
package fr.ensimag.deca.tree;

import fr.ensimag.deca.DecacCompiler;

import java.io.File;
/**
 *
 * @author Ensimag
 * @date 05/01/2023
 */
public class ManualTestHelloWorld {
    /* To perform the test: mvn compile then 
    mvn -q exec:java -Dexec.classpathScope="test" -Dexec.mainClass="fr.ensimag.deca.tree.ManualTestHelloWorld */
    public static void main(String args[]) {
        File fichier = new File("src/test/deca/context/valid/provided/hello-world.deca");
        DecacCompiler compiler = new DecacCompiler(null, fichier); // 
        compiler.compile();
        // System.out.println("ok");
    }
}
