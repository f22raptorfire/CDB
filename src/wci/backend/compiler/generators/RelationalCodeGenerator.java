package wci.backend.compiler.generators;

import java.util.ArrayList;

import wci.backend.compiler.CodeGenerator;
import wci.intermediate.ICodeNode;
import wci.intermediate.icodeimpl.ICodeNodeTypeImpl;

public class RelationalCodeGenerator extends StatementCodeGenerator {

	public RelationalCodeGenerator(CodeGenerator parent) {
		super(parent);
	}

	public Object generate(ICodeNode node)
    {
		ArrayList<ICodeNode> children = node.getChildren();
		StatementCodeGenerator cg =  new StatementCodeGenerator(this);
		String result = "";
		result += cg.generate(children.get(0));
		result += cg.generate(children.get(1));
		switch ((ICodeNodeTypeImpl) node.getType()) {
			case EE:
		    	return result + "\tif_icmpeq ";
	        case NE:
		    	return result + "\tif_icmpne ";
	        case LT:
		    	return result + "\tif_icmplt ";
	        case LE:
		    	return result + "\tif_icmple ";
	        case GT:
		    	return result + "\tif_icmpgt ";
	        case GE:
		    	return result + "\tif_icmpge ";
		}
    	return result + "";
    }
}
