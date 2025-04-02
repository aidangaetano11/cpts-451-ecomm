package cpts451.ecomm.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"userID", "productID"}))
@Entity
public class Wishlist{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer wishlistID;

    @ManyToOne
    @JoinColumn(name = "userID")
    private Integer userID;

    private Integer productID;

    public Wishlist(List<Product> productLists) {
        productList = productLists;
    }
    public Wishlist() {
    }

    public void addProduct(Product product)
    {
        productList.add(product);
    }
    public void removeProduct(Product product)
    {
        productList.remove(product);
    }
    public Product getProduct(Integer i)
    {
        return productList.get(i);
    }
}