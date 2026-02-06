package org.prog.session73;

public class Mazda implements ICar {
    @Override
    public void turnRight() {
        System.out.println("Mazda turn right!");
    }

    @Override
    public void turnLeft() {
        System.out.println("Mazda turn left!");
    }

    @Override
    public void stop() {
        System.out.println("Mazda stop!");
    }

    @Override
    public void accelerate() {
        System.out.println("Mazda accelerate!");
    }
}
