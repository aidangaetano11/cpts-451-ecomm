package cpts451.ecomm.entities;

import cpts451.ecomm.hashing.PasswordHasher;
import jakarta.persistence.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

@Entity
@Table(name = "user_account")  // Changes table name to user_account instead of User (mainly because it is a default name so will cause conflicts)
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // User id will be incremented everytime a user is created
    private Integer userId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String role;

    @Transient
    private String password;

    // password salt
    private byte[] salt;

    // password hash
    private byte[] hash;


    public User(String firstName, String lastName, String email, String phoneNumber,
                String role, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.setPassword(password);
    }

    public User() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

    public String getPassword() { return ""; }

    public void setPassword(String newPassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
        this.salt = PasswordHasher.generateSalt();
        this.hash = PasswordHasher.generateHashCode(newPassword, this.salt);
    }

    public Integer getId() { return userId; }

    public void setId(int id) { userId = id; }

    public byte[] getSalt() { return this.salt; }

    public byte[] getHash() { return this.hash; }

    public boolean verifyPassword(String inputPassword) {
        try {
            byte[] inputHash = PasswordHasher.generateHashCode(inputPassword, this.salt);
            return Arrays.equals(inputHash, this.hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            return false;
        }
    }
}
