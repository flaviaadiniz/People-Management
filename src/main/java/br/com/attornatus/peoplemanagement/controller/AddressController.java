package br.com.attornatus.peoplemanagement.controller;

import br.com.attornatus.peoplemanagement.model.Address;
import br.com.attornatus.peoplemanagement.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/persons")
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/{id}/addresses")
    public Address save(@RequestBody Address address, @PathVariable Long id) {
        return addressService.save(address);
    }

    @GetMapping("/{id}/addresses")
    public List<Address> list(@PathVariable Long id) {
        return addressService.list();
    }


    /*
    Criar método para verificar se o endereço é o principal
    @GetMapping()
    */


}
