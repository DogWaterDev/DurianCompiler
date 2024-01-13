import util.TokenTypes;
import util.Token;
import util.exceptions.UnsupportedTokenException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;


public class Tokenizer {
    public static ArrayList<String> identifiers = new ArrayList<>();
    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static TokenTypes toType(String raw) throws UnsupportedTokenException {
        if (isInteger(raw)) {
            return TokenTypes.Integer;
        }
        else {
            boolean isFloat;
            // Check if float
            try {
                Float.parseFloat(raw);
                isFloat = true;
            } catch (NumberFormatException e) {
                isFloat = false;
            }
            if (isFloat) {
                return TokenTypes.Float;
            }
            if (identifiers.contains(raw)) {
                return TokenTypes.Identifier;
            }
            if (Objects.equals(raw, "set")) {
                return TokenTypes.Set;
            }
            if (Objects.equals(raw, "=")) {
                return TokenTypes.Equals;
            }
            if (Objects.equals(raw, "+")) {
                return TokenTypes.PlusOperator;
            }
            if (Objects.equals(raw, "(")) {
                return TokenTypes.OpenParen;
            }
            if (Objects.equals(raw, ")")) {
                return TokenTypes.CloseParen;
            }

            // if this is NONE of the above
            else {
                throw new UnsupportedTokenException("Unsupported token entered: '" + raw + "' ");
            }
        }
    }
    public static ArrayList<Token> tokenize(String path) throws IOException {
        ArrayList<Token> tokenArrayList = new ArrayList<>();
            for (String line : Files.readAllLines(Path.of(path))) {
                String[] strTokens = line.split(" ");
                for (String token : strTokens) {
                    tokenArrayList.add(new Token(token, null, null, toType(token)));
                }
            }

        return tokenArrayList;
    }
}
