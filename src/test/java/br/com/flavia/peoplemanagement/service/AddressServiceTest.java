package br.com.flavia.peoplemanagement.service;

import br.com.flavia.peoplemanagement.dto.AddressRequestDTO;
import br.com.flavia.peoplemanagement.model.Address;
import br.com.flavia.peoplemanagement.model.AddressType;
import br.com.flavia.peoplemanagement.model.Person;
import br.com.flavia.peoplemanagement.repository.AddressRepository;
import br.com.flavia.peoplemanagement.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;
    @Mock
    private PersonRepository personRepository;

    @Autowired
    @InjectMocks
    private AddressService addressService;

    private Address address1;
    private Address address2;
    private List<Address> addressList;
    private Person person1;
    private Person person2;
    private List<Person> personList;

    @BeforeEach
    public void setUp() {
        person1 = new Person(1L, "Flávia", LocalDate.of(1984, 5, 4), null);
        person2 = new Person(2L, "Marcela", LocalDate.of(1988, 9, 17), null);

        personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personRepository.save(person1);
        personRepository.save(person2);

        addressList = new ArrayList<>();
        address1 = new Address(1L,"Av. América", "90000100", 230, "Porto Alegre", AddressType.MAIN);
        address2 = new Address(2L, "Av. dos Estados", "90000300", 450, "Porto Alegre", AddressType.SECONDARY);

        addressList.add(address1);
        addressList.add(address2);
    }

    @Test
    void saveTest() {
        when(addressRepository.save(Mockito.any())).thenReturn(address1);
        when(personRepository.save(Mockito.any())).thenReturn(person1);

        personRepository.save(person1);
        addressRepository.save(address1);

        AddressRequestDTO addressRequestDTO = new AddressRequestDTO();
        addressRequestDTO.setStreet(address1.getStreet());
        addressRequestDTO.setPostalCode(address1.getPostalCode());
        addressRequestDTO.setNumber(address1.getNumber());
        addressRequestDTO.setCity(address1.getCity());
        addressRequestDTO.setAddressType(address1.getAddressType());
        addressRequestDTO.setPersonId(person1.getId());

        assertEquals(address1.getStreet(), addressRequestDTO.getStreet());
        assertEquals(address1.getCity(), addressRequestDTO.getCity());
    }


    @Test
    void findAllTest() {
        when(addressRepository.findAll()).thenReturn(addressList);
        List<Address> addresses = addressService.findAll();
        assertEquals(addresses.size(), 2);
    }


    @Test
    void findByIdTest() {
        when(addressRepository.findById(1L)).thenReturn(Optional.of(address1));
        Address address = addressService.findById(1L);

        assertEquals(address.getId(), address1.getId());
        assertEquals(address.getStreet(), address1.getStreet());
        assertEquals(address.getPostalCode(), address1.getPostalCode());
        assertEquals(address.getAddressType(), address1.getAddressType());
    }


    @Test
    void deleteByIdTest() {
        addressService.deleteById(2L);
        assertNull(address2.getId());
    }


}
