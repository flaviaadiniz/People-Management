package br.com.attornatus.peoplemanagement.controller;

import br.com.attornatus.peoplemanagement.dto.AddressDTO;
import br.com.attornatus.peoplemanagement.model.Address;
import br.com.attornatus.peoplemanagement.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;

    @PostMapping()
    public AddressDTO save(@RequestBody AddressDTO addressDTO) {
        AddressDTO savedAddress = null;

        try {
            savedAddress = addressService.save(addressDTO);
        } catch (IllegalArgumentException exception) {
            System.out.println("Pessoa Já existe!");
        }

        return savedAddress;
    }

    @GetMapping("{id}")
    public Address findById(@PathVariable Long id) {
        //fazer logica para buscar so endereços da pessoa do ID passado
        return addressService.findById(id);
    }


    /*
    Criar método para verificar se o endereço é o principal
    @GetMapping()
    */

}
