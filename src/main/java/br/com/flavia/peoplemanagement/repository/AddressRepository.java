package br.com.flavia.peoplemanagement.repository;

import br.com.flavia.peoplemanagement.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
