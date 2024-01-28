package util.ast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static util.ast.Type.VarType.*;

public class AbstractSyntaxTree {
    private List<Declaration> declarations = new ArrayList<>();

    public List<Declaration> getDeclarations() {
        return declarations;
    }
    public Declaration getDeclaration(int index) {
        return declarations.get(index);
    }
    public void addDeclaration(Declaration declaration ) {
        declarations.add(declaration);
    }
    public void addStatement(Declaration pd, Statement statement) {
        if (declarations.contains(pd)) {
            int index = declarations.indexOf(pd);
            pd = createDeclaration(pd.name, pd.type, pd.value, statement, pd.next);
            declarations.set(index, pd);
        }
    }

    public Declaration createDeclaration(String name, Type type, Expression value, Statement code, Declaration next) {
        return new Declaration(name, type, value, code, next);
    }
    public Type createType(Type.VarType type, Type subType, Type.ParamList params) {
        return new Type(type, subType, params);
    }
    public Type.ParamList createParamList(String name, Type type, Type.ParamList next) {
        return new Type.ParamList(name, type, next);
    }
    public Statement createStatement(Statement.StatementType kind, Declaration declaration, Expression init_expr,
                                     Expression expr, Expression next_expr, Statement body, Statement else_body, Statement next)
    {
        return new Statement(kind, declaration, init_expr, expr, next_expr, body, else_body, next);
    }
    public Expression createExpression(Expression.ExpressionType kind, Expression left, Expression right) {
        return new Expression(kind, left, right);
    }


    // test function
    public Declaration run() {
        Declaration d = createDeclaration("square",
                createType(TYPE_FUNCTION,
                        createType(Type.VarType.TYPE_INTEGER, null,null),
                        createParamList(
                                "x",
                                createType(Type.VarType.TYPE_INTEGER, null, null),
                                null
                        )),
                null,
                createStatement(Statement.StatementType.STMT_RETURN, null, null,
                        createExpression(Expression.ExpressionType.EXPR_MUL,
                                Expression.exprCreateName("x"),
                                Expression.exprCreateName("x")),
                        null,null,null,null),null);
        this.addDeclaration(d);
        return d;
    }
}
