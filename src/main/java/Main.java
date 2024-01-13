import util.Token;
import util.ast.AbstractSyntaxTree;
import util.ast.Declaration;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        for (Token token : Tokenizer.tokenize("D:\\Projekte\\GitHub\\Java\\DurianCompiler\\test.txt")) {
            System.out.println(token.value + " -- Type: " + token.type);
        }
        AbstractSyntaxTree ast = new AbstractSyntaxTree();
        Declaration d = ast.run();
        ast.printDeclaration(d);
    }
}
