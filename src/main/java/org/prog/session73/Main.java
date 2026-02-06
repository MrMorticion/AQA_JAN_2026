package org.prog.session73;

public class Main {

    public static void main(String[] args) {
        Mazda mazda = new Mazda();
        Ford ford = new Ford();
        Mercedes mercedes = new Mercedes();

        drive(mazda);
        System.out.println("===============================");
        drive(ford);
        System.out.println("===============================");
        drive(mercedes);
        System.out.println("===============================");
        transportDrive(mercedes);
    }

    public static void drive(ICar car) {
        car.accelerate();
        car.turnRight();
        car.accelerate();
        car.accelerate();
        car.stop();
        car.turnLeft();
        car.accelerate();
    }

    public static void transportDrive(ITransport transport) {
        transport.pickUpPassengers();
        transport.turnLeft();
        transport.turnRight();
    }
}
