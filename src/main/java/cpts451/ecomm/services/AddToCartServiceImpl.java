package cpts451.ecomm.services;

import cpts451.ecomm.entities.Product;
import cpts451.ecomm.repositories.CustomerRepository;
import cpts451.ecomm.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddToCartServiceImpl implements AddToCartService{
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public AddToCartServiceImpl(CustomerRepository customerRepository, ProductRepository productRepository)
    {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void AddToCart(int customerID, int productID) {
/*
        if (customerRepository.existsById(customerID) && productRepository.existsById(productID)) {
            if (!customerRepository.findById(customerID).get().isProductInCart(productID)) {
                customerRepository.findById(customerID).get().putInCart(productRepository.findById(productID).get());
            }
        }*/
    }

    @Override
    public boolean isProductInCart(Integer customerID, Integer productID) {
        List<Product> productsInCart = productRepository.findProductByCustomerID(customerID);
        for (Product product : productsInCart) {
            System.out.println(product.getProductID());
            if (product.getProductID().equals(productID)) {
                return true;
            }
        }
        return false;
    }

}
