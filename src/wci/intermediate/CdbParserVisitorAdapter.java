package wci.intermediate;

import wci.frontend.ASTEE;
import wci.frontend.ASTGE;
import wci.frontend.ASTGT;
import wci.frontend.ASTLE;
import wci.frontend.ASTLT;
import wci.frontend.ASTNE;
import wci.frontend.ASTadd;
import wci.frontend.ASTassignment;
import wci.frontend.ASTdoLoop;
import wci.frontend.ASTforLoop;
import wci.frontend.ASTifStatement;
import wci.frontend.ASTscript;
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
         return node.childrenAccept(this, data);
    }

    public Object visit(ASTintegerConstant node, Object data)
    {
        return node.childrenAccept(this, data);
    }

    public Object visit(ASTrealConstant node, Object data)
    {
        return node.childrenAccept(this, data);
    }

	public Object visit(ASTscript node, Object data) {
		return node.childrenAccept(this, data);
	}

	public Object visit(ASTifStatement node, Object data) {
		return node.childrenAccept(this, data);
	}

	public Object visit(ASTassignment node, Object data) {
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
}
