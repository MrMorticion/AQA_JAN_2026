package org.prog.session5;

public class MainHw {

    public static void main(String[] args) {
        CarServiceHw carService = new CarServiceHw();

        CarHw myFirstCar = new CarHw();
        myFirstCar.owner = "Mykola";
        myFirstCar.plateNumber = "AA0000AA";

        CarHw aliceCar = new CarHw();
        aliceCar.owner = "Alice";

        CarHw bobsCar = new CarHw();
        bobsCar.owner = "Bob";

        CarHw otherCar = myFirstCar;

        int amountToPay = 10;

        carService.paintCar(myFirstCar, "blue");
        carService.addPayment(amountToPay);
        myFirstCar.goTo("Kyiv", 70);
        myFirstCar.goTo("Odessa", 100);

        System.out.println("After payment: " + amountToPay);

        carService.paintCar(aliceCar, "yellow");
        carService.paintCar(bobsCar, "black");

        otherCar.goTo("Kyiv", 45);
    }
}