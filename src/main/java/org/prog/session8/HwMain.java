package org.prog.session8;

public class HwMain {
    public static void main(String[] args) {
        Android android1 = new Android("Samsung S24", "Black");
        Android android2 = new Android("Samsung S24", "Black");
        Android android3 = new Android("Samsung A55", "Blue");
        Apple apple1 = new Apple("iPhone 15", "White");

        android1.call("Alice");
        android1.unlockScreen();
        apple1.call("Bob");
        apple1.unlockScreen();

        System.out.println("android1 equals android2: " + android1.equals(android2));
        System.out.println("android1 hash == android2 hash: " + (android1.hashCode() == android2.hashCode()));
        System.out.println("android1 equals android3: " + android1.equals(android3));

        Apple apple2 = new Apple("iPhone 15", "White");
        System.out.println("apple1 equals apple2: " + apple1.equals(apple2));
        System.out.println("apple1 hash == apple2 hash: " + (apple1.hashCode() == apple2.hashCode()));
    }
}
