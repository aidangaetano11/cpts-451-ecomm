package cpts451.ecomm.entities;

import jakarta.persistence.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Customer extends User {
    private String shippingAddress;

    @ManyToMany
    @JoinTable(name = "cart", joinColumns = @JoinColumn(name = "userID"), inverseJoinColumns = @JoinColumn(name = "productID"))
    private List<Product> cart = new ArrayList<>();


    public Customer(String firstName, String lastName, String email, String phoneNumber, String password, String shippingAddress) throws NoSuchAlgorithmException, InvalidKeySpecException {
        super(firstName, lastName, email, phoneNumber, "CUSTOMER", password);
        this.shippingAddress = shippingAddress;
    }

    public Customer() {
    }
}
