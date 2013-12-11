package wci.backend.compiler.generators;

import java.util.ArrayList;

import wci.backend.compiler.CodeGenerator;
import wci.intermediate.ICodeNode;
import wci.intermediate.SymTabEntry;
import wci.intermediate.icodeimpl.ICodeKeyImpl;
import wci.intermediate.symtabimpl.DefinitionImpl;
import wci.intermediate.symtabimpl.Predefined;

public class PrintCodeGenerator extends StatementCodeGenerator {

	public PrintCodeGenerator(CodeGenerator parent) {
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
    	String result = "\tgetstatic java/lang/System/out Ljava/io/PrintStream;\n";
    	ICodeNode child = node.getChildren().get(0);
    	SymTabEntry entry = symTabStack.lookup((String) child.getAttribute(ICodeKeyImpl.ID));
		result += (String) cg.generate(child);
    	if (entry.getDefinition() == DefinitionImpl.REFERENCE) {
    		if (child.getTypeSpec() == Predefined.integerType)
    			result += "\tinvokevirtual wci.runtime/Referencer/getIntegerValue()I\n";
    		else
    		if (child.getTypeSpec() == Predefined.stringType)
    			result += "\tinvokevirtual wci.runtime/Referencer/getStringValue()Ljava/lang/String;\n";
    	}
    	result += "\tinvokevirtual java/io/PrintStream/print(" + node.getChildren().get(0).getTypeSpec().getTypeId() + ")V\n";
    	return result;
    }
}
