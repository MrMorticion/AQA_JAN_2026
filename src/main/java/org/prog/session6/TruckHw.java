package org.prog.session6;

// Реализация всех TODO заданий
public class TruckHw {

    public String model;
    public String name;
    public String plateNumber;  // TODO 1: добавить номер (plate number)

    public void setTruckInfo(String m, String n, String plate) {
        model = m;
        name = n;
        plateNumber = plate;
    }

    // TODO 2: добавить метод который вернёт owner name, model и plate number
    public String getTruckInfo() {
        return "Owner: " + name + ", Model: " + model + ", Plate: " + plateNumber;
    }

    public void delivery(String from, String to) {
        System.out.println("Delivering " + from + " to " + to + " by " + name);
    }
}
