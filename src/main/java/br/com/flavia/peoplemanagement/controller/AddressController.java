package br.com.flavia.peoplemanagement.controller;

import br.com.flavia.peoplemanagement.dto.AddressRequestDTO;
import br.com.flavia.peoplemanagement.dto.AddressResponseDTO;
import br.com.flavia.peoplemanagement.model.Address;
import br.com.flavia.peoplemanagement.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AddressResponseDTO save(@RequestBody AddressRequestDTO addressRequestDTO) {
        AddressResponseDTO savedAddress = null;

        try {
            savedAddress = addressService.save(addressRequestDTO);
        } catch (IllegalArgumentException exception) {
            System.out.println("Erro! Verifique os dados inseridos.");
        }

        return savedAddress;
    }

    @GetMapping()
    public List<Address> findAll() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable Long id) {
        return addressService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Address editById(@PathVariable Long id, @RequestBody AddressRequestDTO addressRequestDTO) {
        return addressService.editById(id, addressRequestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        addressService.deleteById(id);
    }

}
