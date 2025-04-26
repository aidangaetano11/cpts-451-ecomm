package cpts451.ecomm.services;

import cpts451.ecomm.entities.Product;

public interface UpdateProductService {

    public void UpdateProduct(Product product, String productName, String productDescription, double productPrice, int productQuantity);
}
