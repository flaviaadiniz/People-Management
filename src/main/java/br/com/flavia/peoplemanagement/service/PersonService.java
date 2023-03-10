package br.com.flavia.peoplemanagement.service;

import br.com.flavia.peoplemanagement.dto.PersonRequestDTO;
import br.com.flavia.peoplemanagement.model.Person;
import br.com.flavia.peoplemanagement.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person save(PersonRequestDTO personRequestDTO) {
        Person newPerson = new Person();
        newPerson.setName(personRequestDTO.getName());
        newPerson.setBirthDate(personRequestDTO.getBirthDate());
        return personRepository.save(newPerson);
    }

    public List<Person> list() {
        return (List<Person>) personRepository.findAll();
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Person editById(Long id, PersonRequestDTO personRequestDTO) {
        Person targetPerson = personRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        targetPerson.setName(personRequestDTO.getName());
        targetPerson.setBirthDate(personRequestDTO.getBirthDate());
        return personRepository.save(targetPerson);
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}