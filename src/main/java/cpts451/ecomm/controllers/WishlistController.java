package cpts451.ecomm.controllers;

import cpts451.ecomm.entities.Cart;
import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.Product;
import cpts451.ecomm.entities.Wishlist;
import cpts451.ecomm.services.ProductService;
import cpts451.ecomm.services.WishlistService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {
    private final WishlistService wishlistService;
    private final ProductService productService;

    public WishlistController(WishlistService wishlistService, ProductService productService) {
        this.wishlistService = wishlistService;
        this.productService = productService;
    }

    @GetMapping
    public String viewWishlist(HttpSession session, Model model) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            return "redirect:/loginPage";
        }

        Wishlist wishlist = wishlistService.getOrCreateWishlist(customer);

        model.addAttribute("wishlist", wishlist);

        return "wishlistPage";
    }

    @PostMapping("/addToWishlist")
    public String addToWishlist(@RequestParam int productId, HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            return "redirect:/loginPage";
        }

        Product product = productService.find(productId);
        wishlistService.addToWishlist(customer, product);

        return "redirect:/storePage";
    }

    @PostMapping("/remove/{wishlistItemId}")
    public String removeFromWishlist(@PathVariable int wishlistItemId, HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customer");

        if (customer == null) {
            return "redirect:/loginPage";
        }

        wishlistService.removeFromWishlist(customer, wishlistItemId);
        return "redirect:/wishlist";
    }
}
