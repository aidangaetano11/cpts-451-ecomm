package cpts451.ecomm.services;

import cpts451.ecomm.entities.Product;
import cpts451.ecomm.repositories.OrderItemRepository;
import cpts451.ecomm.repositories.ProductRepository;
import cpts451.ecomm.repositories.ReviewProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ReviewProductRepository reviewProductRepository;
    private final OrderItemRepository orderItemRepository;

    public ProductServiceImpl(ProductRepository productRepository, ReviewProductRepository reviewProductRepository, OrderItemRepository orderItemRepository) {
        this.productRepository = productRepository;
        this.reviewProductRepository = reviewProductRepository;
        this.orderItemRepository = orderItemRepository;
    }

    /**
     * finds product by id.
     * @param id the product id.
     * @return product if matching id. null otherwise.
     */
    @Override
    public Product find(int id) { return productRepository.findById(id).orElse(null); }

    /**
     * finds all products.
     * @return a collection of products.
     */
    @Override
    public Iterable<Product> findAll() { return productRepository.findAll(); }

    /**
     * saves product to product repository.
     * @param product product to save.
     * @return the product we just saved.
     */
    @Override
    public Product save(Product product) { return productRepository.save(product); }

    /**
     * deletes product from product repository using id.
     * @param productID id of product to delete.
     */
    @Override
    public void deleteById(Integer productID) {
        reviewProductRepository.deleteByProductId(productID);
        orderItemRepository.deleteByProductId(productID);
        productRepository.deleteByProductId(productID);
    }

}
