package br.com.attornatus.peoplemanagement.dto;

import lombok.Data;

@Data
public class AddressDTO {

    private Long personId;
    private String street;
    private String postalCode;
    private Integer number;
    private String city;
    private boolean main;

}
