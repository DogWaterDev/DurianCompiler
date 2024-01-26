package util.parse;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private String input;
    private int position;

    public Lexer(String input) {
        this.input = input;
        this.position = 0;
    }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();
        while (position < input.length()) {
            char currentChar = input.charAt(position);
            switch (currentChar) {
                case '+':
                    tokens.add(new Token(TokenType.PLUS, "+"));
                    position++;
                    break;
                case '-':
                    tokens.add(new Token(TokenType.MINUS, "-"));
                    position++;
                    break;
                case '*':
                    tokens.add(new Token(TokenType.MULTIPLY, "*"));
                    position++;
                    break;
                case '/':
                    tokens.add(new Token(TokenType.DIVIDE, "/"));
                    position++;
                    break;
                case '(':
                    tokens.add(new Token(TokenType.LPAREN, "("));
                    position++;
                    break;
                case ')':
                    tokens.add(new Token(TokenType.RPAREN, ")"));
                    position++;
                    break;
                case ' ':
                    position++;
                    break;
                default:
                    if (Character.isDigit(currentChar)) {
                        StringBuilder value = new StringBuilder();
                        while (position < input.length() && Character.isDigit(input.charAt(position))) {
                            value.append(input.charAt(position));
                            position++;
                        }
                        tokens.add(new Token(TokenType.NUMBER, value.toString()));
                    } else if (Character.isLetter(currentChar)) {
                        StringBuilder value = new StringBuilder();
                        while (position < input.length() && Character.isLetterOrDigit(input.charAt(position))) {
                            value.append(input.charAt(position));
                            position++;
                        }
                        tokens.add(new Token(TokenType.IDENTIFIER, value.toString()));
                    } else {
                        //
                        position++;
                    }
            }
        }
        return tokens;
    }
}

