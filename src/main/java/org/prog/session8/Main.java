package org.prog.session8;

//TODO: Create IPhone interface
//TODO: Each phone must be able to: void call(String someone);
//TODO: Each phone must be able to: void unlockScreen();
//TODO: Add at least 2 classes that implement phones: Android and Apple
//TODO: Both Apple and Android (or others) must implement IPhone
//TODO: Both Apple and Android must have model and color
//TODO: Add equals and hashcode for both
//TODO: * - Add abstract class Phone with constructor parameters model and color

public class Main {

    /**
     * ###################################
     * ###################################
     * ###################################
     * #######[o1@owner]##################
     * ###################################
     * ##[o2@owner]#######################
     * ###################################
     * ###################################
     * ===================================
     * #################10################
     *
     * @param args
     */

    public static void main(String[] args) {
        Car car = new Car();
        car.goTo("Odessa");
        System.out.println("===============================");
        car.goTo("Lviv", "Kyiv");
        System.out.println("===============================");
        car.goTo("Lviv", "Kyiv", "Dnipro");
        System.out.println("===============================");
        car.goTo("Lviv", "Kyiv", "Rovno", 1);

//        Object o = new Object();
//
//        int i = 10;
//        int j = 10;
//        System.out.println(i == j); // true
//
//        Owner johnDoe1 = new Owner();
//        Owner johnDoe2 = new Owner();
//        Owner janeDoe = new Owner();
//
//        johnDoe1.firstName = "John";
//        johnDoe1.lastName = "Doe";
//
//        johnDoe2.firstName = "John";
//        johnDoe2.lastName = "Doe";
//
//        System.out.println(johnDoe1.hashCode());
//        System.out.println(johnDoe2.hashCode());
//        System.out.println(johnDoe1.toString());

//

//
//        janeDoe.firstName = "Jane";
//        janeDoe.lastName = "Doe";
//
//        janeDoe.hashCode();

//        System.out.println(johnDoe1.equals(johnDoe2));
//
//        System.out.println(johnDoe1.equals(janeDoe));
//
//        System.out.println(janeDoe.equals(johnDoe1));
//
//        System.out.println(johnDoe1.hashCode());
//        System.out.println(johnDoe2.hashCode());
//
//        String s1 = "red";
//        String s2 = "red";
//
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.hashCode());
//        System.out.println(s2.hashCode());

//        Car car = new Car();
//        car.color = "red";
//        Plane plane = new Plane();
//        plane.color = "white";
//
//        car.goTo("somewhere");
    }
}
