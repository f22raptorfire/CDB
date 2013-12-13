package wci.backend.compiler.generators;

import java.util.ArrayList;

import wci.backend.compiler.CodeGenerator;
import wci.intermediate.ICodeNode;
import wci.intermediate.TypeSpec;
import wci.intermediate.icodeimpl.ICodeKeyImpl;
import wci.intermediate.symtabimpl.Predefined;

public class SubtractCodeGenerator extends StatementCodeGenerator {

	public SubtractCodeGenerator(CodeGenerator parent) {
		super(parent);
	}

	public Object generate(ICodeNode node)
    {
		ArrayList<ICodeNode> children = node.getChildren();
		StatementCodeGenerator cg =  new StatementCodeGenerator(this);
    	String result = "";
    	TypeSpec type = node.getTypeSpec();
    	result += cg.generate(children.get(0));
		if (type == Predefined.realType && children.get(0).getTypeSpec() == Predefined.integerType)
			result += "\ti2f\n";
		result += cg.generate(children.get(1));
		if (type == Predefined.realType && children.get(1).getTypeSpec() == Predefined.integerType)
			result += "\ti2f\n";
		if (type == Predefined.realType)
			result += "\tfsub\n";
		else
			result += "\tisub\n";
    	return result;
    }
}
