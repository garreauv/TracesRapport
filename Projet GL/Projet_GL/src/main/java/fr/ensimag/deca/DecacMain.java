package fr.ensimag.deca;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import java.util.concurrent.*;
/**
 * Main class for the command-line Deca compiler.
 *
 * @author gl19
 * @date 01/01/2023
 */
public class DecacMain {
    private static Logger LOG = Logger.getLogger(DecacMain.class);
    
    public static void main(String[] args)  throws InterruptedException, ExecutionException  {
        // example log4j message.
        LOG.info("Decac compiler started");
        boolean error = false;
        final CompilerOptions options = new CompilerOptions();
        try {
            options.parseArgs(args);
        } catch (CLIException e) {
            System.err.println("Error during option parsing:\n"
                    + e.getMessage());
            options.displayUsage();
            System.exit(1);
        }
        if (options.getPrintBanner()) {
            System.out.println("Equipe G19" );
            System.exit(error ? 1 : 0);
        }
        if (options.getSourceFiles().isEmpty()) {
            System.out.println("decac [[-p | -v] [-n] [-r X] [-d]* [-P] [-w] <fichier deca>...] | [-b] \n\n"
                      +  "-b (banner) : affiche une bannière indiquant le nom de l'équipe\n\n"
                      +  "-p (parse) : arrête decac après l'étape de construction de l'arbre, et affiche la décompilation de ce dernier (i.e. s'il n'y a qu'un fichier source à compiler, la sortie doit être un programme deca syntaxiquement correct)\n\n"                    
                      +  "-v (verification) : arrête decac après l'étape de vérifications (ne produit aucune sortie en l'absence d'erreur)\n\n"                        
                      +  "-n (no check) : supprime les tests à l'exécution spécifiés dans les points 11.1 et 11.3 de la sémantique de Deca\n\n"
                      +  "-r X (registers) : limite les registres banalisés disponibles à R0 ... R{X-1}, avec 4 <= X <= 16\n\n"
                      +  "-d (debug) : active les traces de debug. Répéter l'option plusieurs fois pour avoir plus de traces\n\n"
                      +  "-P (parallel) : s'il y a plusieurs fichiers sources, lance la compilation des fichiers en parallèle (pour accélérer la compilation)\n\n" );
        }


        if (options.getParallel()) {

            List<File> files = options.getSourceFiles();

            ExecutorService compilerThreadsService = Executors.newFixedThreadPool(files.size());
		
            try {

                List<Callable<Boolean>> listeThreadsAexecuter = new ArrayList<Callable<Boolean>>();

                for(File source : files){
                    DecacCompiler compiler = new DecacCompiler(options, source);
                    Callable<Boolean> thread = () -> {
                        return (compiler.compile());
                    };
                    listeThreadsAexecuter.add(thread);
                }                
                
                List<Future<Boolean>> output = compilerThreadsService.invokeAll(listeThreadsAexecuter);
                for (Future<Boolean> future : output) {
                    if(future.get()){
                        error = true;
                    }
                }
                
            } catch (Exception e) {
                LOG.fatal("Exception raised while multi-threading" +  e.getMessage());
            } 
                    
        } else {
            for (File source : options.getSourceFiles()) {
                DecacCompiler compiler = new DecacCompiler(options, source);
                if (compiler.compile()) {
                    error = true;
                }
            }
        }
        System.exit(error ? 1 : 0);
    }
}
