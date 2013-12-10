package wci.backend.compiler.generators;

import java.util.ArrayList;

import wci.backend.compiler.CodeGenerator;
import wci.intermediate.ICodeNode;
import wci.intermediate.SymTabEntry;
import wci.intermediate.icodeimpl.ICodeKeyImpl;

public class CallGenerator extends StatementCodeGenerator {

	public CallGenerator(CodeGenerator parent) {
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
    	
    	SymTabEntry programId = symTabStack.getProgramId();
    	String prefix = programId.getName() + "/" + children.get(0).getAttribute(ICodeKeyImpl.ID) + "(";
   
    	ICodeNode parameterNode = children.get(1);
    	ArrayList<ICodeNode> params = parameterNode.getChildren();

    	String result = "";
    	if (params != null) {
	    	for (ICodeNode paramNode : params) {
	    		prefix += paramNode.getTypeSpec().getTypeId();
	    		result += cg.generate(paramNode);
	    	}
    	}
    	
    	return result + "\tinvokestatic " + prefix + ")V\n";
    }
}
