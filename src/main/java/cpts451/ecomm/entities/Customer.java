package cpts451.ecomm.entities;

import jakarta.persistence.Entity;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


@Entity
public class Customer extends User {
    private String shippingAddress;

    public Customer(String firstName, String lastName, String email, String phoneNumber, String password, String shippingAddress) throws NoSuchAlgorithmException, InvalidKeySpecException {
        super(firstName, lastName, email, phoneNumber, "CUSTOMER", password);
        this.shippingAddress = shippingAddress;
    }

    public Customer() {

    }
}
