package br.com.attornatus.peoplemanagement.model;

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

}
