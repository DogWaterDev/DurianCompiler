package util.ast;

import util.TokenTypes;

public class Node {
    public String value;
    public Node parent;
    public Node[] children;
    public Node[] siblings;
    public TokenTypes type;
    public OperatorTypes op;
    public Node(String value, Node parent, Node[] children, Node[] siblings, TokenTypes type, OperatorTypes op) {
        this.value = value;
        this.parent = parent;
        this.children = children;
        this.siblings = siblings;
        this.type = type;
        this.op = op;
    }
}
