package cpts451.ecomm.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor  // Essentially creates getters and setters for everything
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
    private String password;

    @Column(nullable = false)
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
}
