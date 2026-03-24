package org.prog.session5;

public class HWMain {
    public static void main(String[] args) {

        CarServiceHW carServiceHW = new CarServiceHW();

        HWCar myFirstHWCar = new HWCar();
        myFirstHWCar.plateNumber = "AGR777TR";
        myFirstHWCar.owner = "Alice";

        HWCar aliceCar = new HWCar();
        aliceCar.owner = "Alice";

        HWCar bobsCar = new HWCar();
        bobsCar.owner = "Bob";

        HWCar otherCar = myFirstHWCar;

        int amountToPay = 10;

        carServiceHW.paintCar(myFirstHWCar, "blue");
        carServiceHW.addPayment(amountToPay);

        myFirstHWCar.goTo("Kyiv", 70);
        myFirstHWCar.goTo("Odessa", 100);

        System.out.println("After payment: " + amountToPay);
    }
}

