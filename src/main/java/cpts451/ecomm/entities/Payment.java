package cpts451.ecomm.entities;

import jakarta.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // Payment id will be incremented everytime a payment is created
    private Integer paymentID;

    @Column(nullable = false)
    private Integer userID; // need to implement foreign key still

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private String paymentMethod;

    public Payment(Integer userID, Integer amount, String paymentMethod) {
        this.userID = userID;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public Payment() {

    }

    public Integer getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
