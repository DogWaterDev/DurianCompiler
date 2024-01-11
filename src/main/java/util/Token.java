package util;

import java.util.ArrayList;

public class Token {
    public String value;
    public Token parent;
    public ArrayList<Token> children;
    public TokenTypes type;

    public Token(String value, Token parent, ArrayList<Token> children, TokenTypes type) {
        if (value != null) {
            this.value = value;
        }
        else {
            this.value = "";
        }
        this.parent = parent;
        this.children = children;
        this.type = type;

    }


    public ArrayList<Token> getChildren() {
        return this.children;
    }

}
