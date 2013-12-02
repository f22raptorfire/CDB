package wci.backend.compiler.generators;

import java.util.ArrayList;

import wci.backend.compiler.CodeGenerator;
import wci.intermediate.ICodeNode;

public class AddCodeGenerator extends StatementCodeGenerator {

	public AddCodeGenerator(CodeGenerator parent) {
		super(parent);
	}

	public Object generate(ICodeNode node)
    {
		ArrayList<ICodeNode> children = node.getChildren();
		StatementCodeGenerator cg =  new StatementCodeGenerator(this);
    	String result = "";
		result += cg.generate(children.get(0));
		result += cg.generate(children.get(1));
    	result += "\tiadd" + "\n";
    	return result;
    }
}
