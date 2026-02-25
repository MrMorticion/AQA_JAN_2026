package org.prog.session9;

public class Boat {

    public final String name;

    public Boat(String name) {
        this.name = name;
    }
}

// Boat => Yacht => Ship => CargoShip => Tanker
// new Boat -> Boat
// Yacht -> Boat => Yacht
// Tanker -> Boat => Yacht => Ship => CargoShip => Tanker