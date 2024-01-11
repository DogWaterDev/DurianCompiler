import util.Token;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        for (Token token : Tokenizer.tokenize("D:\\Projekte\\TardFest\\Discord\\DurianCompiler\\test.txt")) {
            System.out.println(token.value + " -- Type: " + token.type);
        }
    }
}
