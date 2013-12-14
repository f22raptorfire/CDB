package wci.intermediate;

import java.util.ArrayList;

import wci.frontend.ASTADD;
import wci.frontend.ASTASSIGN;
import wci.frontend.ASTCALL;
import wci.frontend.ASTCOMPOUND;
import wci.frontend.ASTDATABASE;
import wci.frontend.ASTDIVIDE;
import wci.frontend.ASTDO;
import wci.frontend.ASTEE;
import wci.frontend.ASTFOR;
import wci.frontend.ASTGE;
import wci.frontend.ASTGT;
import wci.frontend.ASTIF;
import wci.frontend.ASTINTEGER_CONSTANT;
import wci.frontend.ASTLE;
import wci.frontend.ASTLT;
import wci.frontend.ASTMOD;
import wci.frontend.ASTMULTIPLY;
import wci.frontend.ASTNE;
import wci.frontend.ASTNEGATE;
import wci.frontend.ASTPARAMETERS;
import wci.frontend.ASTPRINT;
import wci.frontend.ASTPRINTLN;
import wci.frontend.ASTPROMPT_ADD;
import wci.frontend.ASTPROMPT_SHOW;
import wci.frontend.ASTREAL_CONSTANT;
import wci.frontend.ASTREFERENCE;
import wci.frontend.ASTSTRING_CONSTANT;
import wci.frontend.ASTSUBTRACT;
import wci.frontend.ASTVARIABLE;
import wci.frontend.ASTWHILE;
import wci.frontend.CdbParserVisitor;
import wci.frontend.SimpleNode;
import wci.intermediate.icodeimpl.ICodeKeyImpl;
import wci.intermediate.icodeimpl.ICodeNodeTypeImpl;
import wci.intermediate.symtabimpl.DefinitionImpl;
import wci.intermediate.symtabimpl.Predefined;
import wci.intermediate.symtabimpl.SymTabKeyImpl;

public class CdbParserVisitorAdapter implements CdbParserVisitor
{
    public Object visit(SimpleNode node, Object data)
    {
        return node.childrenAccept(this, data);
    }
    
    public Object visit(ASTADD node, Object data)
    {
		node.setType(ICodeNodeTypeImpl.ADD);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
    }
    
    public Object visit(ASTSUBTRACT node, Object data)
    {
		node.setType(ICodeNodeTypeImpl.SUBTRACT);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
    }

    public Object visit(ASTMULTIPLY node, Object data)
    {
		node.setType(ICodeNodeTypeImpl.MULTIPLY);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
    }

    public Object visit(ASTDIVIDE node, Object data)
    {
		node.setType(ICodeNodeTypeImpl.DIVIDE);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
    }

	public Object visit(ASTEE node, Object data) {
		node.setType(ICodeNodeTypeImpl.EE);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
	}

	public Object visit(ASTNE node, Object data) {
		node.setType(ICodeNodeTypeImpl.NE);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
	}

	public Object visit(ASTLT node, Object data) {
		node.setType(ICodeNodeTypeImpl.LT);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
	}

	public Object visit(ASTLE node, Object data) {
		node.setType(ICodeNodeTypeImpl.LE);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
	}

	public Object visit(ASTGT node, Object data) {
		node.setType(ICodeNodeTypeImpl.GT);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
	}

	public Object visit(ASTGE node, Object data) {
		node.setType(ICodeNodeTypeImpl.GE);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTASSIGN node, Object data) {
		node.setType(ICodeNodeTypeImpl.ASSIGN);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		SimpleNode node0 = (SimpleNode) node.jjtGetChild(0);
		node0.jjtAccept(this, data);
		SimpleNode node1 = (SimpleNode) node.jjtGetChild(1);
		node1.jjtAccept(this, data);
		TypeSpec variable = (TypeSpec) node0.getTypeSpec();
		TypeSpec expression = (TypeSpec) node1.getTypeSpec();
		if (variable != expression && (variable != Predefined.realType && expression != Predefined.integerType)) {
			Object line = node1.getAttribute(ICodeKeyImpl.LINE);
			while (line == null) {
				node1 = (SimpleNode) node1.jjtGetChild(0);
				line = node1.getAttribute(ICodeKeyImpl.LINE);
			}
			System.out.println("*** ERROR: At line " + line + " received " + expression.getIdentifier().getName() + " : expected " + variable.getIdentifier().getName());
		}
		return data;
	}

