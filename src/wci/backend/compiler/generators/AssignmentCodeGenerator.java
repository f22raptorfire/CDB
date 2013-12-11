package wci.backend.compiler.generators;

import java.util.ArrayList;

import wci.backend.compiler.CodeGenerator;
import wci.intermediate.ICodeNode;
import wci.intermediate.SymTab;
import wci.intermediate.SymTabEntry;
import wci.intermediate.icodeimpl.ICodeKeyImpl;
import wci.intermediate.symtabimpl.DefinitionImpl;
import wci.intermediate.symtabimpl.Predefined;
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

    	SymTabEntry entry = symTabStack.lookup((String)children.get(0).getAttribute(ICodeKeyImpl.ID));
    	String result;
    	
    	if (entry.getSymTab().getNestingLevel() == 1) {
        	SymTabEntry programId = symTabStack.getProgramId();
	    	String prefix = programId.getName() + "/", type;
	    	entry = symTabStack.lookup((String)children.get(0).getAttribute(ICodeKeyImpl.ID));
	    	
	    	type = entry.getTypeSpec().getTypeId();
	    	String value = "" + cg.generate(children.get(1));
	    	result = value + "\tputstatic " + prefix + entry.getName() + " " + type + "\n";
    	} else {
    		result = "" + cg.generate(children.get(1));
    		if (entry.getTypeSpec() == Predefined.integerType)
    			if (entry.getDefinition() == DefinitionImpl.REFERENCE)
    				result = "\taload " + entry.getIndex() + "\n" + result + "\tinvokevirtual wci.runtime/Referencer/setValue(I)V\n";
    			else
    				result += "\tistore " + entry.getIndex() + "\n";
    		else
    		if (entry.getTypeSpec() == Predefined.stringType)
    			if (entry.getDefinition() == DefinitionImpl.REFERENCE)
    				result = "\taload " + entry.getIndex() + "\n" + result + "\tinvokevirtual wci.runtime/Referencer/setValue(Ljava/lang/String;)V\n";
    			else
    				result += "\tastore " + entry.getIndex() + "\n";
    		else
    			result += "\tastore " + entry.getIndex() + "\n";
    	}
    	return result;
    }
}
