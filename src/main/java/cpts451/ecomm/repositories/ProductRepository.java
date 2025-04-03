package cpts451.ecomm.repositories;

import cpts451.ecomm.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Query("SELECT p FROM Product p JOIN p.productsInCart c WHERE c.userId = :customerID")
    List<Product> findProductByCustomerID(@Param("customerID") Integer customerID);
}
