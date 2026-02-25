package org.prog.collections.session12;

import java.util.*;

//TODO: Write Map that will allow multiple different people to own several unique phones each
//TODO: * - I should be able to find phones for new Owner("Name_Of_Owner");
//TODO: Map<...> phoneOwners = new HashMap<>();
//TODO: phoneOwners.put(owner1, ...);
//TODO: phoneOwners.put(owner2, ...);
//TODO: phoneOwners.put(owner3, ...);
//TODO: phoneOwners.get(new PhoneOwner("ownerName")) -> {}

public class Main {

    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        map.put("key_1", "value_1");
//        System.out.println(map.get("key_1"));
//        map.put("key_2", "value_2");
//        map.put("key_1", "value_3");
//        System.out.println(map.get("key_1"));
//        System.out.println(map.get("key_2"));
//
//        Car commonCar = new Car();
//        Map<Owner, Car> carOwners = new HashMap<>();
//        Owner ben = new Owner();
//        Owner alice =  new Owner();
//        ben.name = "Ben";
//        alice.name = "Alice";
//
//        carOwners.put(ben,commonCar);
//        carOwners.put(alice, commonCar);

//        Map<String,UserData> users = new HashMap<>();
//        users.put("testUser1", new UserData());
//        users.put("testUser2", new UserData());
//        users.put("testUser3", new UserData());
//        users.put("testUser4", new UserData());

//        Car commonCar = new Car();
//        Map<Owner, Car> carOwners = new HashMap<>();
//        Map<Car, Owner> ownedCars = new HashMap<>();
//        Car car1 = new Car();
//        Car car2 = new Car();
//        Car car3 = new Car();
//
//
//        Owner ben = new Owner();
//        Owner alice =  new Owner();
//        ben.name = "Ben";
//        alice.name = "Alice";
//
//        carOwners.put(ben, commonCar);
//        carOwners.put(alice, commonCar);
//
//        ownedCars.put(car1, ben);
//        ownedCars.put(car2, ben);
//        ownedCars.put(car3, ben);

//        List<String> userData1 = List.of("John", "Doe", "05.05.1990");
//        List<String> userData2 = List.of("Jane", "Doe", "02.02.1992");
//        List<String> userData3 = List.of("John", "Doe", "05.06.1990");
//
//        Map<List<String>, Car> carsAndOwners = new HashMap<>();
//        carsAndOwners.put(userData1, new Car());
//        carsAndOwners.put(userData2, new Car());
//        carsAndOwners.put(userData3, new Car());
//
//        System.out.println(carsAndOwners.size());
//        carsAndOwners.get(userData1).color = "red";
//        carsAndOwners.get(userData2).color = "blue";
//        carsAndOwners.get(userData3).color = "green";
//        System.out.println(carsAndOwners.size());

//        Map<String,String> map = new HashMap<>();
//        map.put("key_1", "value_1");
//        map.putIfAbsent("key_1", "value_2");
//        map.putIfAbsent("key_2", "value_2");
//        map.putIfAbsent("key_3", "value_3");
//        System.out.println(map.get("key_1"));
//        System.out.println(map.containsKey("key_1"));
//        System.out.println(map.containsValue("value_2"));
//        Set<Map.Entry<String, String>> entries = map.entrySet();
//        System.out.println(entries.size());
//        for (Map.Entry<String, String> entry : entries) {
//            System.out.println("KEY: " + entry.getKey() + " VALUE: " + entry.getValue());
//        }
//        System.out.println(map.get("key_4"));
//
//        System.out.println(map.getOrDefault("key_4", "default value"));

        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();

        map1.put("key1", "value1.1");
        map1.put("key2", "value1.2");

        map2.put("key1", "value2.1");
        map2.put("key2", "value2.2");
        map2.put("key3", "value2.3");

//        map2.putAll(map1);
        System.out.println(map2);
        map1.remove("key1");

        map2.remove("key2");
        map2.remove("key3", "value3.3");
        System.out.println(map1);
        System.out.println(map2);

        map1.replace("key2", "new_value1.2");
        map2.replace("key2", "new_value2.2");
        System.out.println(map1);
        System.out.println(map2);
    }
}