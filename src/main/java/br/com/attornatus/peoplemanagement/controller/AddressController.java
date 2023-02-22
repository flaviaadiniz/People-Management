package br.com.attornatus.peoplemanagement.controller;

import br.com.attornatus.peoplemanagement.dto.AddressRequestDTO;
import br.com.attornatus.peoplemanagement.model.Address;
import br.com.attornatus.peoplemanagement.model.Person;
import br.com.attornatus.peoplemanagement.repository.PersonRepository;
import br.com.attornatus.peoplemanagement.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;
    private final PersonRepository personRepository;

    @PostMapping()
    public Address save(@RequestBody AddressRequestDTO addressDTO) {

        Person targetPerson = personRepository
                .findById(addressDTO.getPersonId()).orElseThrow(IllegalArgumentException::new);
        Address address = new Address();

        address.setPerson(targetPerson);
        address.setStreet(addressDTO.getStreet());
        address.setNumber(addressDTO.getNumber());
        address.setPostalCode(addressDTO.getPostalCode());
        address.setCity(addressDTO.getCity());
        address.setMain(addressDTO.isMain());

        return addressService.save(address);

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
