package org.prog.session72;

public class Car {

    public String color;
    protected String smth;

    public void driveWithAPassenger(String destination) {
        beep();
        System.out.println(color + " car is traveling with a passenger to " + destination);
    }

    private void beep() {
        System.out.println("Beep! Beep!");
    }
}
