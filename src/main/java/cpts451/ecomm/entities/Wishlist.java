package cpts451.ecomm.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Wishlist{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer wishlistID;

    @Column(nullable = false)
    @ManyToMany
    private List<Product> productList = new ArrayList<>();
    //@Column(nullable = false)
    //private Customer cartCustomer;

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