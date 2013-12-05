package wci.backend.compiler.generators;

import java.util.ArrayList;

import wci.backend.compiler.CodeGenerator;
import wci.intermediate.ICodeNode;
import wci.intermediate.SymTabEntry;
import wci.intermediate.icodeimpl.ICodeKeyImpl;

public class DatabaseGenerator extends StatementCodeGenerator {

	public DatabaseGenerator(CodeGenerator parent) {
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
    	String result = "\tnew wci/runtime/CDBC\n\tdup\n";
    	result += (String) cg.generate(node.getChildren().get(0));
    	result += "\tinvokenonvirtual wci/runtime/CDBC/<init>(Ljava/lang/String;)V\n";
    	result += "\tputstatic test/_database Lwci/runtime/CDBC;\n";
    	return result;
    }
}
