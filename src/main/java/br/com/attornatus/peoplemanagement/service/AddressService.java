package br.com.attornatus.peoplemanagement.service;

import br.com.attornatus.peoplemanagement.dto.AddressDTO;
import br.com.attornatus.peoplemanagement.model.Address;
import br.com.attornatus.peoplemanagement.model.Person;
import br.com.attornatus.peoplemanagement.repository.AddressRepository;
import br.com.attornatus.peoplemanagement.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;

    public AddressDTO save(AddressDTO addressDTO) {

        Person targetPerson = personRepository
                .findById(addressDTO.getPersonId()).orElseThrow(IllegalArgumentException::new);
        Address address = new Address();

        address.setPerson(targetPerson);
        address.setStreet(addressDTO.getStreet());
        address.setNumber(addressDTO.getNumber());
        address.setPostalCode(addressDTO.getPostalCode());
        address.setCity(addressDTO.getCity());
        address.setAddressType(addressDTO.getAddressType());
        addressRepository.save(address);

        return addressDTO;
    }

    public Address findById(Long id) {
        return addressRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

}
