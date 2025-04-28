package cpts451.ecomm.repositories;

import cpts451.ecomm.entities.OrderItem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM OrderItem i WHERE i.product.productID = :productID")
    void deleteByProductId(int productID);
}