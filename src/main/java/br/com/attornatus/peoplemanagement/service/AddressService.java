package br.com.attornatus.peoplemanagement.service;

import br.com.attornatus.peoplemanagement.model.Address;
import br.com.attornatus.peoplemanagement.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public Address save(Address address) {
        return addressRepository.save(address);
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