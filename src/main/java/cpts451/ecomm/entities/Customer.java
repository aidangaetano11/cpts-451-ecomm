package cpts451.ecomm.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
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
