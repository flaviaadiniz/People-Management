package br.com.attornatus.peoplemanagement.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "people")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthDate;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    public Person() {

    }

    public Person(Long id, String name, LocalDate birthDate, List<Address> address) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.addresses = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Address> getAddress() {
        return addresses;
    }

    public void setAddress(Address address) {
        Address address1 = new Address();
        address1.setStreet(address.getStreet());
        address1.setPostalCode(address.getPostalCode());
        address1.setNumber(address.getNumber());
        address1.setCity(address.getCity());
        address1.setMain(address.isMain());
        this.addresses.add(address1);
    }

}
