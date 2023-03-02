package br.com.flavia.peoplemanagement.service;

import br.com.flavia.peoplemanagement.dto.AddressRequestDTO;
import br.com.flavia.peoplemanagement.dto.AddressResponseDTO;
import br.com.flavia.peoplemanagement.model.Address;
import br.com.flavia.peoplemanagement.model.Person;
import br.com.flavia.peoplemanagement.repository.AddressRepository;
import br.com.flavia.peoplemanagement.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;

    public AddressResponseDTO save(AddressRequestDTO addressRequestDTO) {

        Person targetPerson = personRepository
                .findById(addressRequestDTO.getPersonId()).orElseThrow(IllegalArgumentException::new);
        Address address = new Address();

        address.setPerson(targetPerson);
        address.setStreet(addressRequestDTO.getStreet());
        address.setNumber(addressRequestDTO.getNumber());
        address.setPostalCode(addressRequestDTO.getPostalCode());
        address.setCity(addressRequestDTO.getCity());
        address.setAddressType(addressRequestDTO.getAddressType());
        addressRepository.save(address);

        AddressResponseDTO addressResponseDTO = new AddressResponseDTO();
        addressResponseDTO.setAddressId(address.getId());
        addressResponseDTO.setPersonId(addressRequestDTO.getPersonId());
        addressResponseDTO.setStreet(address.getStreet());
        addressResponseDTO.setNumber(address.getNumber());
        addressResponseDTO.setPostalCode(address.getPostalCode());
        addressResponseDTO.setCity(address.getCity());
        addressResponseDTO.setAddressType(address.getAddressType());

        return addressResponseDTO;
    }

    public List<Address> findAll() {
        return (List<Address>) addressRepository.findAll();
    }

    public Address findById(Long id) {
        return addressRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Address editById(Long id, AddressRequestDTO addressRequestDTO) {
        Address updatedAddress = addressRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        updatedAddress.setStreet(addressRequestDTO.getStreet());
        updatedAddress.setNumber(addressRequestDTO.getNumber());
        updatedAddress.setPostalCode(addressRequestDTO.getPostalCode());
        updatedAddress.setCity(addressRequestDTO.getCity());
        updatedAddress.setAddressType(addressRequestDTO.getAddressType());
        return addressRepository.save(updatedAddress);
    }

    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }
}
