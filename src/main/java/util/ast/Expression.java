package util.ast;

public class Expression {
    public enum ExpressionType {
        EXPR_ADD,
        EXPR_SUB,
        EXPR_MUL,
        EXPR_DIV,
        EXPR_SET,
        EXPR_SUBSCRIPT,
        EXPR_LOG_NOT,
        EXPR_CALL, // A function call is made by creating this node, such that the left-hand side is the function name
        // and the right hand side is an unbalanced tree of  EXPR_ARG nodes.


        // LITERALS
        EXPR_NAME,

        EXPR_BOOLEAN_LITERAL,
        EXPR_INTEGER_LITERAL,
        EXPR_STRING_LITERAL
    }
    public Expression(ExpressionType kind, Expression left, Expression right) {
        this.kind = kind;
        this.left = left;
        this.right = right;
    }
    public static Expression exprCreateName(String name) {
        return new ExpressionName(name);
    }

    public static Expression exprCreateIntegerLiteral(int i) {
        return new ExpressionIntegerLiteral(i);
    }

    public static Expression exprCreateBooleanLiteral(int b) {
        return new ExpressionBooleanLiteral(b);
    }


    public static Expression exprCreateStringLiteral(String str) {
        return new ExpressionStringLiteral(str);
    }
    ExpressionType kind;
    Expression left;
    Expression right;
    // ----------------

    String name; // will be set for EXPR_NAME
    int integer_value; //  " EXPR_INTEGER_LITERAL (" = the above text)
    String string_literal; //  " EXPR_STRING_LITERAL
}
class ExpressionName extends Expression {
    private String name;

    public ExpressionName(String name) {
        super(ExpressionType.EXPR_NAME, null, null);
        this.name = name;
    }
}

class ExpressionIntegerLiteral extends Expression {
    private int value;

    public ExpressionIntegerLiteral(int value) {
        super(ExpressionType.EXPR_INTEGER_LITERAL, null, null);
        this.value = value;
    }
}

class ExpressionBooleanLiteral extends Expression {
    private int value;

    public ExpressionBooleanLiteral(int value) {
        super(ExpressionType.EXPR_BOOLEAN_LITERAL, null, null);
        this.value = value;
    }
}


class ExpressionStringLiteral extends Expression {

    public ExpressionStringLiteral(String value) {
        super(ExpressionType.EXPR_STRING_LITERAL, null, null);
        // i'm not sure why this works but remember,
        // if it ain't broke don't fix it
        this.string_literal = value;
    }
}



