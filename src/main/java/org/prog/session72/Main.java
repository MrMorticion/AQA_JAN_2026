package org.prog.session72;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Crossover crossover = new Crossover();
        Van van = new Van();
        Truck truck = new Truck();

        car.color = "red";
        car.driveWithAPassenger("Karpaty");

        crossover.color = "blue";
        crossover.driveWithAPassenger("Karpaty");
        crossover.attachBicycle();
        crossover.smth = "smth";

        van.color = "green";
        van.driveWithAPassenger("Karpaty");
        van.attachBicycle();
        van.transportLuggage();

        truck.color = "black";
        truck.driveWithAPassenger("Karpaty");
        truck.travelWithCargo("Karpaty");

    }
}
