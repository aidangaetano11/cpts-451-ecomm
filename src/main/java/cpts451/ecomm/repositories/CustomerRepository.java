package cpts451.ecomm.repositories;

import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    //@Query("INSERT INTO Customer c VALUES ")
}
