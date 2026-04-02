package org.prog.session10;

public abstract class Phone implements IPhone {

    public String model;
    public String color;

    public Phone(String model, String color) {
        this.model = model;
        this.color = color;
    }

    protected void validatePhoneData() {
        if (model == null || color == null) {
            throw new MyPhoneException("Model or color is null");
        }
    }
}