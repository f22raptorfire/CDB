package wci.backend.compiler.generators;

import java.util.ArrayList;

import wci.backend.compiler.CodeGenerator;
import wci.intermediate.ICodeNode;

public class WhileCodeGenerator extends StatementCodeGenerator {

	public WhileCodeGenerator(CodeGenerator parent) {
		super(parent);
	}

	public Object generate(ICodeNode node)
    {
		ArrayList<ICodeNode> children = node.getChildren();
		StatementCodeGenerator cg =  new StatementCodeGenerator(this);
    	String labelTest = String.format("L%03d", labelCount++);
    	String labelTrue = String.format("L%03d", labelCount++);
    	String labelFalse = String.format("L%03d", labelCount++);
    	String result = labelTest + ":\n";
		result += cg.generate(children.get(0)) + labelTrue + "\n";
		result += "\tgoto " + labelFalse + "\n" + labelTrue + ":\n";
		result += cg.generate(children.get(1));
		result += "\tgoto " + labelTest + "\n";
    	result += labelFalse + ":\n";
    	return result;
    }
}
