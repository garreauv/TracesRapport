package fr.ensimag.deca;

import fr.ensimag.deca.codegen.ExecutionError;
import fr.ensimag.deca.codegen.StackError;
import fr.ensimag.deca.context.ClassDefinition;
import fr.ensimag.deca.context.ContextualError;
import fr.ensimag.deca.context.EnvironmentType;
import fr.ensimag.deca.syntax.DecaLexer;
import fr.ensimag.deca.syntax.DecaParser;
import fr.ensimag.deca.tools.DecacInternalError;
import fr.ensimag.deca.tools.SymbolTable;
import fr.ensimag.deca.tools.SymbolTable.Symbol;
import fr.ensimag.deca.tree.AbstractProgram;
import fr.ensimag.deca.tree.Location;
import fr.ensimag.deca.tree.LocationException;
import fr.ensimag.ima.pseudocode.AbstractLine;
import fr.ensimag.ima.pseudocode.IMAProgram;
import fr.ensimag.ima.pseudocode.Instruction;
import fr.ensimag.ima.pseudocode.Label;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.log4j.Logger;

/**
 * Decac compiler instance.
 *
 * This class is to be instantiated once per source file to be compiled. It
 * contains the meta-data used for compiling (source file name, compilation
 * options) and the necessary utilities for compilation (symbol tables, abstract
 * representation of target file, ...).
 *
 * It contains several objects specialized for different tasks. Delegate methods
 * are used to simplify the code of the caller (e.g. call
 * compiler.addInstruction() instead of compiler.getProgram().addInstruction()).
 *
 * @author gl19
 * @date 01/01/2023
 */
public class DecacCompiler {
    private static final Logger LOG = Logger.getLogger(DecacCompiler.class);
    
    /* Stores the number of largest GP Register currently used */
    private int nCurrRegister = 2;

    /* Stores the number of the maximum allowed registers, 16 by default -> the largest register is R[15] by default */
    private int nMaxRegister;
    
    public int getnMaxRegister() {
        return nMaxRegister;
    }

    //Stack pointer
    private int stackPointer = 1;

    //Store register to use
    private int storeRegister = 2;

    //Label number to use
    private int labelIndex = 1;

    //Else label
    private int elseLabelIndex = 1;


    private boolean hasReturn = false;

    public boolean getHasReturn(){
        return this.hasReturn;
    }

    public void setHasReturn(boolean hasReturn){
        this.hasReturn = hasReturn;
    }

    // Mode = 1 : method call, needs to mark used registers
    // Mode = 0 : proceed normally
    public int mode = 0;

    public int registerCount = 0;

    private int poppedToStack = 0;

    /* Methods to handle the stack */
    public int getPoppedToStack() {
        return poppedToStack;
    }

    public void incrementPoppedToStack() {
        this.poppedToStack++;
    }

    public void decrementPoppedToStack() {
        this.poppedToStack--;
    }

    public void setPoppedToStack(int poppedToStack) {
        this.poppedToStack = poppedToStack;
    }

    public void increRegisterCount(int register){
        if(register>this.registerCount){
            this.registerCount=register;
        }
    }

    private int addsp=0;
    private int tsto=0;
    private int maxPush=0;
    private int push=0;

    public void resetMaxPush(){
        this.maxPush=0;
    }

    public void incrementPush(){
        this.push++;
        if(push>maxPush){
            maxPush=push;
        }
    }

    public void decrementPush(){
        this.push--;
    }

    public int getMaxPush(){
        return this.maxPush;
    }

    public void setADDSP(int i){
        this.addsp=i;
    }

    public int getADDSP(){
        return this.addsp;
    }

    public void incrementADDSP(){
        this.addsp++;
    }

    public void incrementTSTO(){
        this.tsto++;
    }

    public int getTSTO(){
        return this.tsto;
    }

    public void setTSTO(int i){
        this.addsp=i;
    }
    

    private final Set<ExecutionError> handledErrors = new HashSet<ExecutionError>();

    public void addError(ExecutionError error){
        handledErrors.add(error);
    }

    public Set<ExecutionError> getHandledError(){
        return handledErrors;
    }
    

    public int getElseLabelIndex() {
        return elseLabelIndex;
    }

    public void setElseLabelIndex(int elseLabelIndex) {
        this.elseLabelIndex = elseLabelIndex;
    }

    public void incrementElseLabelIndex(){
        elseLabelIndex++;
    }

    public int getLabelIndex() {
        return labelIndex;
    }

    public void setLabelIndex(int labelIndex) {
        this.labelIndex = labelIndex;
    }

