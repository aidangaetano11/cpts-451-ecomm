package cpts451.ecomm.services;

import cpts451.ecomm.entities.Product;

public interface CreateProductService {

    public Product find(int id);

    public Iterable<Product> findAll();

    public Product save(Product product);
}
