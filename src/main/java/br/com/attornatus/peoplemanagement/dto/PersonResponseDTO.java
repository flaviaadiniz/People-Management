package br.com.attornatus.peoplemanagement.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonResponseDTO {

    private Long id;
    private String name;
    private LocalDate birthDate;

}
