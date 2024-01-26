package util.ast;


public class Statement {

    public enum StatementType {
        STMT_DECL,
        STMT_EXPR,
        STMT_IF_ELSE,
        STMT_FOR,
        STMT_PRINT,
        STMT_RETURN,
        STMT_BLOCK
    }
    /**
     * <h2>Kind: What kind of statement?</h2>
     * <ul>
     *     <li>
     *         <code>STMT_DECL</code>
     *         indicates a (local) declaration, and the <i><b>decl</b></i> field will point to it.
     *     </li>
     *     <li>
     *         <code>STMT_EXPR</code>
     *         indicates an expression statement and the <i><b>expr</b></i> field will point to it.
     *     </li>
     *     <li>
     *         <code>STMT_IF_ELSE</code>
     *         indicates an if-else expression such that the
     *         <code>expr</code>
     *     field will point to the control expression, the
     *     <code>body</code>
     *     field to the statements executed if it is true, and the
     *     <code>else-body</code>
     *     field executed to the statement(s) executed if it is false.
     *     </li>
     *     <li>
     *         <code>STMT_FOR</code>
     *         indicates a for-loop, such that
     *         <code>init_expr</code>
     *         ,
     *         <code>expr</code>
     *         ,
     *         and
     *         <code>next_expr</code>
     *         are the three expressions in the loop header, and
     *         <code>body</code>
     *         points to the statements in the loop.
     *     </li>
     *     <li>
     *         <code>STMT_PRINT</code>
     *         indicates a
     *         <code>print</code>
     *         statement, and
     *         <code>expr</code>
     *         points to the expression to print.
     *     </li>
     *     <li>
     *         <code>STMT_RETURN</code>
     *         indicates a
     *         <code>return</code>
     *         statement,
     *         and
     *         <code>expr</code>
     *         points to the expression to return
     *     </li>
     *     <li>
     *         <code>STMT_BLOCK</code>
     *         indicates a block of statements inside curly braces, and
     *         <code>body</code>
     *         points to the contained statements.
     *     </li>
     *
     * </ul>
     *
     *
     *
     *
     *
     *
     *
     *
     *
     * <h2>This structure has a lot of fields, but each one is used <u>only when necessary</u></h3>
     * <p>Every statement uses the <code>kind</code> and <code>next</code> fields.</p>
     * <p>For example, the if-else statement (<code>STMT_IF_ELSE</code>) uses the <code>expr</code>, <code>body</code>,
     * and <code>else-body</code> fields</p>
     * <p>A for-loop uses the three <code>expr</code> fields to represent the three parts of the loop control,
     * and the
     * <code>body</code>
     * field to represent the code being executed</p>
     **/
    public Statement(StatementType kind, Declaration declaration, Expression init_expr, Expression expr,
                     Expression next_expr, Statement body, Statement else_body, Statement next)

    {
        this.kind = kind;
        this.declaration = declaration;
        this.init_expr = init_expr;
        this.expr = expr;
        this.next_expr = next_expr;
        this.body = body;
        this.else_body = else_body;
        this.next = next;
    }
    StatementType kind;
    Declaration declaration;
    Expression init_expr;
    Expression expr;
    Expression next_expr;
    Statement body;
    Statement else_body;
    Statement next;
}
