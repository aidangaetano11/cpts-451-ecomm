package cpts451.ecomm.repositories;

import cpts451.ecomm.entities.CartItem;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem, Integer> {
}
