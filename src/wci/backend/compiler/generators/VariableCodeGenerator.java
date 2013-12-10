package wci.backend.compiler.generators;

import wci.backend.compiler.CodeGenerator;
import wci.intermediate.ICodeNode;
import wci.intermediate.SymTab;
import wci.intermediate.SymTabEntry;
import wci.intermediate.icodeimpl.ICodeKeyImpl;
import wci.intermediate.symtabimpl.Predefined;
import wci.intermediate.symtabimpl.SymTabKeyImpl;

public class VariableCodeGenerator extends StatementCodeGenerator {

	public VariableCodeGenerator(CodeGenerator parent) {
		super(parent);
	}

	/**
     * Generate a statement.
     * To be overridden by the specialized statement executor subclasses.
     * @param node the root node of the statement.
     * @return null.
     */
    public Object generate(ICodeNode node)
    {
    	SymTabEntry programId = symTabStack.getProgramId();
    	SymTab table = symTabStack.getLocalSymTab();
    	SymTabEntry entry = table.lookup((String)node.getAttribute(ICodeKeyImpl.ID));
    	String result = "\t";
    	if (entry != null) {
    		if (entry.getTypeSpec() == Predefined.integerType)
    			result += "iload ";
    		else
    			result += "aload ";
    		result += entry.getIndex() + "\n";
    	} else {
    		result += "getstatic " + programId.getName() + "/" + node.getAttribute(ICodeKeyImpl.ID) 
    			+ " " + node.getTypeSpec().getTypeId() + "\n";
    	}
    	return result;
    }
}
