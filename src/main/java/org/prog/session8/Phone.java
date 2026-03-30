package org.prog.session8;

public abstract class Phone implements IPhone {

    protected String model;
    protected String color;

    public Phone(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }
}
