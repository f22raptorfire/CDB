package wci.intermediate;

import wci.frontend.*;
import wci.intermediate.icodeimpl.ICodeNodeTypeImpl;
import wci.intermediate.symtabimpl.*;

public class TypeSetterVisitor extends CdbParserVisitorAdapter
{
    private void setType(SimpleNode node)
    {
        int count = node.jjtGetNumChildren();
        TypeSpec type = Predefined.integerType;
        
        for (int i = 0; (i < count) && (type == Predefined.integerType); ++i) {
            SimpleNode child = (SimpleNode) node.jjtGetChild(i);
            TypeSpec childType = child.getTypeSpec();
            
            if (childType == Predefined.realType) {
                type = Predefined.realType;
            }
        }
        
        node.setTypeSpec(type);
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
        return data;
    }
    
    public Object visit(ASTINTEGER_CONSTANT node, Object data)
    {
		node.setType(ICodeNodeTypeImpl.INTEGER_CONSTANT);
        return data;
    }
    
    public Object visit(ASTREAL_CONSTANT node, Object data)
    {
		node.setType(ICodeNodeTypeImpl.REAL_CONSTANT);
        return data;
    }
    
    public Object visit(ASTSTRING_CONSTANT node, Object data)
    {
		node.setType(ICodeNodeTypeImpl.STRING_CONSTANT);
        return data;
    }
}
