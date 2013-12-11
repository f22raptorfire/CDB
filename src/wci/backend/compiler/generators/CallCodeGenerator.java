package wci.backend.compiler.generators;

import java.util.ArrayList;

import wci.backend.compiler.CodeGenerator;
import wci.intermediate.ICodeNode;
import wci.intermediate.SymTabEntry;
import wci.intermediate.TypeSpec;
import wci.intermediate.icodeimpl.ICodeKeyImpl;
import wci.intermediate.icodeimpl.ICodeNodeTypeImpl;
import wci.intermediate.symtabimpl.Predefined;

public class CallCodeGenerator extends StatementCodeGenerator {

	public CallCodeGenerator(CodeGenerator parent) {
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
    	/*
    	getstatic test/_references [Lwci/runtime/Referencer;
    	ldc 0
    	new wci/runtime/Referencer
    	dup
    	
    	getstatic test/i Ljava/lang/String;
    	
    	invokenonvirtual wci/runtime/Referencer/<init>(Ljava/lang/String;)V
    	aastore
    	getstatic test/_references [Lwci/runtime/Referencer;
    	ldc 0
    	aaload
    	*/
    	String result = "";
    	int referenceCount = 0;
    	if (params != null) {
	    	for (int i = 0; i < params.size(); i++) {
	    		ICodeNode paramNode = params.get(i);
	    		switch ((ICodeNodeTypeImpl) paramNode.getType()) {
	    			case REFERENCE:
	    				result += "\tgetstatic " + programId.getName() + "/_references [Lwci/runtime/Referencer;\n";
	    				result += "\tldc " + referenceCount + "\n\tnew wci/runtime/Referencer\n\tdup\n";
	    				result += cg.generate(paramNode.getChildren().get(0));
	    				prefix += "Lwci/runtime/Referencer;";
	    				result += "\tinvokenonvirtual wci/runtime/Referencer/<init>(" + paramNode.getChildren().get(0).getTypeSpec().getTypeId() + ")V\n";
	    				result += "\taastore\n";
	    				result += "\tgetstatic " + programId.getName() + "/_references [Lwci/runtime/Referencer;\n";
	    				result += "\tldc " + referenceCount++ + "\n";
	    				result += "\taaload\n";
	    				break;
	    			default:
	    	    		result += cg.generate(paramNode);
	    	    		prefix += paramNode.getTypeSpec().getTypeId();
	    				break;
	    		}
	    	}
    	}
    	result = result + "\tinvokestatic " + prefix + ")V\n";
    	
    	/*
			;reference unwrap
			getstatic test/_references [Lwci/runtime/Referencer;
			ldc 0
			aaload
			invokestatic wci.runtime/Referencer/getStringValue()Ljava/lang/String;
			putstatic test/i Ljava/lang/String;
    	 */
    	
    	if (params != null) {
    		int start = params.size();
	    	for (int i = start - 1; i >= 0; i--) {
	    		ICodeNode paramNode = params.get(i);
	    		if ((ICodeNodeTypeImpl) paramNode.getType() == ICodeNodeTypeImpl.REFERENCE) {
	    			result += "\n\t;reference unwrap\n";
	    	    	result += "\tgetstatic " + programId.getName() + "/_references [Lwci/runtime/Referencer;\n";
	    	    	result += "\tldc " + --referenceCount + "\n";
	    	    	result += "\taaload\n";
	    			ICodeNode child = paramNode.getChildren().get(0);
	    			TypeSpec type = child.getTypeSpec();
	    			if (type == Predefined.integerType)
	    				result += "\tinvokevirtual wci.runtime/Referencer/getIntegerValue()I\n";
	    			else
	    			if (type == Predefined.stringType)
	    				result += "\tinvokevirtual wci.runtime/Referencer/getStringValue()Ljava/lang/String;\n";
	    			result += "\tputstatic " + programId.getName() + "/" + child.getAttribute(ICodeKeyImpl.ID) + " " + type.getTypeId() + "\n";
	    		}
	    	}
    	}
    	return result;
    }
}
