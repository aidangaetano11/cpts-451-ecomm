package cpts451.ecomm.controllers;
import cpts451.ecomm.entities.Admin;
import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.services.CartService;
import cpts451.ecomm.services.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class StoreController {
    private final ProductService productService;
    private final CartService cartService;

    public StoreController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @RequestMapping("/storePage")
    public String storePage(Model model) {

        model.addAttribute("products", productService.findAll());

        return "storePage";
    }
}
