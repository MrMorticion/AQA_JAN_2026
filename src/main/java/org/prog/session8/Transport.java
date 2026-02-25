package org.prog.session8;

public abstract class Transport {

    public String color;

    public abstract void turnLeft();

    public void goTo(String destination) {
        System.out.println("Going to " + destination);
    }
}
