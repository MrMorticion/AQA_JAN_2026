package org.prog.session6;

public class Car {
    public CarModel carModel;
    public CarOwner carOwner;
    public CarTechSummary techSummary;
    public CarDimensions dimensions;
    public String milege;

    public void goTo(String destination) {
        System.out.println("Going to " + destination);
    }

    public void smth() {
        goTo("Home");
    }
}
