package cpts451.ecomm.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class OrderBy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // Order id will be incremented everytime an order is created
    private Integer orderID;

    @Column(nullable = false)
    private Integer userID;

    @Column(nullable = false)
    private Integer productID;

    @Column(nullable = false)
    private Double totalPrice;

    @Column(nullable = false)
    private Date date;

    public OrderBy(Integer userID, Integer productID, Double totalPrice, Date date) {
        this.userID = userID;
        this.productID = productID;
        this.totalPrice = totalPrice;
        this.date = date;
    }

    public OrderBy() {

    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
