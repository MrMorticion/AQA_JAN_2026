package org.prog.collections.session11;

public class Owner {

    public String firstName;
    public String lastName;

    public Owner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Owner) {
            Owner other = (Owner) obj;
            return this.firstName.equals(other.firstName) &&
                    this.lastName.equals(other.lastName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (this.firstName + this.lastName).hashCode();
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
