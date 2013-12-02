package wci.backend.compiler.generators;

import wci.intermediate.*;
import wci.intermediate.icodeimpl.*;
import wci.backend.compiler.CodeGenerator;
import static wci.intermediate.ICodeNodeType.*;
import static wci.intermediate.icodeimpl.ICodeKeyImpl.*;

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
        System.out.println(node);
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

            case INTEGER_CONSTANT: {
                IntegerCodeGenerator integerGenerator = new IntegerCodeGenerator(this);
                return integerGenerator.generate(node);
            }

            case VARIABLE: {
            	VariableCodeGenerator variableGenerator = new VariableCodeGenerator(this);
            	return variableGenerator.generate(node);
            }
            
            case ADD: {
            	AddCodeGenerator addGenerator = new AddCodeGenerator(this);
            	return addGenerator.generate(node);
            }
            /*
            case SELECT: {
                SelectExecutor selectExecutor = new SelectExecutor(this);
                return selectExecutor.execute(node);
            }

            case NO_OP: return null;
*/
            default: {
                return "";
            }
        }
    }
}
