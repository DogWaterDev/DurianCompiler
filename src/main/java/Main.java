import org.checkerframework.checker.units.qual.A;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.jetbrains.annotations.NotNull;
import util.ast.ASTPrinter;
import util.ast.AbstractSyntaxTree;
import util.ast.Declaration;
import util.ast.Expression;
import util.parse.Lexer;
import util.parse.Token;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import static util.ast.Type.VarType.*;

public class Main {
    public static void main(String @NotNull [] args) throws IOException {
        Lexer lexer = new Lexer(Files.readAllLines(Path.of("C:\\Users\\ramsa\\OneDrive\\Desktop\\test\\e.txt")).toString());
        List<Token> tokens = lexer.tokenize();
        AbstractSyntaxTree ast = new AbstractSyntaxTree();
        ast.run();
//        ast.addDeclaration(
//                ast.createDeclaration("test",
//                        ast.createType(TYPE_STRING, null, null),
//                        Expression.exprCreateStringLiteral("test"),
//                        // here i am creating an expression of string type and giving value of "cheesecake!"
//                        // but when i attempt to print the value i get null
//                        null, null));
        ASTPrinter astPrinter = new ASTPrinter(ast);
        astPrinter.printAST();


/*        for (Token token : tokens) {
            System.out.println(String.format("Token of type: %s\nhas value: %s\n\n", token.getType(), token.getValue()));

        }*/
    }
}

// ok so basicaly this is pretty-print for the abstract syntax trees
//