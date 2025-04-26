package cpts451.ecomm.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // Product id will be incremented everytime a user is created
    private Integer productID;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private String productDescription;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category productCategory;

    @Column(nullable = false)
    private Double productPrice;

    @Column(nullable = false)
    private Integer productQuantity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ReviewProduct> reviewProduct = new ArrayList<>();

    public Product(String productName, String productDescription, Double productPrice, Integer productQuantity, Category productCategory) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productCategory = productCategory;
    }

    public Product() {
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Category getProductCategory() { return productCategory; }

    public void setProductCategory(Category productCategory) { this.productCategory = productCategory; }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public List<ReviewProduct> getReviewProduct() { return reviewProduct; }

    public void setReviewProduct(List<ReviewProduct> reviewProduct) { this.reviewProduct = reviewProduct; }

}
