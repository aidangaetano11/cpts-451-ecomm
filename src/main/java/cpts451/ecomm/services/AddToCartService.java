package cpts451.ecomm.services;

import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

public interface AddToCartService {
    void AddToCart(int customerID, int productID);

    boolean isProductInCart(Integer customerID, Integer productID);
}
