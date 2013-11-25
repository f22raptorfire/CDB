package wci.backend.compiler.generators;

import java.util.ArrayList;

import wci.backend.compiler.CodeGenerator;
import wci.intermediate.ICodeNode;
import wci.intermediate.icodeimpl.ICodeKeyImpl;

public class CompoundCodeGenerator extends StatementCodeGenerator {

	public CompoundCodeGenerator(CodeGenerator parent) {
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
    	ArrayList<ICodeNode> children = node.getChildren();
    	StatementCodeGenerator cg = new StatementCodeGenerator(this);
    	String result = "";
    	for (ICodeNode child : children) {
    		result += cg.generate(child);
    	}
    	return result;
    }
}
