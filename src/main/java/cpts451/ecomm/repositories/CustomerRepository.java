package cpts451.ecomm.repositories;

import cpts451.ecomm.entities.Customer;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
