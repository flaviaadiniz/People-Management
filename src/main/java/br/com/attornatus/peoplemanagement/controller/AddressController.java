package br.com.attornatus.peoplemanagement.controller;

import br.com.attornatus.peoplemanagement.dto.AddressRequestDTO;
import br.com.attornatus.peoplemanagement.dto.AddressResponseDTO;
import br.com.attornatus.peoplemanagement.model.Address;
import br.com.attornatus.peoplemanagement.repository.AddressRepository;
import br.com.attornatus.peoplemanagement.repository.PersonRepository;
import br.com.attornatus.peoplemanagement.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;
    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;

    @PostMapping()
    public AddressResponseDTO save(@RequestBody AddressRequestDTO addressRequestDTO) {
        AddressResponseDTO savedAddress = null;

        try {
            savedAddress = addressService.save(addressRequestDTO);
        } catch (IllegalArgumentException exception) {
            System.out.println("Erro! Verifique os dados inseridos.");
        }

        return savedAddress;
    }

    @GetMapping("{id}")
    public Address findById(@PathVariable Long id) {
        return addressService.findById(id);
    }

    @PutMapping("/{id}")
    public Address editById(@PathVariable Long id, @RequestBody AddressRequestDTO addressRequestDTO) {
        return addressService.editById(id, addressRequestDTO);
    }

}
