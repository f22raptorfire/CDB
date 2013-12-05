package wci.backend.compiler.generators;

import java.util.ArrayList;

import wci.backend.compiler.CodeGenerator;
import wci.intermediate.ICodeNode;
import wci.intermediate.SymTabEntry;
import wci.intermediate.icodeimpl.ICodeKeyImpl;

public class PrintlnCodeGenerator extends StatementCodeGenerator {

	public PrintlnCodeGenerator(CodeGenerator parent) {
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
    	StatementCodeGenerator cg = new StatementCodeGenerator(this);
    	String result = "\tgetstatic java/lang/System/out Ljava/io/PrintStream;\n";
    	result += (String) cg.generate(node.getChildren().get(0));
    	result += "\tinvokevirtual java/io/PrintStream/println(" + node.getChildren().get(0).getTypeSpec().getTypeId() + ")V\n";
    	return result;
    }
}