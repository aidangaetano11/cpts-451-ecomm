package cpts451.ecomm.entities;

import io.opentelemetry.sdk.metrics.internal.export.CardinalityLimitSelector;
import jakarta.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // Payment id will be incremented everytime a payment is created
    private Integer paymentID;

    @Column(nullable = false)
    private Integer userID; // need to implement foreign key still

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private String cardName;

    @Column(nullable = false)
    private String cardExpirationDate;

    @Column(nullable = false)
    private String cardSecurityCode;

    public Payment(Integer userID, Integer amount, String cardNumber, String cardName, String cardExpirationDate, String cardSecurityCode) {
        this.userID = userID;
        this.amount = amount;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.cardExpirationDate = cardExpirationDate;
        this.cardSecurityCode = cardSecurityCode;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardExpirationDate() {
        return cardExpirationDate;
    }

    public void setCardExpirationDate(String cardExpirationDate) {
        this.cardExpirationDate = cardExpirationDate;
    }

    public String getCardSecurityCode() {
        return cardSecurityCode;
    }

    public void setCardSecurityCode(String cardSecurityCode) {
        this.cardSecurityCode = cardSecurityCode;
    }
}
