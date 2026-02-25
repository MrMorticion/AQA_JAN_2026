package org.prog.session8;

public class Car {

    public void goTo(String destination) {
        goTo(destination, "Kyiv");
    }

    public void goTo(String destination, String from) {
        goTo(destination, from, "Nowhere");
    }

    public void goTo(String destination, String from, String through) {
        goTo(destination, from, through, 0);
    }

    public void goTo(String destination, String from, String through, int passengers) {
        System.out.println("Destination: " + destination);
        System.out.println("From: " + from);
        System.out.println("Through: " + through);
        System.out.println("Passengers: " + passengers);
    }
}
