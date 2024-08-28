package fr.ensimag.deca;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * User-specified options influencing the compilation.
 *
 * @author gl19
 * @date 01/01/2023
 */
public class CompilerOptions {
    public static final int QUIET = 0;
    public static final int WARN  = 1;
    public static final int INFO  = 2;
    public static final int DEBUG = 3;
    public static final int TRACE = 4;
    public int getDebug() {
        return debug;
    }

    public boolean getParallel() {
        return parallel;
    }

    public boolean getPrintParse() {
        return printParse;
    }

    public boolean getPrintBanner() {
        return printBanner;
    }

    public boolean getVerification() {
        return verification;
    }

    public boolean getErrorHandling(){
        return errorHandling;
    }

    public List<File> getSourceFiles() {
        return Collections.unmodifiableList(sourceFiles);
    }

    private int debug = 0;
    private boolean parallel = false;
    private boolean verification = false;
    private boolean printBanner = false;
    private boolean printParse = false;
    private boolean errorHandling = true;
    private int maxRegisters = 16;


    public int getMaxRegisters() {
        return maxRegisters;
    }

    private List<File> sourceFiles = new ArrayList<File>();

    
    public void parseArgs(String[] args) throws CLIException {
        // A FAIRE : parcourir args pour positionner les options correctement.
        /* OPTIONS DETECTION */
        for(int i=0;i<args.length;i++){
            switch(args[i]){
                case "-b":
                    if(args.length == 1){
                            this.printBanner = true;
                        }
                        else{
                            throw new UnsupportedOperationException("Option -b doit être utlisée seule"); //EXAMPLE, TODO: BETTER ERROR FORMAT
                        }
                    break;

                case "-p":
                    if(!getVerification()){
                        this.printParse = true;
                    }else{
                        throw new UnsupportedOperationException("Option -p ne peux pas être utlisé avec l'option -v");
                    }
                    break;
                    
                case "-v":
                    if(!getPrintParse()){
                        this.verification = true;
                    }else{
                        throw new UnsupportedOperationException("Option -v ne peux pas être utlisé avec l'option -p");
                    }
                    break;
                
                case "-n":
                    if(true){
                        errorHandling = false;
                    }
                    break;

                case "-P":
                    this.parallel = true;
                    break;
                case "-d":
                    this.debug++;
                    break;
                    
                case "-r":
                    try {
                        i++;
                        maxRegisters = Integer.parseInt(args[i]);
                        System.out.println("Warning: This option is not fully implemented and may result in false results or unexpected errors. Use with caution.");
                        if (maxRegisters > 16 || maxRegisters < 4){
                            throw new UnsupportedOperationException("Option -r : Nombre de registres invalide");
                        }
                    } catch (NumberFormatException e) {
                        throw new UnsupportedOperationException("Option -r : Nombre de registres invalide");
                    }
                    break;
                
                default:
                // By default: files
                File f = new File(args[i]);
                this.sourceFiles.add(f); 
            };
        }
        Logger logger = Logger.getRootLogger();
        // map command-line debug option to log4j's level.
        switch (getDebug()) {
        case QUIET: break; // keep default
        case WARN:
            logger.setLevel(Level.WARN); break;
        case INFO:
            logger.setLevel(Level.INFO); break;
        case DEBUG:
            logger.setLevel(Level.DEBUG); break;
        case TRACE:
            logger.setLevel(Level.TRACE); break;
        default:
            logger.setLevel(Level.ALL); break;
        }
        logger.info("Application-wide trace level set to " + logger.getLevel());

        boolean assertsEnabled = false;
        assert assertsEnabled = true; // Intentional side effect!!!
        if (assertsEnabled) {
            logger.info("Java assertions enabled");
        } else {
            logger.info("Java assertions disabled");
        }          

    }


    protected void displayUsage() {
        throw new UnsupportedOperationException("not yet implemented");
    }
}
