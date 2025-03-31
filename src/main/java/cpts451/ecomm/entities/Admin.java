package cpts451.ecomm.entities;

import jakarta.persistence.Entity;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Entity
public class Admin extends User {

    public Admin(String firstName, String lastName, String email, String phoneNumber, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        super(firstName, lastName, email, phoneNumber,"ADMIN", password);
    }

    public Admin() {

    }
}
