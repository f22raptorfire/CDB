package wci.backend.compiler.generators;

import wci.intermediate.*;
import wci.intermediate.icodeimpl.*;
import wci.backend.compiler.CodeGenerator;

/**
 * <h1>StatementExecutor</h1>
 *
 * <p>Execute a statement.</p>
 *
 * <p>Copyright (c) 2009 by Ronald Mak</p>
 * <p>For instructional purposes only.  No warranties.</p>
 */
public class StatementCodeGenerator extends CodeGenerator
{
    /**
     * Constructor.
     * @param the parent executor.
     */
    public StatementCodeGenerator(CodeGenerator parent)
    {
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
        ICodeNodeTypeImpl nodeType = (ICodeNodeTypeImpl) node.getType();
        System.out.println(node + " " + nodeType);
        switch (nodeType) {

	        case ASSIGN: {
	            AssignmentCodeGenerator assignmentGenerator =
	                new AssignmentCodeGenerator(this);
	            return assignmentGenerator.generate(node);
	        }

            case COMPOUND: {
                CompoundCodeGenerator compoundGenerator = new CompoundCodeGenerator(this);
                return compoundGenerator.generate(node);
            }

            case PRINT: {
                PrintCodeGenerator printGenerator = new PrintCodeGenerator(this);
                return printGenerator.generate(node);
            }
            
            case PRINTLN: {
                PrintlnCodeGenerator printlnGenerator = new PrintlnCodeGenerator(this);
                return printlnGenerator.generate(node);
            }

            case INTEGER_CONSTANT: {
                IntegerCodeGenerator integerGenerator = new IntegerCodeGenerator(this);
                return integerGenerator.generate(node);
            }

            case STRING_CONSTANT: {
                StringCodeGenerator stringGenerator = new StringCodeGenerator(this);
                return stringGenerator.generate(node);
            }
            
            case VARIABLE: {
            	VariableCodeGenerator variableGenerator = new VariableCodeGenerator(this);
            	return variableGenerator.generate(node);
            }
            
            case SUBTRACT: {
            	SubtractCodeGenerator subtractGenerator = new SubtractCodeGenerator(this);
            	return subtractGenerator.generate(node);
            }
            
            case ADD: {
            	AddCodeGenerator addGenerator = new AddCodeGenerator(this);
            	return addGenerator.generate(node);
            }
            
            case MULTIPLY: {
            	MultiplyCodeGenerator multiplyGenerator = new MultiplyCodeGenerator(this);
            	return multiplyGenerator.generate(node);
            }
            
            case DIVIDE: {
            	DivideCodeGenerator divideGenerator = new DivideCodeGenerator(this);
            	return divideGenerator.generate(node);
            }
            
            case EE:
            case NE:
            case LT:
            case LE:
            case GT:
            case GE: {
            	RelationalCodeGenerator relationalGenerator = new RelationalCodeGenerator(this);
            	return relationalGenerator.generate(node);
            }
            
            case IF: {
            	IfCodeGenerator ifGenerator = new IfCodeGenerator(this);
            	return ifGenerator.generate(node);
            }
            
            case WHILE: {
            	WhileCodeGenerator whileGenerator = new WhileCodeGenerator(this);
            	return whileGenerator.generate(node);
            }
            
            case FOR: {
            	ForCodeGenerator forGenerator = new ForCodeGenerator(this);
            	return forGenerator.generate(node);
            }

            case DO: {
            	DoCodeGenerator doGenerator = new DoCodeGenerator(this);
            	return doGenerator.generate(node);
            }
            
            case PROMPT_SHOW: {
            	PromptShowGenerator promptShowGenerator = new PromptShowGenerator(this);
            	return promptShowGenerator.generate(node);
            }
            
            case PROMPT_ADD: {
            	PromptAddGenerator promptAddGenerator = new PromptAddGenerator(this);
            	return promptAddGenerator.generate(node);
            }
            
            case DATABASE: {
            	DatabaseGenerator databaseGenerator = new DatabaseGenerator(this);
            	return databaseGenerator.generate(node);
            }
            
            case CALL: {
            	CallGenerator callGenerator = new CallGenerator(this);
            	return callGenerator.generate(node);
            }
            
            default: {
                return "";
            }
        }
    }
}