    public void incrementLabelIndex(){
        labelIndex ++;
    }

    public int getStoreRegister() {
        return storeRegister;
    }

    public void resetNCurrRegister(){
        nCurrRegister=2;
    }
    

    public void setStoreRegister(int storeRegister) {
        this.storeRegister = storeRegister;
    }

    public int getStackPointer() {
        return stackPointer;
    }

    public void incrementStackPointer() {
        this.stackPointer++;
    }

    public void decrementNCurrRegister(){
        nCurrRegister --;
    }

    /**
     * Portable newline character.
     */
    private static final String nl = System.getProperty("line.separator", "\n");

    public DecacCompiler(CompilerOptions compilerOptions, File source) {
        super();
        this.compilerOptions = compilerOptions;
        this.source = source;
        try {
            this.nMaxRegister = compilerOptions.getMaxRegisters();
        }catch(Exception e){
            this.nMaxRegister = 16;
        }

    }

    /**
     * Source file associated with this compiler instance.
     */
    public File getSource() {
        return source;
    }

    /**
     * Compilation options (e.g. when to stop compilation, number of registers
     * to use, ...).
     */
    public CompilerOptions getCompilerOptions() {
        return compilerOptions;
    }

    /**
     * @see
     * fr.ensimag.ima.pseudocode.IMAProgram#add(fr.ensimag.ima.pseudocode.AbstractLine)
     */
    public void add(AbstractLine line) {
        program.add(line);
    }

    /**
     * @see
     * fr.ensimag.ima.pseudocode.IMAProgram#append(fr.ensimag.ima.pseudocode.AbstractLine)
     */
    public void append(IMAProgram p) {
        program.append(p);
    }

    /**
     * @see fr.ensimag.ima.pseudocode.IMAProgram#addComment(java.lang.String)
     */
    public void addComment(String comment) {
        currentProgramme.addComment(comment);
    }

    /**
     * @see
     * fr.ensimag.ima.pseudocode.IMAProgram#addLabel(fr.ensimag.ima.pseudocode.Label)
     */
    public void addLabel(Label label) {
        currentProgramme.addLabel(label);
    }


    public void resetCurrentProgramme(){
        this.currentProgramme = this.program;
    }

    public void setCurrentProgramme(IMAProgram sousProgram){
        this.currentProgramme = sousProgram;
    }
    /**
     * @see
     * fr.ensimag.ima.pseudocode.IMAProgram#addInstruction(fr.ensimag.ima.pseudocode.Instruction)
     */
    public void addInstruction(Instruction instruction) {
        instruction.pushToStack(this);
        currentProgramme.addInstruction(instruction);
        instruction.popFromStack(this);

    }

    /**
     * @see
     * fr.ensimag.ima.pseudocode.IMAProgram#addInstruction(fr.ensimag.ima.pseudocode.Instruction,
     * java.lang.String)
     */
    public void addInstruction(Instruction instruction, String comment) {
        currentProgramme.addInstruction(instruction, comment);
    }

    /**
     * @see
     * fr.ensimag.ima.pseudocode.IMAProgram#addInstructionToTop(fr.ensimag.ima.pseudocode.Instruction)
     */
    public void addInstructionToTop(Instruction instruction) {
        currentProgramme.addInstructionToTop(instruction);
    }

    /**
     * @see
     * fr.ensimag.ima.pseudocode.IMAProgram#addInstructionToTop(fr.ensimag.ima.pseudocode.Instruction,
     * java.lang.String)
     */
    public void addInstructionToTop(Instruction instruction, String comment) {
        currentProgramme.addInstructionToTop(instruction, comment);
    }
    
    /**
     * @see 
     * fr.ensimag.ima.pseudocode.IMAProgram#display()
     */
    public String displayIMAProgram() {
        return program.display();
    }
    
    private final CompilerOptions compilerOptions;
    private final File source;
    /**
     * The main program. Every instruction generated will eventually end up here.
     */
    private final IMAProgram program = new IMAProgram();
 

    /** The global environment for types (and the symbolTable) */
    public final SymbolTable symbolTable = new SymbolTable();
    public final EnvironmentType environmentType = new EnvironmentType(this);

    public Symbol createSymbol(String name) {
        return symbolTable.create(name);
    }

