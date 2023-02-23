package br.com.attornatus.peoplemanagement.controller;

import br.com.attornatus.peoplemanagement.dto.PersonRequestDTO;
import br.com.attornatus.peoplemanagement.dto.PersonResponseDTO;
import br.com.attornatus.peoplemanagement.model.Person;
import br.com.attornatus.peoplemanagement.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/people")
public class PersonController {

    private final PersonService personService;

    @PostMapping()
    public PersonResponseDTO save(@RequestBody PersonRequestDTO person) {
        Person savedPerson = personService.save(person);

        PersonResponseDTO personResponseDTO = new PersonResponseDTO();
        personResponseDTO.setId(savedPerson.getId());
        personResponseDTO.setName(savedPerson.getName());
        personResponseDTO.setBirthDate(savedPerson.getBirthDate());

        return personResponseDTO;
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

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        personService.deleteById(id);
    }

}