package org.prog.session73;

public class Ford implements ICar {
    @Override
    public void turnRight() {
        System.out.println("Ford turnRight!");
    }

    @Override
    public void turnLeft() {
        System.out.printf("Ford turnLeft!");
    }

    @Override
    public void stop() {
        System.out.println("Ford stop!");
    }

    @Override
    public void accelerate() {
        System.out.println("Ford accelerate!");
    }
}
