package org.prog.session6;

public class MainHw {

    public static void main(String[] args) {
        
        // TODO 3: использовать String для сохранения и вывода информации
        TruckHw truck1 = new TruckHw();
        truck1.setTruckInfo("Volvo", "Vasya", "AA-123-BB");
        truck1.delivery("Lviv", "Kyiv");
        
        String truckInfo1 = truck1.getTruckInfo();
        System.out.println(truckInfo1);
        System.out.println();

        // TODO 4: создать массив грузовиков
        TruckHw[] trucks = new TruckHw[3];
        
        trucks[0] = new TruckHw();
        trucks[0].setTruckInfo("Volvo", "Vasya", "AA-123-BB");
        
        trucks[1] = new TruckHw();
        trucks[1].setTruckInfo("MAN", "Petya", "BB-456-CC");
        
        trucks[2] = new TruckHw();
        trucks[2].setTruckInfo("Scania", "Misha", "CC-789-DD");
        
        // Вывод информации всех грузовиков
        System.out.println("=== Все грузовики ===");
        for (int i = 0; i < trucks.length; i++) {
            System.out.println((i + 1) + ". " + trucks[i].getTruckInfo());
            trucks[i].delivery("Odessa", "Kharkiv");
            System.out.println();
        }
    }
}
