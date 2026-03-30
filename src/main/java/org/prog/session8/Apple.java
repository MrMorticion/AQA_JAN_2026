package org.prog.session8;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Apple) {
            Apple other = (Apple) obj;
            return this.model.equals(other.model) && this.color.equals(other.color);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (this.model + this.color).hashCode();
    }
}