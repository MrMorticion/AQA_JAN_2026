package org.prog.session8;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Android) {
            Android other = (Android) obj;
            return this.model.equals(other.model) && this.color.equals(other.color);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (this.model + this.color).hashCode();
    }
}
