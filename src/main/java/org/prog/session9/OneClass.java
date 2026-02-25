package org.prog.session9;

public class OneClass {

    public final static OneClass ONE_CLASS_INSTANCE = new OneClass();

    public String smth;

    private OneClass() {

    }

    public void someMethod() {
        System.out.println("some method");
    }
}