    /**
     * Run the compiler (parse source file, generate code)
     *
     * @return true on error
     */
    public boolean compile() {
        String sourceFile = source.getAbsolutePath();
        /* On prend le nom du fichier source sans l'extension .deca, puis on ajoute l'extension .ass */
        String destFile = sourceFile.substring(0, sourceFile.lastIndexOf('.')) + ".ass";
        PrintStream err = System.err;
        PrintStream out = System.out;
        LOG.debug("Compiling file " + sourceFile + " to assembly file " + destFile);
        try {
            return doCompile(sourceFile, destFile, out, err);
        } catch (LocationException e) {
            e.display(err);
            return true;
        } catch (DecacFatalError e) {
            err.println(e.getMessage());
            return true;
        } catch (StackOverflowError e) {
            LOG.debug("stack overflow", e);
            err.println("Stack overflow while compiling file " + sourceFile + ".");
            return true;
        } catch (Exception e) {
            LOG.fatal("Exception raised while compiling file " + sourceFile
                    + ":", e);
            err.println("Internal compiler error while compiling file " + sourceFile + ", sorry.");
            return true;
        } catch (AssertionError e) {
            LOG.fatal("Assertion failed while compiling file " + sourceFile
                    + ":", e);
            err.println("Internal compiler error while compiling file " + sourceFile + ", sorry.");
            return true;
        }
    }

    /**
     * Internal function that does the job of compiling (i.e. calling lexer,
     * verification and code generation).
     *
     * @param sourceName name of the source (deca) file
     * @param destName name of the destination (assembly) file
     * @param out stream to use for standard output (output of decac -p)
     * @param err streadecac m to use to display compilation errors
     *
     * @return true on error
     */
    private boolean doCompile(String sourceName, String destName,
            PrintStream out, PrintStream err)
            throws DecacFatalError, LocationException {
        AbstractProgram prog = doLexingAndParsing(sourceName, err);

        if (prog == null) {
            LOG.info("Parsing failed");
            return true;
        }
        assert(prog.checkAllLocations());
        
        if(this.getCompilerOptions().getPrintParse()){
            System.out.println(prog.decompile() );
            return false;
        }

        prog.verifyProgram(this);
        assert(prog.checkAllDecorations());

        if(this.getCompilerOptions().getVerification()){
            return false;
        }

        prog.codeGenProgram(this);
        LOG.debug("Generated assembly code:" + nl + program.display());
        LOG.info("Output file assembly file is: " + destName);

        FileOutputStream fstream = null;
        try {
            fstream = new FileOutputStream(destName);
        } catch (FileNotFoundException e) {
            throw new DecacFatalError("Failed to open output file: " + e.getLocalizedMessage());
        }

        LOG.info("Writing assembler file ...");

        program.display(new PrintStream(fstream));
        LOG.info("Compilation of " + sourceName + " successful.");
        return false;
    }

    /**
     * Build and call the lexer and parser to build the primitive abstract
     * syntax tree.
     *
     * @param sourceName Name of the file to parse
     * @param err Stream to send error messages to
     * @return the abstract syntax tree
     * @throws DecacFatalError When an error prevented opening the source file
     * @throws DecacInternalError When an inconsistency was detected in the
     * compiler.
     * @throws LocationException When a compilation error (incorrect program)
     * occurs.
     */
    protected AbstractProgram doLexingAndParsing(String sourceName, PrintStream err)
            throws DecacFatalError, DecacInternalError {
        DecaLexer lex;
        try {
            lex = new DecaLexer(CharStreams.fromFileName(sourceName));
        } catch (IOException ex) {
            throw new DecacFatalError("Failed to open input file: " + ex.getLocalizedMessage());
        }
        lex.setDecacCompiler(this);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        DecaParser parser = new DecaParser(tokens);
        parser.setDecacCompiler(this);
        return parser.parseProgramAndManageErrors(err);
    }


    public void setNCurrRegister(int n){
        this.nCurrRegister = n;
    }

    /* When we want to store the result in a register, we increase the number of registers used  */
    public void addNCurrRegister(){
        this.nCurrRegister ++;
        this.increRegisterCount(nCurrRegister);
    }

    /* Tells the number of registers currently used to calculate an expression. Will be useful to know if we need to use the stack */
    public int getNCurrRegister(){
        return this.nCurrRegister;
    }

    /* Used with the decac -r n where n is the maximum number of registers available */
    public void setNmaxRegister(int n){
        this.nMaxRegister = n;
    }

    public ClassDefinition getClassDef(Symbol name, Location location){
        try {
            return environmentType.defOfType(name).getType().asClassType(name + " is not a class.", location).getDefinition();
        }
        catch (ContextualError c){
            throw new IllegalArgumentException(name + " is not a class.");
        }
    }
    
    IMAProgram currentProgramme=this.program;

}
