package cpts451.ecomm.controllers;

import cpts451.ecomm.entities.Admin;
import cpts451.ecomm.services.AdminService;
import cpts451.ecomm.services.CustomerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    private final AdminService adminService;
    private final CustomerService customerService;

    public AdminController(AdminService adminService, CustomerService customerService) {
        this.adminService = adminService;
        this.customerService = customerService;
    }

    @RequestMapping("/adminHome")
    public String adminHome(Model model, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");

        assert admin != null;

        model.addAttribute("adminFirstName", admin.getFirstName());
        model.addAttribute("adminLastName", admin.getLastName());
        model.addAttribute("adminEmail", admin.getEmail());
        model.addAttribute("adminPhoneNumber", admin.getPhoneNumber());
        model.addAttribute("admins", adminService.findAll());
        model.addAttribute("customers", customerService.findAll());

        return "adminHome";
    }
}
