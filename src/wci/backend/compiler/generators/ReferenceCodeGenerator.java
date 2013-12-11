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

public class ReferenceCodeGenerator extends StatementCodeGenerator {

	public ReferenceCodeGenerator(CodeGenerator parent) {
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
    	/*
	    new wci/runtime/Referencer
		dup
		dup
		getstatic test/i I
		invokenonvirtual wci/runtime/Referencer/<init>(I)V
		invokestatic test/p(Lwci/runtime/Referencer;)V
		invokestatic wci.runtime/Referencer/getIntegerValue()I
		putstatic test/i I
    	 */
    	StatementCodeGenerator cg = new StatementCodeGenerator(this);
		ArrayList<ICodeNode> children = node.getChildren();
    	String result = "\tnew wci/runtime/Referencer\n\tdup\n\tdup\n";
    	ICodeNode child = children.get(0);
    	result += cg.generate(child);
    	
    	String typeId;
    	SymTabEntry entry = symTabStack.lookup((String)child.getAttribute(ICodeKeyImpl.ID));
    	if (entry.getDefinition() == DefinitionImpl.REFERENCE)
    		typeId = "Lwci/runtime/Referencer;";
    	else
    		typeId = child.getTypeSpec().getTypeId();
    	
    	result += "\tinvokenonvirtual wci/runtime/Referencer/<init>(" + typeId + ")V\n";
    	
    	return result;
    }
}
