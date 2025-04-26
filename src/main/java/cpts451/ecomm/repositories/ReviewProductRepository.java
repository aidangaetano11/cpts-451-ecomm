package cpts451.ecomm.repositories;

import cpts451.ecomm.entities.Cart;
import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.ReviewProduct;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReviewProductRepository extends CrudRepository<ReviewProduct, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM ReviewProduct r WHERE r.product.productID = :productID")
    void deleteByProductId(int productID);
}