package cpts451.ecomm.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Admin extends User {

    public Admin(String firstName, String lastName, String email, String phoneNumber, String password) {
        super(firstName, lastName, email, phoneNumber, password, "ADMIN");
    }

    public Admin() {

    }
}
