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

    public Customer(String firstName, String lastName, String email, String phoneNumber, String password, String shippingAddress) throws NoSuchAlgorithmException, InvalidKeySpecException {
        super(firstName, lastName, email, phoneNumber, "CUSTOMER", password);
        this.shippingAddress = shippingAddress;
    }

    public Customer() {
    }
}
