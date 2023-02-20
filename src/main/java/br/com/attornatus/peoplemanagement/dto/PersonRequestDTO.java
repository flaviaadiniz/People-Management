package br.com.attornatus.peoplemanagement.dto;

import br.com.attornatus.peoplemanagement.model.Address;

import java.time.LocalDate;

public class PersonRequestDTO {

    private String name;
    private LocalDate birthDate;
    private Address address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
