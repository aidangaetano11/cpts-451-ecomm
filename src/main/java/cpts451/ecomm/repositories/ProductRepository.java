package cpts451.ecomm.repositories;

import cpts451.ecomm.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
