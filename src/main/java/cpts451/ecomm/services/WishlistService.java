package cpts451.ecomm.services;

import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.Product;
import cpts451.ecomm.entities.Wishlist;

public interface WishlistService {
    Wishlist getOrCreateWishlist(Customer customer);

    void addToWishlist(Customer customer, Product product);

    void removeFromWishlist(Customer customer, int productId);
}
