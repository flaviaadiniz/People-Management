package br.com.attornatus.peoplemanagement.dto;

import br.com.attornatus.peoplemanagement.model.AddressType;
import lombok.Data;

@Data
public class AddressResponseDTO {

    private Long addressId;
    private Long personId;
    private String street;
    private String postalCode;
    private Integer number;
    private String city;
    private AddressType addressType;

}
