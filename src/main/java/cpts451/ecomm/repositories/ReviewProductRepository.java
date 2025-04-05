package cpts451.ecomm.repositories;

import cpts451.ecomm.entities.ReviewProduct;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewProductRepository extends CrudRepository<ReviewProduct, Integer> {
}