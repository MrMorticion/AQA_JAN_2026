package org.prog.session6;


public class TruckHw {

    public String model;
    public String name;
    public String plateNumber;

    public void setTruckInfo(String m, String n, String plate) {
        model = m;
        name = n;
        plateNumber = plate;
    }


    public String getTruckInfo() {
        return "Owner: " + name + ", Model: " + model + ", Plate: " + plateNumber;
    }

    public void delivery(String from, String to) {
        System.out.println("Delivering " + from + " to " + to + " by " + name);
    }
}
