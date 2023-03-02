package br.com.flavia.peoplemanagement.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonRequestDTO {

    private String name;
    private LocalDate birthDate;

}
