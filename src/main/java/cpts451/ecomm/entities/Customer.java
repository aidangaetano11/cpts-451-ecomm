package cpts451.ecomm.entities;

import jakarta.persistence.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Customer extends User {
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address shippingAddress;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ReviewProduct> reviewProduct = new ArrayList<>();


    public Customer(String firstName, String lastName, String email, String phoneNumber, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        super(firstName, lastName, email, phoneNumber, "CUSTOMER", password);
    }

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CustomerOrder> orders = new ArrayList<>();
    public Customer() {
    }

    public Address getShippingAddress() {return shippingAddress;}

    public void setShippingAddress(Address shippingAddress) {this.shippingAddress = shippingAddress; }

    public List<ReviewProduct> getReviewProduct() { return reviewProduct; }

    public void setReviewProduct(List<ReviewProduct> reviewProduct) { this.reviewProduct = reviewProduct; }

    public List<CustomerOrder> getOrders() { return orders; }

    public void addOrder(CustomerOrder customerOrder) { this.orders.add(customerOrder); }
}
