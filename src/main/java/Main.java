import org.jetbrains.annotations.NotNull;
import util.parse.Lexer;
import util.parse.Token;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
public class Main {
    public static void main(String @NotNull [] args) throws IOException {
        Lexer lexer = new Lexer(Files.readAllLines(Path.of("C:\\Users\\ramsa\\OneDrive\\Desktop\\test\\e.txt")).toString());
        for (Token token : lexer.tokenize()) {
            System.out.println(String.format("Token of type: %s\nhas value: %s\n\n", token.getType(), token.getValue()));
        }
    }
}
