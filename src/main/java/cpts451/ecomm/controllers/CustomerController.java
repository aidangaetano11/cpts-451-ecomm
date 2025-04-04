package cpts451.ecomm.controllers;

import cpts451.ecomm.entities.Customer;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

    public CustomerController() {

    }

    @RequestMapping("/customerHome")
    public String customerHome(Model model, HttpSession session) throws NullPointerException {
        Customer customer = (Customer) session.getAttribute("customer");

        if (customer == null) {
            throw new NullPointerException("Customer not found in session.");
        }

        model.addAttribute("userId", customer.getId());
        model.addAttribute("customerFirstName", customer.getFirstName());
        model.addAttribute("customerLastName", customer.getLastName());
        model.addAttribute("customerEmail", customer.getEmail());
        model.addAttribute("customerPhoneNumber", customer.getPhoneNumber());
        return "customerHome";
    }
}
