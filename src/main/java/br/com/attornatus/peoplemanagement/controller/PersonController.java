package br.com.attornatus.peoplemanagement.controller;

import br.com.attornatus.peoplemanagement.dto.PersonRequestDTO;
import br.com.attornatus.peoplemanagement.model.Person;
import br.com.attornatus.peoplemanagement.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    @PostMapping()
    public Person save(@RequestBody PersonRequestDTO person) {
        Person savedPerson = null;

        try {
            savedPerson = personService.save(person);
        } catch (IllegalArgumentException exception) {
            System.out.println("Pessoa Já existe!");
        }

        return savedPerson;
    }


    @PutMapping("/{id}")
    public Person editById(@PathVariable Long id, @RequestBody PersonRequestDTO personRequestDTO) {
        return personService.editById(id, personRequestDTO);
    }


    @GetMapping()
    public List<Person> list() {
        return personService.list();
    }


    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id) {
        return personService.findById(id);
    }

}
