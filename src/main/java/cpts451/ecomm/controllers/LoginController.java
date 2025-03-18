package cpts451.ecomm.controllers;

import cpts451.ecomm.entities.User;
import cpts451.ecomm.services.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/loginPage")
    public String loginPage(Model model) {
        model.addAttribute("loginInfo", new LoginAttributes());
        return "loginPage";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginInfo") LoginAttributes loginInfo, HttpSession session, Model model)
    {
        String email = loginInfo.getEmail();
        String password = loginInfo.getPassword();

        boolean loginSuccess = loginService.verifyLogin(email, password);

        if (loginSuccess) {
            User account = loginService.find(email);
            String role = loginService.getUserRole(email);

            // Store user details in the session
            session.setAttribute("user", account);

            // Redirect based on role (Currently, it will be a successful login if we are sent back to index. We don't have user controllers or services yet.)
            if ("ADMIN".equals(role)) {
                return "redirect:/";
            } else if ("CUSTOMER".equals(role)) {
                return "redirect:/";
            } else {
                // Handle unknown roles
                model.addAttribute("error", "Unknown user role.");
                return "loginPage";
            }
        } else {
            // Handle invalid credentials
            model.addAttribute("error", "Invalid email or password.");
            return "loginPage";
        }
    }
}