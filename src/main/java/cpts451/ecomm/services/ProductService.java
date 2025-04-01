package cpts451.ecomm.services;

import cpts451.ecomm.entities.Product;

public interface ProductService {
    Product find(int id);

    Iterable<Product> findAll();

    Product save(Product product);
}
