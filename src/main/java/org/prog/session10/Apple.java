package org.prog.session10;

public class Apple extends Phone {

    public Apple(String model, String color) {
        super(model, color);
    }

    @Override
    public void call(String someone) {
        System.out.println("Apple " + model + " is calling " + someone);
    }

    @Override
    public void unlockScreen() {
        System.out.println("Apple " + model + " screen unlocked");
    }
}
