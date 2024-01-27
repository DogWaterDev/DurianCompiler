package util.ast;
import org. fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

import static util.ast.Type.VarType.TYPE_FUNCTION;

public class ASTPrinter {
    private AbstractSyntaxTree ast;
    private Ansi ansi;
    public ASTPrinter(AbstractSyntaxTree ast) {
        AnsiConsole.systemInstall();
        ansi = Ansi.ansi();
        this.ast = ast;
    }
    public AbstractSyntaxTree getAST() {
        return this.ast;
    }
    public void setAST(AbstractSyntaxTree newAst) {
        this.ast = newAst;
    }
    private String lvlIndentHelper(int level, String replace) {
        return new String(new char[level]).replace("\0", replace);
    }
    private String recurse(Declaration d) {
        if (!Objects.equals(d.type.kind, TYPE_FUNCTION)) {
            if (d.value.kind == Expression.ExpressionType.EXPR_BOOLEAN_LITERAL) {
                if (d.value.integer_value == 0) {
                    line += ";=false";
                }
                else if (d.value.integer_value == 1) {
                    line += ";=true";
                }
                else if (d.value.integer_value == 2) {
                    line += ";=unknown";
                }
            }
            else if (d.value.kind == Expression.ExpressionType.EXPR_INTEGER_LITERAL) {
                line += String.format(";%s", d.value.integer_value);
            }
            else if (d.value.kind == Expression.ExpressionType.EXPR_STRING_LITERAL) {
                line += String.format(";'%s'", d.value.string_literal);

            }
        }
    }

    public void printAST() {
        String line = "";
        int lvl = 1;
        Declaration d = ast.getDeclaration(0);
        line += String.format("|%s%s", lvlIndentHelper(lvl, "--"), d.name);
        line += String.format(";%s", d.type.kind);

        else {

        }
        System.out.println(line);
    }
}
