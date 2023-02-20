package br.com.attornatus.peoplemanagement.service;

import br.com.attornatus.peoplemanagement.dto.PersonRequestDTO;
import br.com.attornatus.peoplemanagement.model.Person;
import br.com.attornatus.peoplemanagement.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final AddressService addressService;

    public Person save(PersonRequestDTO personDTO) {
        Person newPerson = new Person();
        newPerson.setName(personDTO.getName());
        newPerson.setBirthDate(personDTO.getBirthDate());
        newPerson.setAddress(personDTO.getAddress());
        return personRepository.save(newPerson);
    }

    public List<Person> list() {
        //criar validações
        return (List<Person>) personRepository.findAll();
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Person editById(Long id, PersonRequestDTO personDTO) {
        Person targetPerson = personRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        targetPerson.setName(personDTO.getName());
        targetPerson.setBirthDate(personDTO.getBirthDate());
        targetPerson.setAddress(personDTO.getAddress());
        return personRepository.save(targetPerson);
    }
}
