package cpts451.ecomm.controllers;

import cpts451.ecomm.entities.Admin;
import cpts451.ecomm.entities.Product;
import cpts451.ecomm.exceptions.ExistingAttributeException;
import cpts451.ecomm.exceptions.MissingFieldException;
import cpts451.ecomm.services.CategoryService;
import cpts451.ecomm.services.CreateProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreateProductController {

    private final CreateProductService createProductService;
    private final CategoryService categoryService;

    public CreateProductController(CreateProductService createProductService, CategoryService categoryService) {
        this.createProductService = createProductService;
        this.categoryService = categoryService;
    }

    @RequestMapping("/createProductPage")
    public String showCreateProductPage(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        return "createProduct";
    }

    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute Product product, Model model) {
        try {
            createProductService.CreateNewProduct(product);
            return "redirect:/adminHome";
        } catch (MissingFieldException e) {
            model.addAttribute("error", e.getMessage());
            return "createProduct";
        }
    }
}
