package cpts451.ecomm.services;

import cpts451.ecomm.entities.ReviewProduct;
import cpts451.ecomm.exceptions.ExistingAttributeException;
import cpts451.ecomm.exceptions.MissingFieldException;
import cpts451.ecomm.repositories.ReviewProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateReviewProductServiceImpl implements CreateReviewProductService {
    private final ReviewProductRepository reviewProductRepository;

    public CreateReviewProductServiceImpl(ReviewProductRepository reviewProductRepository) {
        this.reviewProductRepository = reviewProductRepository;
    }

    @Override
    public void CreateNewReviewProduct(ReviewProduct reviewProduct)
    {
        ValidateNullFields(reviewProduct);

        reviewProductRepository.save(reviewProduct);
    }

    private void ValidateNullFields(ReviewProduct reviewProduct)
    {
        if (reviewProduct.getRating() == null || reviewProduct.getRating() < 0 || reviewProduct.getRating() > 5) {
            throw new MissingFieldException("Rating cannot be empty, less than 0, or over 5");
        }
    }
}
