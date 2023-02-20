package br.com.attornatus.peoplemanagement.service;

import br.com.attornatus.peoplemanagement.model.Address;
import br.com.attornatus.peoplemanagement.repository.AddressRepository;
import br.com.attornatus.peoplemanagement.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;
    private List<Address> addresses = new ArrayList<>();

    public Address save(Address address) {
        addresses.add(address);
        return addressRepository.save(address);
    }

    public List<Address> list() {
        return (List<Address>) addressRepository.findAll();
    }

    //incluir método para verificar se o endereço é o principal

}
