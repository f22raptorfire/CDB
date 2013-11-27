package wci.intermediate;

import wci.frontend.ASTADD;
import wci.frontend.ASTASSIGN;
import wci.frontend.ASTCOMPOUND;
import wci.frontend.ASTDIVIDE;
import wci.frontend.ASTDO;
import wci.frontend.ASTEE;
import wci.frontend.ASTFOR;
import wci.frontend.ASTGE;
import wci.frontend.ASTGT;
import wci.frontend.ASTIF;
import wci.frontend.ASTLE;
import wci.frontend.ASTLT;
import wci.frontend.ASTMULTIPLY;
import wci.frontend.ASTNE;
import wci.frontend.ASTPRINT;
import wci.frontend.ASTSUBTRACT;
import wci.frontend.ASTWHILE;
import wci.frontend.ASTintegerConstant;
import wci.frontend.ASTrealConstant;
import wci.frontend.ASTvariable;
import wci.frontend.CdbParserVisitor;
import wci.frontend.SimpleNode;
import wci.intermediate.icodeimpl.ICodeKeyImpl;
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
        return node.childrenAccept(this, data);
    }

    public Object visit(ASTvariable node, Object data)
    {
    	System.out.println("Variable");
        return node.childrenAccept(this, data);
    }

    public Object visit(ASTintegerConstant node, Object data)
    {
    	System.out.println("Integer");
        return node.childrenAccept(this, data);
    }

    public Object visit(ASTrealConstant node, Object data)
    {
        return node.childrenAccept(this, data);
    }

	public Object visit(ASTEE node, Object data) {
		return node.childrenAccept(this, data);
	}

	public Object visit(ASTNE node, Object data) {
		return node.childrenAccept(this, data);
	}

	public Object visit(ASTLT node, Object data) {
		return node.childrenAccept(this, data);
	}

	public Object visit(ASTLE node, Object data) {
		return node.childrenAccept(this, data);
	}

	public Object visit(ASTGT node, Object data) {
		return node.childrenAccept(this, data);
	}

	public Object visit(ASTGE node, Object data) {
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
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTFOR node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTDO node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTIF node, Object data) {
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
}
