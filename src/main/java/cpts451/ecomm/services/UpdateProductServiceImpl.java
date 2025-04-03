package cpts451.ecomm.services;

import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.Product;
import cpts451.ecomm.exceptions.ExistingAttributeException;
import cpts451.ecomm.exceptions.MissingFieldException;
import cpts451.ecomm.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductServiceImpl implements UpdateProductService {
    private ProductRepository productRepository;

    public UpdateProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void UpdateProduct(Product product)
    {
        ValidateNullFields(product);

        productRepository.save(product);
    }

    private void ValidateNullFields(Product newProduct)
    {
        if (newProduct.getProductName() == null || newProduct.getProductName().trim().isEmpty()) {
            throw new MissingFieldException("Product name is required");
        }

        if (newProduct.getProductDescription() == null || newProduct.getProductDescription().trim().isEmpty()) {
            throw new MissingFieldException("Product description is required");
        }

        if (newProduct.getProductPrice() == null || newProduct.getProductPrice() < 0.01) {
            throw new MissingFieldException("Product price cannot be empty or less than $0.01");
        }

        if (newProduct.getProductQuantity() == null || newProduct.getProductQuantity() < 0) {
            throw new MissingFieldException("Product quantity must be a positive integer");
        }
    }
}
