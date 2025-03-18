package cpts451.ecomm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class ReviewProduct extends Review {

    @JoinColumn(nullable = false)
    @ManyToOne
    private Product product;

    public ReviewProduct (Customer cust, Integer rate, String com, String dat, Product prod) {
        super(cust, rate, com, dat);
        this.product = prod;
    }
}
