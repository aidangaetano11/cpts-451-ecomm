package cpts451.ecomm.repositories;

import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.CustomerOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<CustomerOrder, Integer> {

    @Query("SELECT o FROM CustomerOrder o WHERE o.customer = :customer")
    List<CustomerOrder> findByCustomer(Customer customer);

}
