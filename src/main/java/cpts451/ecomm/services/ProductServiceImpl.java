package cpts451.ecomm.services;

import cpts451.ecomm.entities.Product;
import cpts451.ecomm.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
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
}
