package wci.backend.compiler.generators;

import java.util.ArrayList;

import wci.backend.compiler.CodeGenerator;
import wci.intermediate.ICodeNode;
import wci.intermediate.SymTabEntry;
import wci.intermediate.icodeimpl.ICodeKeyImpl;
import wci.intermediate.symtabimpl.SymTabKeyImpl;

public class AssignmentCodeGenerator extends StatementCodeGenerator {

	public AssignmentCodeGenerator(CodeGenerator parent) {
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
    	
    	SymTabEntry entry = symTabStack.lookup((String)children.get(0).getAttribute(ICodeKeyImpl.ID));
    	
    	if (entry.getAttribute(SymTabKeyImpl.LOCAL_NUM) == null) {
    		//TODO this increments differently depending on how big the variable is
    		entry.setAttribute(SymTabKeyImpl.LOCAL_NUM, varCount);
    		varCount++;
    	}
    	
    	String storage = "" + entry.getAttribute(SymTabKeyImpl.LOCAL_NUM);
    	String value = "" + children.get(1).getAttribute(ICodeKeyImpl.VALUE);
    	
    	String result = ";" + (String)children.get(0).getAttribute(ICodeKeyImpl.ID)
    			+ " = " + children.get(1).getAttribute(ICodeKeyImpl.VALUE) + "\n";
    	
    	result += "\tldc " + value + "\n";
    	
    	//TODO switch (variable type) {
    	result += "\tistore " + storage + "\n";
    	
    	return result;
    }
}
