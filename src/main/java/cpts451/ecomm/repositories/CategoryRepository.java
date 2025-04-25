package cpts451.ecomm.repositories;

import cpts451.ecomm.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer>  {
}
