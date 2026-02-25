package org.prog.session73;

public class Mercedes implements ICar, ITransport {
    @Override
    public void turnRight() {
        System.out.println("Mercedes turnRight");
    }

    @Override
    public void turnLeft() {
        System.out.println("Mercedes turnLeft");
    }

    @Override
    public void pickUpPassengers() {
        System.out.println("Mercedes pickUpPassengers");
    }

    @Override
    public final void stop() {
        System.out.println("Mercedes stop");
    }

    @Override
    public void accelerate() {
        System.out.println("Mercedes accelerate");
    }
}
