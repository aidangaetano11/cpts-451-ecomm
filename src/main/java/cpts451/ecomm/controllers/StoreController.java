package cpts451.ecomm.controllers;

import cpts451.ecomm.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StoreController {
    private final ProductService productService;

    public StoreController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/storePage")
    public String adminHome(Model model) {

        model.addAttribute("products", productService.findAll());

        return "storePage";
    }
}
