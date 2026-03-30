package org.prog.session10;

public abstract class Phone implements IPhone {

    protected final String model;
    protected final String color;

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

    @Override
    public boolean equals(Object obj) {
        try {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Phone other = (Phone) obj;
            if (this.model == null || this.color == null || other.model == null || other.color == null) {
                throw new MyPhoneException("Model or color is null");
            }

            return this.model.equals(other.model) && this.color.equals(other.color);
        } catch (MyPhoneException e) {
            System.out.println("oops!");
            return false;
        }
    }

    @Override
    public int hashCode() {
        try {
            if (this.model == null || this.color == null) {
                throw new MyPhoneException("Model or color is null");
            }
            return (this.model + this.color).hashCode();
        } catch (MyPhoneException e) {
            System.out.println("oops!");
            return 0;
        }
    }
}
