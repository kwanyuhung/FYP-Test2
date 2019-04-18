package example.ybdesire.com.javacompiler.Adapter;

public enum  Note_Enum {
    test(0),
    image(1);

    private int type;

    Note_Enum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
