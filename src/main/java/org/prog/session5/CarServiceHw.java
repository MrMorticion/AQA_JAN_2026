package org.prog.session5;

public class CarServiceHW {

    public void paintCar(HWCar car, String color) {
        System.out.println("Received car to paint with color: " + car.color);
        System.out.println("New color " + color);
        car.color = color;
        car.goTo("Owner's home", 45);
    }

    public void addPayment(int amount) {
        amount = amount + 10;
        System.out.println("Charge user with " + amount);
    }
}
