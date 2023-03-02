package br.com.flavia.peoplemanagement.dto;

import br.com.flavia.peoplemanagement.model.AddressType;
import lombok.Data;

@Data
public class AddressRequestDTO {

    private Long personId;
    private String street;
    private String postalCode;
    private Integer number;
    private String city;
    private AddressType addressType;

}
