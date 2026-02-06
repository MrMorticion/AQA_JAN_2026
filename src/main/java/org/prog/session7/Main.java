package org.prog.session7;

public class Main {
    public static void main(String[] args) {
        Boat boat = new Boat();
        boat.setColor("red");
        boat.setSerialNumber(null);
        boat.sail("London");
        System.out.println(boat.getColor());
        System.out.println(boat.printSnLength());
    }
}
