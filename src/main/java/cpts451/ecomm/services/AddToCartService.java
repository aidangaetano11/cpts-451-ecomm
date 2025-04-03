package cpts451.ecomm.services;

import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.Product;
import org.springframework.stereotype.Service;

@Service
public interface AddToCartService {
    void AddToCart(int customerID, int productID);
}
