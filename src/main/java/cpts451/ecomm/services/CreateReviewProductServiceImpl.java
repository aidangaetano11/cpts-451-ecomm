package cpts451.ecomm.services;

import cpts451.ecomm.entities.ReviewProduct;
import cpts451.ecomm.services.ReviewProductService;
import cpts451.ecomm.exceptions.ExistingAttributeException;
import cpts451.ecomm.exceptions.MissingFieldException;
import cpts451.ecomm.repositories.ReviewProductRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class CreateReviewProductServiceImpl implements CreateReviewProductService {
    private final ReviewProductRepository reviewProductRepository;
    private final ReviewProductService reviewProductService;

    public CreateReviewProductServiceImpl(ReviewProductRepository reviewProductRepository, ReviewProductService reviewProductService) {
        this.reviewProductRepository = reviewProductRepository;
        this.reviewProductService = reviewProductService;
    }

    @Override
    public void CreateNewReviewProduct(ReviewProduct reviewProduct)
    {
        ValidateNullFields(reviewProduct);

        // check if review was already made by the customer
        ReviewProduct checkReviewProduct = reviewProductService.findByCustomerProductId(reviewProduct.getCustomer().getId(), reviewProduct.getProduct().getProductID());
        if (checkReviewProduct != null)
        {
            // delete old review to be replaced
            reviewProductRepository.deleteByCustomerProductId(reviewProduct.getCustomer().getId(), reviewProduct.getProduct().getProductID());
            reviewProduct.setComment("Updated " + LocalDate.now().toString() + ": " + reviewProduct.getComment());
        }

        reviewProductRepository.save(reviewProduct);
    }

    private void ValidateNullFields(ReviewProduct reviewProduct)
    {
        if (reviewProduct.getRating() == null || reviewProduct.getRating() < 0 || reviewProduct.getRating() > 5) {
            throw new MissingFieldException("Rating cannot be empty, less than 0, or over 5");
        }
    }
}
