package br.com.attornatus.peoplemanagement.model;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum AddressType {

    MAIN(1,"Main"),
    SECONDARY(2,"Secondary");

    private Integer code;
    private String addressType;

    public static AddressType valueOf(Integer code) {
        for(AddressType value : AddressType.values()) {
            if(value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
