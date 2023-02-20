package br.com.attornatus.peoplemanagement.repository;

import br.com.attornatus.peoplemanagement.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
