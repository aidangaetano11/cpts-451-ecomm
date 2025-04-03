package cpts451.ecomm.controllers;

import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.Product;
import cpts451.ecomm.entities.ProductExtension;
import cpts451.ecomm.services.AddToCartServiceImpl;
import cpts451.ecomm.services.CustomerService;
import cpts451.ecomm.services.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import cpts451.ecomm.services.AddToCartService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class StoreController {
    private final ProductService productService;
    private final CustomerService customerService;
    private final AddToCartService addToCartService;

    public StoreController(ProductService productService, AddToCartService addToCartService, CustomerService customerService) {
        this.productService = productService;
        this.addToCartService = addToCartService;
        this.customerService = customerService;
    }

    @RequestMapping("/storePage")
    public String adminHome(Model model, HttpSession session) {
        Iterable<Product> products = productService.findAll();
        List<ProductExtension> productExtensions = new ArrayList<ProductExtension>();
        for (Product product : products) {
            //System.out.println(product.getProductID());
            //System.out.println(product.getProductsInCart().toString());
            ProductExtension ext;
            if (session.getAttribute("customer") != null && addToCartService.isProductInCart(((Customer)session.getAttribute("customer")).getId(), product.getProductID())) {

                ext = new ProductExtension(product, true);
            }
            else {
                ext = new ProductExtension(product, false);

            }
            productExtensions.add(ext);
        }
        model.addAttribute("products", productExtensions);

        return "storePage";
    }

    @RequestMapping(value = "/addToCart", method = POST)
    public String addToCart(@RequestParam Integer customerID, @RequestParam Integer productID, Model model, HttpSession session) {
        Customer c = customerService.find(customerID);
        Product p = productService.find(productID);
        p.addCustomer(c);
        productService.save(p);
        //customerService.find(customerID).putInCart(productService.find(productID));
        //productService.find(productID).addCustomer(customerService.find(customerID));
        return "redirect:/storePage";
    }
}
