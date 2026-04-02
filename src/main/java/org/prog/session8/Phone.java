package org.prog.session8;

public abstract class Phone implements IPhone {

    public String model;
    public String color;

    public Phone(String model, String color) {
        this.model = model;
        this.color = color;
    }
}