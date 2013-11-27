package wci.backend.compiler.generators;

import java.util.ArrayList;

import wci.backend.compiler.CodeGenerator;
import wci.intermediate.ICodeNode;
import wci.intermediate.SymTab;
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
    	
    	SymTabEntry programId = symTabStack.getProgramId();
    	String prefix = programId.getName() + "/", type;
    	
    	SymTabEntry entry = symTabStack.lookup((String)children.get(0).getAttribute(ICodeKeyImpl.ID));
    	type = entry.getTypeSpec().getTypeId();
    	
    	String value = "" + children.get(1).getAttribute(ICodeKeyImpl.VALUE);
    	
    	String result = ";" + (String)children.get(0).getAttribute(ICodeKeyImpl.ID)
    			+ " = " + children.get(1).getAttribute(ICodeKeyImpl.VALUE) + "\n";
    	
    	result += "\tldc " + value + "\n";
    	
    	result += "\tputstatic " + prefix + entry.getName() + " " + type + "\n";
    	
    	return result;
    }
}
