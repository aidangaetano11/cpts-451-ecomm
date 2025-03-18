package cpts451.ecomm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class ReviewVendor extends Review {

    @JoinColumn(nullable = false)
    @ManyToOne
    private Admin vendor;

    public ReviewVendor (Customer cust, Integer rate, String com, String dat, Admin vend) {
        super(cust, rate, com, dat);
        this.vendor = vend;
    }
}