package util.parse;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private final String input;
    private int position;
    public Lexer(String input) {
        this.input = input;
        this.position = 0;
    }

    public List<Token> tokenize() {
        List<String> keywords = List.of("if.else.for.while.fck.class".split("."));
        List<Token> tokens = new ArrayList<>();
        while (position < input.length()) {
            char currentChar = input.charAt(position);
            switch (currentChar) {
                case '+' -> {
                    tokens.add(new Token(TokenType.PLUS, "+"));
                    position++;
                }
                case '-' -> {
                    tokens.add(new Token(TokenType.MINUS, "-"));
                    position++;
                }
                case '*' -> {
                    tokens.add(new Token(TokenType.MULTIPLY, "*"));
                    position++;
                }
                case '/' -> {
                    tokens.add(new Token(TokenType.DIVIDE, "/"));
                    position++;
                }
                case '(' -> {
                    tokens.add(new Token(TokenType.LPAREN, "("));
                    position++;
                }
                case ')' -> {
                    tokens.add(new Token(TokenType.RPAREN, ")"));
                    position++;
                }
                case '{' -> {
                    tokens.add(new Token(TokenType.LBRACE, "{"));
                    position++;
                }
                case '}' -> {
                    tokens.add(new Token(TokenType.RBRACE, "}"));
                    position++;
                }
                case '[' -> {
                    tokens.add(new Token(TokenType.LBRACKET, "["));
                    position++;
                }
                case ']' -> {
                    tokens.add(new Token(TokenType.RBRACKET, "]"));
                    position++;
                }
                case ' ' -> position++;
                case ';' -> {
                    tokens.add(new Token(TokenType.LINE_TERMINATOR, ";"));
                    position++;
                }
                case '?' -> {
                    tokens.add(new Token(TokenType.COMMENT_START, "?"));
                    position++;
                }
                case '~' -> tokens.add(new Token(TokenType.COMMENT_END, "~"));
                default -> {
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
                        if (keywords.contains(value.toString())) {

                        }
                        else {
                            tokens.add(new Token(TokenType.IDENTIFIER, value.toString()));
                        }
                    }
                    else {
                        position++;
                    }
                }
            }
        }
        // the first and last elements of this list are useless brackets that are NOT part of the code
        // (at the time of realizing this I completely forgot how my code worked, so this is the easiest way)
        tokens.remove(0);
        tokens.remove(tokens.size() - 1);
        return tokens;
    }
}

