package wci.intermediate;

import wci.frontend.ASTASSIGN;
import wci.frontend.ASTCOMPOUND;
import wci.frontend.ASTEE;
import wci.frontend.ASTGE;
import wci.frontend.ASTGT;
import wci.frontend.ASTLE;
import wci.frontend.ASTLT;
import wci.frontend.ASTNE;
import wci.frontend.ASTadd;
import wci.frontend.ASTdoLoop;
import wci.frontend.ASTforLoop;
import wci.frontend.ASTifStatement;
import wci.frontend.ASTsubtract;
import wci.frontend.ASTmultiply;
import wci.frontend.ASTdivide;
import wci.frontend.ASTcompoundStatement;
import wci.frontend.ASTintegerConstant;
import wci.frontend.ASTrealConstant;
import wci.frontend.ASTvariable;
import wci.frontend.ASTwhileLoop;
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
    
    public Object visit(ASTcompoundStatement node, Object data)
    {
        return node.childrenAccept(this, data);
    }
    
    public Object visit(ASTadd node, Object data)
    {
        return node.childrenAccept(this, data);
    }
    
    public Object visit(ASTsubtract node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    public Object visit(ASTmultiply node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    public Object visit(ASTdivide node, Object data)
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

	public Object visit(ASTifStatement node, Object data) {
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
	public Object visit(ASTdoLoop node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTforLoop node, Object data) {
		return node.childrenAccept(this, data);
	}

	@Override
	public Object visit(ASTwhileLoop node, Object data) {
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
}
