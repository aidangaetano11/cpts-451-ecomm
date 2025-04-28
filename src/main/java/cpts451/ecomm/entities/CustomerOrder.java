package cpts451.ecomm.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    private String date;

    public CustomerOrder() {
        this.date = LocalDate.now().toString();
    }

    public CustomerOrder(Customer customer) {
        this.customer = customer;
        this.date = LocalDate.now().toString();
    }

    public CustomerOrder(Customer customer, String date) {
        this.customer = customer;
        this.date = date;
    }


    public Customer getCustomer() { return customer; }

    public void setCustomer(Customer customer) { this.customer = customer; }

    public List<OrderItem> getOrderItems() { return orderItems; }

    public void setOrderItems(List<OrderItem> orderItems) { this.orderItems = orderItems; }

    public void addOrderItem(OrderItem orderItem) { this.getOrderItems().add(orderItem); }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }
}
