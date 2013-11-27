package wci.backend.compiler;

import java.io.*;
import java.util.ArrayList;

import wci.intermediate.*;
import wci.intermediate.symtabimpl.DefinitionImpl;
import wci.intermediate.symtabimpl.SymTabKeyImpl;
import wci.backend.*;
import wci.backend.compiler.generators.StatementCodeGenerator;

/**
 * <p>The code generator for a compiler back end.</p>
 *
 * <p>Copyright (c) 2008 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class CodeGenerator extends Backend
{
    private static final int STACK_LIMIT = 16;
        
    protected static ICode iCode;
    protected static int varCount;
    protected static SymTabStack symTabStack;
    protected static PrintWriter objectFile;

    public CodeGenerator() {}
    
    public CodeGenerator(CodeGenerator parent) {
    	super();
    }
    
    /**
     * Process the intermediate code and the symbol table generated by the
     * parser to generate machine-language instructions.
     * @param iCode the intermediate code.
     * @param symTabStack the symbol table stack.
     * @param objectFile the object file path for the generated code.
     * @throws Exception if an error occurred.
     */
    public void process(ICode iCode, SymTabStack symTabStack,
                        PrintWriter objectFile)
        throws Exception
    {
    	System.out.println("\n===== BACKEND CODE =====\n");
        this.symTabStack = symTabStack;
        this.iCode = iCode;
        this.objectFile = objectFile;
        this.varCount = 0;

    	printHeader(objectFile);

    	SymTabEntry programId = symTabStack.getProgramId();
    	SymTab program = (SymTab) programId.getAttribute(SymTabKeyImpl.ROUTINE_SYMTAB);
    	ArrayList<SymTabEntry> entries = program.sortedEntries();
    	String type;
    	for (SymTabEntry entry : entries) {
    		if (entry.getDefinition() == DefinitionImpl.VARIABLE) {
    			type = entry.getTypeSpec().getTypeId();
    			objectFile.append(".field public static " + entry.getName() + " " + type + "\n");
    		}
    	}
    	objectFile.append("\n");

    	objectFile.append(".method public static main([Ljava/lang/String;)V\n");
    	objectFile.append(".limit stack  " + STACK_LIMIT + "\n");
    	objectFile.append(".limit locals 10\n\n");

    	ICodeNode rootNode = (ICodeNode) iCode.getRoot();
    	StatementCodeGenerator gen = new StatementCodeGenerator(this);
    	objectFile.append(gen.generate(rootNode).toString());
    	
    	objectFile.append(";Print the integer in variable i\n");
    	objectFile.append("\tgetstatic     java/lang/System/out Ljava/io/PrintStream;\n");
    	objectFile.append("\tgetstatic Program/i I\n");
    	objectFile.append("\tinvokevirtual java/io/PrintStream/println(I)V\n");
    	objectFile.append(";Print the integer in variable j\n");
    	objectFile.append("\tgetstatic     java/lang/System/out Ljava/io/PrintStream;\n");
    	objectFile.append("\tgetstatic Program/j I\n");
    	objectFile.append("\tinvokevirtual java/io/PrintStream/println(I)V\n");
    	objectFile.append("\treturn\n");
    	objectFile.append("\n.end method\n");
    	objectFile.close();
    }
    
    private void printHeader(PrintWriter objectFile) throws FileNotFoundException {
    	SymTabEntry programId = symTabStack.getProgramId();
    	objectFile.append(".class public " + programId.getName() + "\n");
    	objectFile.append(".super java/lang/Object\n");
    	objectFile.append("\n");
    }
}
