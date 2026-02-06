package org.prog.session6;

//TODO: add car plate number
//TODO: add method which will return owner name, model and plate number
//TODO: use String to store and print this in Main
//TODO: * - make array of trucks
public class Truck {

    public String model;
    public String name;

    public void setTruckInfo(String m, String n) {
        model = m;
        name = n;
    }

    public void delivery(String from, String to) {
        System.out.println("Delivering " + from + " to " + to + " by " + name);
    }
}
