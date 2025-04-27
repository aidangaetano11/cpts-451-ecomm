package cpts451.ecomm.entities;

import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private CustomerOrder customerOrder;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantitySold;

    public OrderItem() {

    }

    public OrderItem(Product product, CustomerOrder customerOrder, int quantitySold) {
        this.product = product;
        this.quantitySold = quantitySold;
        this.customerOrder = customerOrder;
    }

    public CustomerOrder getOrder() { return customerOrder; }

    public void setOrder(CustomerOrder customerOrder) { this.customerOrder = customerOrder; }


    public Product getProduct() { return product; }

    public void setProduct(Product product) { this.product = product; }

    public int getQuantitySold() { return quantitySold; }

    public void setQuantitySold(int quantitySold) { this.quantitySold = quantitySold; }
}
