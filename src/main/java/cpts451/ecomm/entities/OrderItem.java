package cpts451.ecomm.entities;

import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantitySold;

    public OrderItem() {

    }

    public OrderItem(Product product, Order order, int quantitySold) {
        this.product = product;
        this.quantitySold = quantitySold;
        this.order = order;
    }

    public Order getOrder() { return order; }

    public void setOrder(Order order) { this.order = order; }


    public Product getProduct() { return product; }

    public void setProduct(Product product) { this.product = product; }

    public int getQuantitySold() { return quantitySold; }

    public void setQuantitySold(int quantitySold) { this.quantitySold = quantitySold; }
}
