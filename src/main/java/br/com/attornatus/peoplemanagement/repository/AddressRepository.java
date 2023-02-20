package br.com.attornatus.peoplemanagement.repository;

import br.com.attornatus.peoplemanagement.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
