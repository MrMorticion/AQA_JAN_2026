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
        System.out.println("Apple " + model + " screen is unlocked");
    }

    @Override
    public boolean equals(Object obj) {
        try {
            validatePhoneData();

            if (obj instanceof Apple) {
                Apple other = (Apple) obj;
                other.validatePhoneData();
                return this.model.equals(other.model) &&
                        this.color.equals(other.color);
            }
        } catch (MyPhoneException e) {
            System.out.println("oops!");
        }
        return false;
    }

    @Override
    public int hashCode() {
        try {
            validatePhoneData();
            return (this.model + this.color).hashCode();
        } catch (MyPhoneException e) {
            System.out.println("oops!");
            return 0;
        }
    }
}