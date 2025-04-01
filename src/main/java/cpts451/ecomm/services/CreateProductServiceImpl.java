package cpts451.ecomm.services;

import cpts451.ecomm.entities.Product;
import cpts451.ecomm.repositories.ProductRepository;

public class CreateProductServiceImpl implements CreateProductService {
    private ProductRepository productRepository;

    public CreateProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * finds product by id
     * @param id the id of the product we're looking for
     * @return the product if found, otherwise null
     */
    public Product find(int id) { return productRepository.findById(id).orElse(null); }

    /**
     * finds all products
     * @return a collection of products
     */
    public Iterable<Product> findAll() { return productRepository.findAll(); }

    /**
     * saves a product
     * @param product the product we're saving
     * @return the product we just saved
     */
    public Product save(Product product) { return productRepository.save(product); }
}
