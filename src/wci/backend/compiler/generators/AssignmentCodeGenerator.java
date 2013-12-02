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
    	StatementCodeGenerator cg = new StatementCodeGenerator(this);
    	
    	SymTabEntry programId = symTabStack.getProgramId();
    	String prefix = programId.getName() + "/", type;
    	
    	SymTabEntry entry = symTabStack.lookup((String)children.get(0).getAttribute(ICodeKeyImpl.ID));
    	type = entry.getTypeSpec().getTypeId();
    	
    	String value = "" + cg.generate(children.get(1));
    	
    	String result = value + "\tputstatic " + prefix + entry.getName() + " " + type + "\n";
    	
    	return result;
    }
}
