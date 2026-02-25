package org.prog.session8;

public class Owner {

    public String firstName;
    public String lastName;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Owner) {
            Owner other = (Owner) obj;
            System.out.println("Owner that initiates equals name: " + this.firstName);
            System.out.println("Owner that initiates equals last name: " + this.lastName);
            return this.firstName.equals(other.firstName) &&
                    this.lastName.equals(other.lastName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        System.out.println("First Name hash: " + this.firstName.hashCode());
        System.out.println("Last Name hash: " + this.lastName.hashCode());
        System.out.println(this.firstName + this.lastName);
        System.out.println("First Name + Last Name hash: " + (this.firstName + this.lastName).hashCode());
        return (this.firstName + this.lastName).hashCode();
    }

    @Override
    public String toString(){
        return this.firstName + " " + this.lastName;
    }
}
