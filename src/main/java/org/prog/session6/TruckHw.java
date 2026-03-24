package org.prog.session6;

public class TruckHw {

    public String model;
    public String name;
    public String plateNumber;

    public void setTruckInfo(String m, String n) {
        model = m;
        name = n;
    }

    public String getInfo() {
        return "owner: " + name + ", model: " + model + ", plate: " + plateNumber;
    }

    public void delivery(String from, String to) {
        System.out.println("Delivering " + from + " to " + to + " by " + name);
    }
}
