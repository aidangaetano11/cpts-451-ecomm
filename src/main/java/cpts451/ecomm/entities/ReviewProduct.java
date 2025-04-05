package cpts451.ecomm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class ReviewProduct extends Review {

    @ManyToOne
    @JoinColumn(name = "product_id")  // Foreign key for product
    private Product product;

    public ReviewProduct (Customer cust, Integer rate, String com, String dat, Product prod) {
        super(cust, rate, com, dat);
        this.product = prod;
    }

    public ReviewProduct() {    }

    public Product getProduct() {return product;}
    public void setProduct(Product prod) {
        this.product = prod;
    }
}
