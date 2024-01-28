package util.ast;

public class Declaration {

    public Declaration(String name, Type type, Expression value, Statement code, Declaration next) {
        this.name = name; // Name of the thing being declared
        this.type = type; // Its type
        this.value = value; // Its value
        this.code = code; // Code contained (functions only)
        this.next = next; // Next declaration
    }

    /**
     * <code>name</code> variable contains a <code>String</code> with the name of the declared object
     * <p>The declared object can be of any type (function, variable, etc.) as long as it is declarable</p>
     */
    String name;
    /**
     * <code>type</code> statement contains the type of declaration.
     * <p>It has the possible types contained within <code>Type</code> class</p>
     * @see Type
     */
    Type type;
    /**
     * <code>value</code> variable is for variable declarations.</p>
     */
    Expression value;
    /**
     * <code>code</code> variable is for functions only. It contains all the code within the function.
     * <p><code>code</code> is of type <code>Statement</code>, so read those javadocs for explanation.</p>
     */
    Statement code;
    /**
     * <code>next</code> variable points to the next declaration within the code.
     */
    Declaration next;
}
