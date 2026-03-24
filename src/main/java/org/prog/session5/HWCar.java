package org.prog.session5;

public class HWCar {

    public String owner;
    public String color;
    public int mileage;
    public String plateNumber;

    public void goTo(String destination, int speed) {
        System.out.println("before trip miles: " + mileage);

        if ("black".equals(color)) {
            System.out.println("Black cars are cool");
        }

        mileage += speed *15;

        System.out.println("car owned by " + owner + " is going to " + destination +
                " at " + speed + " km/h");
        System.out.println("After trip miles: " + mileage);
    }
}
