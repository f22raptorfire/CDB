package wci.backend.compiler.generators;

import java.util.ArrayList;

import wci.backend.compiler.CodeGenerator;
import wci.intermediate.ICodeNode;
import wci.intermediate.TypeSpec;
import wci.intermediate.icodeimpl.ICodeNodeTypeImpl;
import wci.intermediate.symtabimpl.Predefined;

public class RelationalCodeGenerator extends StatementCodeGenerator {

	public RelationalCodeGenerator(CodeGenerator parent) {
		super(parent);
	}

	public Object generate(ICodeNode node)
    {
		ArrayList<ICodeNode> children = node.getChildren();
		StatementCodeGenerator cg =  new StatementCodeGenerator(this);
		String result = "";
		TypeSpec typeOne = children.get(0).getTypeSpec();
		TypeSpec typeTwo = children.get(1).getTypeSpec();
		result += cg.generate(children.get(0));
		if (typeOne == Predefined.integerType && typeTwo == Predefined.realType)
			result += "\ti2f\n";
		result += cg.generate(children.get(1));
		if (typeOne == Predefined.realType && typeTwo == Predefined.integerType)
			result += "\ti2f\n";
		if (typeOne == Predefined.realType || typeTwo == Predefined.realType) {
			switch ((ICodeNodeTypeImpl) node.getType()) {
				case EE:
			    	return result + "\tfcmpl\n\ticonst_0\n\tif_icmpeq ";
		        case NE:
			    	return result + "\tfcmpl\n\ticonst_0\n\tif_icmpne ";
		        case LT:
			    	return result + "\tfcmpl\n\ticonst_0\n\tif_icmplt ";
		        case LE:
			    	return result + "\tfcmpl\n\ticonst_0\n\tif_icmple ";
		        case GT:
			    	return result + "\tfcmpl\n\ticonst_0\n\tif_icmpgt ";
		        case GE:
			    	return result + "\tfcmpl\n\ticonst_0\n\tif_icmpge ";
			}
		} else {
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
		}
    	return result + "";
    }
}
