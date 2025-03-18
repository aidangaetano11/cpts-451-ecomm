package cpts451.ecomm.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor  // Essentially creates getters and setters for everything
@Entity
@Table  // Changes table name to user_account instead of User (mainly because it is a default name so will cause conflicts)
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Customer customer;

    @Column(nullable = false)
    private Integer rating;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private String date;

    public Review(Customer cust, Integer rate, String com, String dat) {
        this.customer = cust;
        this.rating = rate;
        this.comment = com;
        this.date = dat;
    }
}