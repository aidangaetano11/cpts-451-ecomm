package cpts451.ecomm.controllers;

import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.exceptions.ExistingAttributeException;
import cpts451.ecomm.exceptions.MissingFieldException;
import cpts451.ecomm.services.CreateCustomerAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreateCustomerAccountController
{
    private final CreateCustomerAccountService createCustomerAccountService;

    public CreateCustomerAccountController(CreateCustomerAccountService createCustomerAccountService) {
        this.createCustomerAccountService = createCustomerAccountService;
    }

    @RequestMapping("/createCustomerAccount")
    public String createCustomerAccount(Model model)
    {
        model.addAttribute("customer", new Customer());
        return "createCustomer";
    }

    @PostMapping("/createCustomer")
    public String createCustomerAccount(@ModelAttribute Customer customer, Model model) {
        try {
            customer.setRole("CUSTOMER");
            createCustomerAccountService.CreateNewAccount(customer);
            return "redirect:/";
        } catch (MissingFieldException | ExistingAttributeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "createCustomer";
        }
    }
}
