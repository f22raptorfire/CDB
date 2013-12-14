package wci.intermediate;

import wci.frontend.*;
import wci.intermediate.icodeimpl.ICodeKeyImpl;
import wci.intermediate.icodeimpl.ICodeNodeTypeImpl;
import wci.intermediate.symtabimpl.*;

public class TypeSetterVisitor extends CdbParserVisitorAdapter
{
    private void setType(SimpleNode node)
    {
        int count = node.jjtGetNumChildren();
        SimpleNode child = (SimpleNode) node.jjtGetChild(0);
        TypeSpec type = child.getTypeSpec();
        if (type == Predefined.stringType && count > 1) {
        	System.out.println("*** ERROR: Expression uses a string at line " + child.getAttribute(ICodeKeyImpl.LINE));
        }
        
        type = Predefined.integerType;
        for (int i = 0; i < count; ++i) {
            child = (SimpleNode) node.jjtGetChild(i);
            TypeSpec childType = child.getTypeSpec();
            if (childType == Predefined.realType) {
            	type = Predefined.realType;
            }
            if (childType == Predefined.stringType) {
                type = Predefined.undefinedType;
                System.out.println("*** ERROR: Expression uses a string at line " + child.getAttribute(ICodeKeyImpl.LINE));
                break;
            }
        }
        
        node.setTypeSpec(type);
    }
    
    public Object visit(ASTREFERENCE node, Object data)
    {
        Object obj = super.visit(node, data);
        node.setTypeSpec(((SimpleNode)node.jjtGetChild(0)).getTypeSpec());
        return obj;
    }
    
    public Object visit(ASTMOD node, Object data)
    {
        Object obj = super.visit(node, data);
        setType(node);
        return obj;
    }
    
    public Object visit(ASTADD node, Object data)
    {
        Object obj = super.visit(node, data);
        setType(node);
        return obj;
    }

    public Object visit(ASTSUBTRACT node, Object data)
    {
        Object obj = super.visit(node, data);
        setType(node);
        return obj;
    }

    public Object visit(ASTMULTIPLY node, Object data)
    {
        Object obj = super.visit(node, data);
        setType(node);
        return obj;
    }

    public Object visit(ASTDIVIDE node, Object data)
    {
        Object obj = super.visit(node, data);
        setType(node);
        return obj;
    }
    
    public Object visit(ASTVARIABLE node, Object data)
    {
		node.setType(ICodeNodeTypeImpl.VARIABLE);
        return node.getTypeSpec();
    }
    
    public Object visit(ASTINTEGER_CONSTANT node, Object data)
    {
		node.setType(ICodeNodeTypeImpl.INTEGER_CONSTANT);
        return Predefined.integerType;
    }
    
    public Object visit(ASTREAL_CONSTANT node, Object data)
    {
		node.setType(ICodeNodeTypeImpl.REAL_CONSTANT);
        return Predefined.realType;
    }
    
    public Object visit(ASTSTRING_CONSTANT node, Object data)
    {
		node.setType(ICodeNodeTypeImpl.STRING_CONSTANT);
        return Predefined.stringType;
    }
}
