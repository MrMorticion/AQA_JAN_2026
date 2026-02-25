package org.prog.session9;


public class Main {

    public final static String VALUE = "VALUE";

    public static final Car CAR = new Car();
    public static final Car[] cars = new Car[10];

    public static void main(String[] args) {
//        OneClass.ONE_CLASS_INSTANCE.someMethod();
//        OneClass.ONE_CLASS_INSTANCE.smth = "abcdefg";
//        System.out.println(OneClass.ONE_CLASS_INSTANCE.smth);

//        Car c1 = new Car("00002");
//        System.out.println(c1.id);
//        Car c2 = new Car("00003");
//        System.out.println(c2.id);
//        System.out.println(CAR.id);
//
        Tanker t = new Tanker("Test");
        System.out.println(t.name);

        Car car = new Car();
        System.out.println(car.color.length());
        System.out.println("===============================");
//
//        Truck truck = new Truck("123123");
//        Truck truck2 = new Truck();
//
//        System.out.println(truck.id);
//        System.out.println(truck2.id);
//        VALUE = "a";
//        final String s = "s";
//        s = "b";
//        CAR.color = "red";
//        CAR.color = "blue";
//        cars[0] = new Car();
//        cars[0].color = "red";
//        cars[0].color = "blue";
//        cars[0] = null;
    }
}
