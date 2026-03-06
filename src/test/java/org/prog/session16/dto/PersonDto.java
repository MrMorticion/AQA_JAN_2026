package org.prog.session16.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PersonDto {
    private String gender;
    private String nat;
    private NameDto name;
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getNat() {
//        return nat;
//    }
//
//    public void setNat(String nat) {
//        this.nat = nat;
//    }
//
//    public NameDto getName() {
//        return name;
//    }
//
//    public void setName(NameDto name) {
//        this.name = name;
//    }
}
