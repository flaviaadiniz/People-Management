package br.com.flavia.peoplemanagement.controller;

import br.com.flavia.peoplemanagement.dto.PersonRequestDTO;
import br.com.flavia.peoplemanagement.dto.PersonResponseDTO;
import br.com.flavia.peoplemanagement.model.Person;
import br.com.flavia.peoplemanagement.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/people")
public class PersonController {

    private final PersonService personService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PersonResponseDTO save(@RequestBody PersonRequestDTO personRequestDTO) {
        Person savedPerson = personService.save(personRequestDTO);

        PersonResponseDTO personResponseDTO = new PersonResponseDTO();
        personResponseDTO.setId(savedPerson.getId());
        personResponseDTO.setName(savedPerson.getName());
        personResponseDTO.setBirthDate(savedPerson.getBirthDate());

        return personResponseDTO;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        personService.deleteById(id);
    }

}