package org.prog.session9;

import java.util.Random;

public class Car {

    public String color;
    public final String id;

    public Car() {
        Random rand = new Random();
        this.id = String.valueOf(rand.nextInt(10000));
    }

    public Car(String id) {
        this.id = id;
    }
}
