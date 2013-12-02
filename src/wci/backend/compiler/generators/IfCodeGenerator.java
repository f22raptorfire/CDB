package wci.backend.compiler.generators;

import java.util.ArrayList;

import wci.backend.compiler.CodeGenerator;
import wci.intermediate.ICodeNode;

public class IfCodeGenerator extends StatementCodeGenerator {

	public IfCodeGenerator(CodeGenerator parent) {
		super(parent);
	}

	public Object generate(ICodeNode node)
    {
		ArrayList<ICodeNode> children = node.getChildren();
		StatementCodeGenerator cg =  new StatementCodeGenerator(this);
    	String result = "";
    	String labelThen = String.format("L%03d", labelCount++);
    	String labelEnd = String.format("L%03d", labelCount++);
		result += cg.generate(children.get(0)) + labelThen + "\n";
		if (children.size() == 3) {
			result += cg.generate(children.get(2));
		}
		result += "\tgoto " + labelEnd + "\n" + labelThen + ":\n";
		result += cg.generate(children.get(1));
    	result += labelEnd + ":\n";
    	return result;
    }
}
