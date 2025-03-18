package cpts451.ecomm.entities;

import jakarta.persistence.Entity;


@Entity
public class Customer extends User {
    private String shippingAddress;

    public Customer(String firstName, String lastName, String email, String phoneNumber, String password, String shippingAddress) {
        super(firstName, lastName, email, phoneNumber, password, "CUSTOMER");
        this.shippingAddress = shippingAddress;
    }

    public Customer() {

    }
}
