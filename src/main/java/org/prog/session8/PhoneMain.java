package org.prog.session8;

public class PhoneMain {

    public static void main(String[] args) {
        Apple apple1 = new Apple("iPhone 15", "black");
        Apple apple2 = new Apple("iPhone 15", "black");
        Android android1 = new Android("Samsung S24", "white");

        android1.call("Alice");
        android1.unlockScreen();
        System.out.println("====================");
        apple1.call("Bob");
        apple1.unlockScreen();
        System.out.println("====================");
        System.out.println(apple1.equals(apple2));
        System.out.println(apple1.hashCode());
        System.out.println(apple2.hashCode());
    }
}