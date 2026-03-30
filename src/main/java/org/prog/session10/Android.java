package org.prog.session10;


public class Android extends Phone {

    public Android(String model, String color) {
        super(model, color);
    }

    @Override
    public void call(String someone) {
        System.out.println("Android " + model + " is calling " + someone);
    }

    @Override
    public void unlockScreen() {
        System.out.println("Android " + model + " screen unlocked");
    }
}
