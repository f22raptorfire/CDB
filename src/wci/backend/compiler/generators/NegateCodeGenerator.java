package wci.backend.compiler.generators;

import java.util.ArrayList;

import wci.backend.compiler.CodeGenerator;
import wci.intermediate.ICodeNode;
import wci.intermediate.SymTab;
import wci.intermediate.SymTabEntry;
import wci.intermediate.icodeimpl.ICodeKeyImpl;
import wci.intermediate.symtabimpl.Predefined;
import wci.intermediate.symtabimpl.SymTabKeyImpl;

public class NegateCodeGenerator extends StatementCodeGenerator {

	public NegateCodeGenerator(CodeGenerator parent) {
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
    	StatementCodeGenerator cg = new StatementCodeGenerator(this);
    	String result = "";
    	ICodeNode child = node.getChildren().get(0);
    	result += cg.generate(child);
    	if (child.getTypeSpec() == Predefined.integerType)
    		result += "\n\t;NegateCodeGenerator\n\tineg\n\n";
    	else
    	if (child.getTypeSpec() == Predefined.realType)
    		result += "\n\t;NegateCodeGenerator\n\tfneg\n\n";
    	return result;
    }
}
