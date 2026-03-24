package org.prog.session6;

public class CarHw {
    public CarModelHw carModel;
    public CarOwnerHw carOwner;
    public CarTechSummaryHw techSummary;
    public CarDimensionsHw dimensions;
    public String milege;

    public void goTo(String destination) {
        System.out.println("Going to " + destination);
    }

    public void smth() {
        goTo("Home");
    }
}
