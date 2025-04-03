package cpts451.ecomm.controllers;

import cpts451.ecomm.entities.Cart;
import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.Product;
import cpts451.ecomm.services.CartService;
import cpts451.ecomm.services.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private final ProductService productService;

    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping
    public String viewCart(HttpSession session, Model model) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            return "redirect:/loginPage";
        }

        Cart cart = cartService.getOrCreateCart(customer);
        model.addAttribute("cart", cart);
        return "cartPage";
    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestParam int productId, @RequestParam int quantity, HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            return "redirect:/loginPage";
        }

        Product product = productService.find(productId);
        cartService.addToCart(customer, product, quantity);

        return "redirect:/storePage";
    }

    @PostMapping("/remove/{cartItemId}")
    public String removeFromCart(@PathVariable int cartItemId, HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customer");

        if (customer == null) {
            return "redirect:/loginPage";
        }

        cartService.removeFromCart(customer, cartItemId);
        return "redirect:/cart";
    }
}
