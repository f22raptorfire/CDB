package wci.backend.compiler.generators;

import java.util.ArrayList;

import wci.backend.compiler.CodeGenerator;
import wci.intermediate.ICodeNode;

public class DoCodeGenerator extends StatementCodeGenerator {

	public DoCodeGenerator(CodeGenerator parent) {
		super(parent);
	}

	public Object generate(ICodeNode node)
    {
		ArrayList<ICodeNode> children = node.getChildren();
		StatementCodeGenerator cg =  new StatementCodeGenerator(this);
    	String labelDo = String.format("L%03d", labelCount++);
    	String result = labelDo + ":\n";
		result += cg.generate(children.get(0));
		result += cg.generate(children.get(1)) + labelDo + "\n";
    	return result;
    }
}
