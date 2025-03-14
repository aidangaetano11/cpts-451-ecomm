package cpts451.ecomm.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user_account")  // Changes table name to user_account instead of User (mainly because it is a default name so will cause conflicts)
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // User id will be incremented everytime a user is created
    private Integer userId;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String password;

    private String role;

    public User(String firstName, String lastName, String email, String phoneNumber,
                String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
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

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

    public Integer getId() {
        return userId;
    }

    public void setID(int id) { this.userId = id; }
}
