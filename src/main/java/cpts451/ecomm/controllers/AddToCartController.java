package cpts451.ecomm.controllers;

import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.Product;
import cpts451.ecomm.exceptions.ExistingAttributeException;
import cpts451.ecomm.exceptions.MissingFieldException;
import cpts451.ecomm.services.AddToCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddToCartController {
    private final AddToCartService addToCartService;

    public AddToCartController(AddToCartService addToCartService) {
        this.addToCartService = addToCartService;
    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestParam int customerID, @RequestParam int productID, Model model) {
        try {
            addToCartService.AddToCart(customerID, productID);
            return "redirect:/storePage";
        } catch (MissingFieldException | ExistingAttributeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "storePage";
        }
    }
}
