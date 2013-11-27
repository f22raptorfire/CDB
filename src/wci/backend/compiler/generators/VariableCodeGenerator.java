package wci.backend.compiler.generators;

import java.util.ArrayList;

import wci.backend.compiler.CodeGenerator;
import wci.intermediate.ICodeNode;
import wci.intermediate.SymTab;
import wci.intermediate.SymTabEntry;
import wci.intermediate.icodeimpl.ICodeKeyImpl;
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
    	String result = "\t";
    	result += "getstatic " + programId.getName() + "/" + node.getAttribute(ICodeKeyImpl.ID) 
    			+ " " + node.getTypeSpec().getTypeId() + "\n";
    	return result;
    }
}
