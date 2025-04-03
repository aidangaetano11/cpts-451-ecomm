package cpts451.ecomm.repositories;

import cpts451.ecomm.entities.Cart;
import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Integer> {
    @Query("SELECT c FROM Cart c WHERE c.customer = :customer")
    Cart findByCustomer(Customer customer);
}
