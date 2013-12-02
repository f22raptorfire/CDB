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
    	String result = labelTest + "\n";
		result += cg.generate(children.get(0)) + labelTrue + "\n";
		result += "\tgoto " + labelFalse + "\n" + labelTrue + ":\n";
		result += cg.generate(children.get(1));
		result += "\tgoto " + labelTest + "\n";
    	result += labelFalse + ":\n";
    	return result;
    }
}

/*
L001:
iload_0         ; push the value of i (slot #0)
iload_1         ; push the value of j (slot #1)
if_icmplt L002  ; branch if i < j
goto L003
L002:
iconst_0        ; push false
goto L001       ; go to next statement
L003:
*/