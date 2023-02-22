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
        address.setMain(addressDTO.isMain());
        addressRepository.save(address);

        return addressDTO;
    }

    public Address findById(Long id) {
        return addressRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }


    /*public void editByPersonId(Long id) {
        //pegar o ID da pessoa e colocar no endereço
        Person person = personRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        Address address = person.getAddress().get(0);
        address.setPerson(person.getId());
        addressRepository.save(person.getAddress().get(0));
        Address address = addressRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }*/

    //incluir método para verificar se o endereço é o principal

}
