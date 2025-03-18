package cpts451.ecomm.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Cart{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartID;

    @Column(nullable = false)
    @ManyToMany
    private List<Product> productList = new ArrayList<>();

    @Column(nullable = false)
    private Double totalPrice = 0.0;

    //@Column(nullable = false)
    //private Customer cartCustomer;

    //@Column(nullable = false)
    //private Order cartOrder;


    public Cart(List<Product> productLists) {
        productList = productLists;
    }
    public Cart() {
    }

    public void setProductList(List<Product> products){
        productList = products;
    }
    public List<Product> getProductList(){
        return productList;
    }

    public void setTotalPrice(Double price){
        totalPrice = price;
    }
    public Double getTotalPrice(){
        return totalPrice;
    }

    public Double calculateTotalPrice()
    {
        Double total = 0.0;
        for (Product product : productList)
        {
            total += product.getProductPrice();
        }
        return total;
    }

    public void addProduct(Product product)
    {
        productList.add(product);
        totalPrice = calculateTotalPrice();
    }
    public void removeProduct(Product product)
    {
        productList.remove(product);
        totalPrice = calculateTotalPrice();
    }
    public Product getProduct(Integer i)
    {
        return productList.get(i);
    }
}