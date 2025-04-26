package cpts451.ecomm.repositories;

import cpts451.ecomm.entities.WishlistItem;
import org.springframework.data.repository.CrudRepository;

public interface WishlistItemRepository extends CrudRepository<WishlistItem, Integer> {
}
