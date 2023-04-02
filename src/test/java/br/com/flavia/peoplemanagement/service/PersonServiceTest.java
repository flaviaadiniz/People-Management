package br.com.flavia.peoplemanagement.service;

import br.com.flavia.peoplemanagement.dto.PersonRequestDTO;
import br.com.flavia.peoplemanagement.model.Person;
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
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Autowired
    @InjectMocks
    private PersonService personService;
    private Person person1;
    private Person person2;
    private List<Person> personList;

    @BeforeEach
    public void setUp() {
        personList = new ArrayList<>();
        person1 = new Person(1L, "Flávia", LocalDate.of(1984, 5, 4), null);
        person2 = new Person(2L, "Marcela", LocalDate.of(1988, 9, 17), null);

        personList.add(person1);
        personList.add(person2);
    }

    @Test
    void saveTest() {
        when(personRepository.save(Mockito.any())).thenReturn(person2);

        PersonRequestDTO personRequestDTO = new PersonRequestDTO();
        personRequestDTO.setName(person2.getName());
        personRequestDTO.setBirthDate(person2.getBirthDate());

        Person person = personService.save(personRequestDTO);
        assertEquals(person.getName(), personRequestDTO.getName());
        assertEquals(person.getBirthDate(), personRequestDTO.getBirthDate());
    }

    @Test
    void listTest() {
        when(personRepository.findAll()).thenReturn(personList);
        List<Person> people = personService.list();
        assertEquals(people.size(), 2);
    }

    @Test
    void findByIdTest() {
        when(personRepository.findById(1L)).thenReturn(Optional.of(person1));
        Person person = personService.findById(1L);

        assertEquals(person.getId(), person1.getId());
        assertEquals(person.getName(), person1.getName());
        assertEquals(person.getBirthDate(), person1.getBirthDate());
        assertEquals(person.getAddresses(), person1.getAddresses());
    }


    @Test
    void deleteByIdTest() {
        personService.deleteById(2L);
        assertNull(person2.getId());
    }

}
