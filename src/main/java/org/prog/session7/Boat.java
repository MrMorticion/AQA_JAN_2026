package org.prog.session7;

public class Boat {
    private String color;
    private String name;
    private String id;
    private String serialNumber;

    public void setColor(String color) {
        if (color != null) {
            this.color = color;
        } else {
            this.color = "undefined";
        }
    }

    public String getColor() {
        return this.color;
    }

    public void setSerialNumber(String serialNumber) {
        if (serialNumber != null) {
            this.serialNumber = serialNumber;
        } else {
            this.serialNumber = "undefined";
        }
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void sail(String destination) {
        System.out.println("Sailing to " + destination);
    }

    public int getSNL() {
        if (serialNumber != null) {
            return printSnLength();
        }
        return 0;
    }

    public int printSnLength() {
        return serialNumber.length();
    }
}
