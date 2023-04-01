package br.com.flavia.peoplemanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    private Person person;
    private String street;
    private String postalCode;
    private Integer number;
    private String city;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    public Address() {

    }
    public Address(Long id, String street, String postalCode, Integer number, String city, AddressType addressType) {
        this.id = id;
        this.street = street;
        this.postalCode = postalCode;
        this.number = number;
        this.city = city;
        this.addressType = addressType;
    }
}
