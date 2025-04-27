package cpts451.ecomm.services;

import cpts451.ecomm.entities.ReviewProduct;

public interface ReviewProductService {
    ReviewProduct find(int id);

    Iterable<ReviewProduct> findAll();

    ReviewProduct save(ReviewProduct reviewProduct);

    void deleteById(Integer reviewId);

    void deleteByProductId(Integer productID);

    void deleteByCustomerProductId(Integer customerId, Integer productId);

    ReviewProduct findByCustomerProductId(Integer customerId, Integer productId);
}
