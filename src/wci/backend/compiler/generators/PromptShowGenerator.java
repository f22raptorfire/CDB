package wci.backend.compiler.generators;

import java.util.ArrayList;

import wci.backend.compiler.CodeGenerator;
import wci.intermediate.ICodeNode;
import wci.intermediate.SymTabEntry;
import wci.intermediate.icodeimpl.ICodeKeyImpl;

public class PromptShowGenerator extends StatementCodeGenerator {

	public PromptShowGenerator(CodeGenerator parent) {
		super(parent);
	}

	/**
     * Execute a statement.
     * To be overridden by the specialized statement executor subclasses.
     * @param node the root node of the statement.
     * @return null.
     */
    public Object generate(ICodeNode node)
    {
    	SymTabEntry programId = symTabStack.getProgramId();
    	StatementCodeGenerator cg = new StatementCodeGenerator(this);
    	String result = "";
    	//result += "\tgetstatic " + programId.getName() + "/_database Lwci/runtime/CDBC;\n";
    	result += (String) cg.generate(node.getChildren().get(0));
    	result += "\tinvokestatic wci.runtime/CDBC/viewCSV(Ljava/lang/String;)V\n";
    	return result;
    }
}