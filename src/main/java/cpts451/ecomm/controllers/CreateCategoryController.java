package cpts451.ecomm.controllers;

import cpts451.ecomm.entities.Category;
import cpts451.ecomm.exceptions.MissingFieldException;
import cpts451.ecomm.services.CreateCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreateCategoryController {

    private final CreateCategoryService createCategoryService;

    public CreateCategoryController(CreateCategoryService createCategoryService) {
        this.createCategoryService = createCategoryService;
    }

    @RequestMapping("/createCategoryPage")
    public String showCreateCategoryPage(Model model) {
        model.addAttribute("category", new Category());
        return "createCategory";
    }

    @PostMapping("/createCategory")
    public String createCategory(@ModelAttribute Category category, Model model) {
        try {
            createCategoryService.CreateNewCategory(category);
            return "redirect:/adminHome";
        } catch (MissingFieldException e) {
            model.addAttribute("error", e.getMessage());
            return "createCategory";
        }
    }

}
