package cpts451.ecomm.entities;

import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Customer extends User {
    private String shippingAddress;

    @ManyToMany
    @JoinTable(name = "cart", joinColumns = @JoinColumn(name = "userID"), inverseJoinColumns = @JoinColumn(name = "productID"))
    private Set<Product> cart;

    public Set<Product> getProductsInCart() {
        return cart;
    }

    public void putInCart(Product product) {
        cart.add(product);
    }







    public Customer(String firstName, String lastName, String email, String phoneNumber, String password, String shippingAddress) throws NoSuchAlgorithmException, InvalidKeySpecException {
        super(firstName, lastName, email, phoneNumber, "CUSTOMER", password);
        this.shippingAddress = shippingAddress;
        cart = new HashSet<>();
    }

    public Customer() {
        cart = new HashSet<>();
    }
}
