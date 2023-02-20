package br.com.attornatus.peoplemanagement.controller;

import br.com.attornatus.peoplemanagement.model.Address;
import br.com.attornatus.peoplemanagement.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;
    private List<Address> addresses = new ArrayList<>();

    @PostMapping()
    public List<Address> save(@RequestBody Address address, @PathVariable String id) {
        addresses.add(address);
        return (List<Address>) addressService.save(address);
    }

    @GetMapping()
    public List<Address> list() {
        return addressService.list();
    }


    /*
    Criar método para verificar se o endereço é o principal
    @GetMapping()
    */


}
