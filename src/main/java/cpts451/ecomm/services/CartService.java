package cpts451.ecomm.services;

import cpts451.ecomm.entities.Cart;
import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.Product;

public interface CartService {
    Cart getOrCreateCart(Customer customer);

    void addToCart(Customer customer, Product product, int quantity);

    void removeFromCart(Customer customer, int productId);

    double getTotalPrice(Customer customer);

    void emptyCart(Customer customer);
}
