package cpts451.ecomm.controllers;

import cpts451.ecomm.entities.Admin;
import cpts451.ecomm.exceptions.ExistingAttributeException;
import cpts451.ecomm.exceptions.MissingFieldException;
import cpts451.ecomm.services.CreateAdminAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreateAdminAccountController {

    private final CreateAdminAccountService createAdminAccountService;

    public CreateAdminAccountController(CreateAdminAccountService createAdminAccountService) {
        this.createAdminAccountService = createAdminAccountService;
    }

    @RequestMapping("/createAdminAccount")
    public String showCreateAdminAccountPage(Model model) {
        model.addAttribute("admin", new Admin());
        return "createAdmin";
    }

    @PostMapping("/createAdmin")
    public String createAdminAccount(@ModelAttribute Admin admin, Model model) {
        try {
            admin.setRole("ADMIN");
            createAdminAccountService.CreateNewAccount(admin);
            return "redirect:/";
        } catch (MissingFieldException | ExistingAttributeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "createAdmin";
        }
    }
}
