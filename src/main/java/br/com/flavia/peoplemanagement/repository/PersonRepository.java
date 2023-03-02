package br.com.flavia.peoplemanagement.repository;

import br.com.flavia.peoplemanagement.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
