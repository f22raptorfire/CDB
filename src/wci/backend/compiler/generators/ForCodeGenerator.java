package wci.backend.compiler.generators;

import java.util.ArrayList;

import wci.backend.compiler.CodeGenerator;
import wci.intermediate.ICodeNode;

public class ForCodeGenerator extends StatementCodeGenerator {

	public ForCodeGenerator(CodeGenerator parent) {
		super(parent);
	}

	public Object generate(ICodeNode node)
    {
		ArrayList<ICodeNode> children = node.getChildren();
		StatementCodeGenerator cg =  new StatementCodeGenerator(this);
		String result = "" + cg.generate(children.get(0));
    	String labelTest = String.format("L%03d", labelCount++);
    	String labelTrue = String.format("L%03d", labelCount++);
    	String labelFalse = String.format("L%03d", labelCount++);
    	result += labelTest + ":\n";
		result += cg.generate(children.get(1)) + labelTrue + "\n";
		result += "\tgoto " + labelFalse + "\n" + labelTrue + ":\n";
		result += cg.generate(children.get(3));
		result += cg.generate(children.get(2));
		result += "\tgoto " + labelTest + "\n";
    	result += labelFalse + ":\n";
    	return result;
    }
}
