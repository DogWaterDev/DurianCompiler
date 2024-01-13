package util.ast;

public class Declaration {

    public Declaration(String name, Type type, Expression value, Statement code, Declaration next) {
        this.name = name; // Name of the thing being declared
        this.type = type; // Its type
        this.value = value; // Its value
        this.code = code; // Code contained (functions only)
        this.next = next; // Next declaration
    }
    String name;
    Type type;
    Expression value;
    Statement code;
    Declaration next;
}
