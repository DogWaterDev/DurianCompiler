package util.ast;
import org. fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import util.exceptions.InvalidFunctionDeclarationError;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

import static util.ast.Type.VarType.TYPE_FUNCTION;

/**
 * <p>This class is for the sole purpose of testing/development. It will print the contents of an AST (Abstract Syntax Tree)
 * in a readable manner for humans to the console.</p>
 */
public class ASTPrinter {
    private AbstractSyntaxTree ast;
    private Ansi ansi;
    private int lvl;
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

    private void printNonFunction(Declaration d, String line) {
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
        this.lvl++;
    }

    private void printFunction(Declaration d, String line) {
        // check if the function is invalid (no code contained)
        if (d.code != null) {
            if (d.code.)
        } else {
            try {
                throw new InvalidFunctionDeclarationError(
                        String.format("Function of AST '%s' has null-code." +
                                        " This is an invalid declaration '%s', process crashed.",
                                this.ast, d.name)
                );
            } catch (InvalidFunctionDeclarationError e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void printAST() {
        this.lvl = 1;
        Declaration d = ast.getDeclaration(0);
        String line = String.format("|%s%s", lvlIndentHelper(lvl, "--"), d.name) + String.format(";%s", d.type.kind);
        if (!Objects.equals(d.type.kind, TYPE_FUNCTION)) {
            printNonFunction(d, line);
        }
        else {
            printFunction(d, line);
        }


        System.out.println(line);
    }
}
