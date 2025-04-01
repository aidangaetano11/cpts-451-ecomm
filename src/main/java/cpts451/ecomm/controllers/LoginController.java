package cpts451.ecomm.controllers;

import cpts451.ecomm.entities.Admin;
import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.User;
import cpts451.ecomm.services.AdminService;
import cpts451.ecomm.services.CustomerService;
import cpts451.ecomm.services.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    public static class LoginAttributes {
        private String email;
        private String password;

        public LoginAttributes() {}

        public LoginAttributes(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }

    LoginService loginService;
    CustomerService customerService;
    AdminService adminService;

    public LoginController(LoginService loginService, CustomerService customerService, AdminService adminService) {
        this.loginService = loginService;
        this.customerService = customerService;
        this.adminService = adminService;
    }

    @GetMapping("/loginPage")
    public String loginPage(Model model) {
        model.addAttribute("loginInfo", new LoginAttributes());
        return "loginPage";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginAttributes loginInfo, HttpSession session, Model model)
    {
        String redirect = "loginPage";
        String email = loginInfo.getEmail();
        String password = loginInfo.getPassword();

        boolean loginSuccess = loginService.verifyLogin(email, password);

        if (!loginSuccess)
        {
            model.addAttribute("error", "Invalid email or password");
            model.addAttribute("loginInfo", loginInfo);
            redirect = "loginPage";
        }

        if (loginSuccess) {
            User account = loginService.find(email);
            Customer customer = customerService.find(account.getId());
            Admin admin = adminService.find(account.getId());
            String role = loginService.getUserRole(email);

            if (customer != null && "CUSTOMER".equals(role)) {
                session.setAttribute("customer", customer);
                redirect = "redirect:/storePage";
            }
            else if (admin != null && "ADMIN".equals(role)) {
                session.setAttribute("admin", admin);
                redirect = "redirect:/storePage";
            }
        }

        return redirect;
    }
}