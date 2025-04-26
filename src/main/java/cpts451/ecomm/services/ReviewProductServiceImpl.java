package cpts451.ecomm.services;

import cpts451.ecomm.entities.ReviewProduct;
import cpts451.ecomm.repositories.ReviewProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewProductServiceImpl implements ReviewProductService {
    private final ReviewProductRepository reviewProductRepository;

    public ReviewProductServiceImpl(ReviewProductRepository reviewProductRepository) {
        this.reviewProductRepository = reviewProductRepository;
    }

    /**
     * finds product review by id.
     * @param id the product review id.
     * @return product review if matching id. null otherwise.
     */
    @Override
    public ReviewProduct find(int id) { return reviewProductRepository.findById(id).orElse(null); }

    /**
     * finds all products reviews.
     * @return a collection of products reviews.
     */
    @Override
    public Iterable<ReviewProduct> findAll() { return reviewProductRepository.findAll(); }

    /**
     * saves product review to product review repository.
     * @param reviewProduct product review to save.
     * @return the product review we just saved.
     */
    @Override
    public ReviewProduct save(ReviewProduct reviewProduct) { return reviewProductRepository.save(reviewProduct); }

    /**
     * deletes product review from product review repository using id.
     * @param reviewProductID id of product review to delete.
     */
    @Override
    public void deleteById(Integer reviewProductID) { reviewProductRepository.deleteById(reviewProductID); }

    @Override
    public void deleteByProductId(Integer productID) {
        reviewProductRepository.deleteByProductId(productID);
    }
}
