package cpts451.ecomm.repositories;

import cpts451.ecomm.entities.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Transactional
    @Modifying
    @Query("delete from Product t where t.productID = :productID")
    void deleteByProductId(Integer productID);
}