	@Override
	public Object visit(ASTCOMPOUND node, Object data) {
		node.setType(ICodeNodeTypeImpl.COMPOUND);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTWHILE node, Object data) {
		node.setType(ICodeNodeTypeImpl.WHILE);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTFOR node, Object data) {
		node.setType(ICodeNodeTypeImpl.FOR);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTDO node, Object data) {
		node.setType(ICodeNodeTypeImpl.DO);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTIF node, Object data) {
		node.setType(ICodeNodeTypeImpl.IF);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTPRINT node, Object data) {
		node.setType(ICodeNodeTypeImpl.PRINT);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTVARIABLE node, Object data) {
		node.setType(ICodeNodeTypeImpl.VARIABLE);
		return data;
	}

	@Override
	public Object visit(ASTINTEGER_CONSTANT node, Object data) {
		node.setType(ICodeNodeTypeImpl.INTEGER_CONSTANT);
		return data;
	}

	@Override
	public Object visit(ASTREAL_CONSTANT node, Object data) {
		node.setType(ICodeNodeTypeImpl.REAL_CONSTANT);
		return data;
	}

	@Override
	public Object visit(ASTSTRING_CONSTANT node, Object data) {
		node.setType(ICodeNodeTypeImpl.STRING_CONSTANT);
		return null;
	}

	@Override
	public Object visit(ASTPROMPT_SHOW node, Object data) {
		node.setType(ICodeNodeTypeImpl.PROMPT_SHOW);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTPROMPT_ADD node, Object data) {
		node.setType(ICodeNodeTypeImpl.PROMPT_ADD);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTDATABASE node, Object data) {
		node.setType(ICodeNodeTypeImpl.DATABASE);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTPRINTLN node, Object data) {
		node.setType(ICodeNodeTypeImpl.PRINTLN);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTCALL node, Object data) {
		node.setType(ICodeNodeTypeImpl.CALL);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		node.childrenAccept(this, data);
		SimpleNode procedure = (SimpleNode) node.jjtGetChild(0);
		String id = (String)procedure.getAttribute(ICodeKeyImpl.ID);
		SymTabEntry entry = ((SymTabStack) data).lookup(id);
		ArrayList<SymTabEntry> params = (ArrayList<SymTabEntry>) entry.getAttribute(SymTabKeyImpl.ROUTINE_PARMS);
		int childrenCount = node.jjtGetChild(1).jjtGetNumChildren();
		String line = "" + entry.getLineNumbers().get(entry.getLineNumbers().size() - 1);
		if (childrenCount != params.size()) {
			System.out.println("*** ERROR: Incorrect number of parameters on line " + line);
			return data;
		}
		SimpleNode parameterNode = (SimpleNode) node.jjtGetChild(1);
		TypeSpec expected;
		TypeSpec received;
		for (int i = 0; i < childrenCount; i++) {
			expected = params.get(i).getTypeSpec();
			received = ((SimpleNode)parameterNode.jjtGetChild(i)).getTypeSpec();
			if (params.get(i).getDefinition() == DefinitionImpl.REFERENCE && ((ICodeNode)parameterNode.jjtGetChild(i)).getType() != ICodeNodeTypeImpl.REFERENCE) {
				System.out.println("*** ERROR: At line " + line + " received " + received.getIdentifier().getName() + " expected " + expected.getIdentifier().getName() + " reference");
				continue;
			}
			if (expected != received) {
				System.out.println("*** ERROR: At line " + line + " received " + received.getIdentifier().getName() + " expected " + expected.getIdentifier().getName());
			}
		}
		return data;
	}

	@Override
	public Object visit(ASTPARAMETERS node, Object data) {
		node.setType(ICodeNodeTypeImpl.PARAMETERS);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTREFERENCE node, Object data) {
		node.setType(ICodeNodeTypeImpl.REFERENCE);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTNEGATE node, Object data) {
		node.setType(ICodeNodeTypeImpl.NEGATE);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTMOD node, Object data) {
		node.setType(ICodeNodeTypeImpl.MOD);
		int childCount = node.jjtGetNumChildren();
		for (int i = 0; i < childCount; i++) {
			node.addChild((ICodeNode) node.jjtGetChild(i));
		}
		return node.childrenAccept(this, data);
	}
}
