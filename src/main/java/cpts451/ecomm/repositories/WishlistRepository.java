package cpts451.ecomm.repositories;

import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.Wishlist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WishlistRepository extends CrudRepository {
    @Query("SELECT w FROM Wishlist w WHERE w.customer = :customer")
    Wishlist findByCustomer(Customer customer);
}
