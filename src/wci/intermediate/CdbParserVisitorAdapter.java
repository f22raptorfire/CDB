package wci.intermediate;

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
import wci.frontend.ASTMULTIPLY;
import wci.frontend.ASTNE;
import wci.frontend.ASTPARAMETERS;
import wci.frontend.ASTPRINT;
import wci.frontend.ASTPRINTLN;
import wci.frontend.ASTPROMPT_ADD;
import wci.frontend.ASTPROMPT_SHOW;
import wci.frontend.ASTREAL_CONSTANT;
import wci.frontend.ASTSTRING_CONSTANT;
import wci.frontend.ASTSUBTRACT;
import wci.frontend.ASTVARIABLE;
import wci.frontend.ASTWHILE;
import wci.frontend.CdbParserVisitor;
import wci.frontend.SimpleNode;
import wci.intermediate.icodeimpl.ICodeNodeTypeImpl;

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
		return node.childrenAccept(this, data);
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
		return node.childrenAccept(this, data);
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
}
