package util.ast;

public class Type {
    public enum VarType {
        TYPE_VOID,
        TYPE_BOOLEAN,
        TYPE_CHARACTER,
        TYPE_INTEGER,
        TYPE_STRING,
        TYPE_ARRAY,
        TYPE_FUNCTION,
        TYPE_CLASS,
        TYPE_LOOP,
        TYPE_IF_ELSE,
    }
    public static class ParamList {
        String name;
        Type type;
        ParamList next;
        public ParamList(String name, Type type, ParamList next) {
            this.name = name;
            this.type = type;
            this.next = next;
        }
    }
    VarType kind;
    Type subType;
    ParamList params;
    public Type(VarType kind, Type subType, ParamList params) {
        this.kind = kind;
        this.subType = subType;
        this.params = params;
    }
}
