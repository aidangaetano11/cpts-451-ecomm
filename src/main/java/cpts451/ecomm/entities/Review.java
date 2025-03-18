package cpts451.ecomm.entities;

import jakarta.persistence.*;
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

    public Integer getreviewId() {
        return reviewId;
    }

    public Customer getCustomer() {return customer;}
    public void setCustomer(Customer cust) {
        this.customer = cust;
    }

    public Integer getRating() {return rating;}
    public void setRating(Integer rat) { this.rating = rat; }

    public String getComment() {return comment;}
    public void setComment(String com) { this.comment = com; }

    public String getDate() {return date;}
    public void setDate(String dat) { this.date = dat; }
}