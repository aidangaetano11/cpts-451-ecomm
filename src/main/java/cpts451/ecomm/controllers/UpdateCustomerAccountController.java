package cpts451.ecomm.controllers;

import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.exceptions.ExistingAttributeException;
import cpts451.ecomm.exceptions.MissingFieldException;
import cpts451.ecomm.services.UpdateCustomerAccountService;
import cpts451.ecomm.services.CustomerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UpdateCustomerAccountController {

    private final UpdateCustomerAccountService updateCustomerAccountService;
    private final CustomerService customerService;

    public UpdateCustomerAccountController(UpdateCustomerAccountService updateCustomerAccountService, CustomerService customerService) {
        this.updateCustomerAccountService = updateCustomerAccountService;
        this.customerService = customerService;
    }

    @RequestMapping("/updateCustomerAccountPage")
    public String showCustomerAccountPage(@RequestParam("userId") Integer userId, Model model) { // gets userID of selected user
        Customer customer = customerService.find(userId); // get customer from on userId
        int id = customer.getId();
        model.addAttribute("id", id);
        model.addAttribute("customer", customer);

        return "updateCustomerAccount";
    }

    @PostMapping("/updateCustomerAccount")
    public String updateCustomerAccount(@ModelAttribute Customer customer, @RequestParam("userId") Integer userId, Model model, HttpSession session) {
        try {
            updateCustomerAccountService.UpdateCustomerAccount(customer, userId);
            session.setAttribute("customer", customerService.find(userId));
            return "redirect:/customerHome";
        } catch (MissingFieldException | ExistingAttributeException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("id", userId);
            return "updateCustomerAccount";
        }
    }

    @PostMapping("/deleteCustomerAccount")
    public String deleteCustomerAccount(@RequestParam("userId") Integer userID, HttpSession session) {
        session.invalidate();
        customerService.deleteById(userID);
        return "redirect:/storePage"; // Redirect to the store page after deletion
    }
}
