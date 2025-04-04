package cpts451.ecomm.controllers;

import cpts451.ecomm.entities.Admin;
import cpts451.ecomm.exceptions.ExistingAttributeException;
import cpts451.ecomm.exceptions.MissingFieldException;
import cpts451.ecomm.services.UpdateAdminAccountService;
import cpts451.ecomm.services.AdminService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UpdateAdminAccountController {

    private final UpdateAdminAccountService updateAdminAccountService;
    private final AdminService adminService;

    public UpdateAdminAccountController(UpdateAdminAccountService updateAdminAccountService, AdminService adminService) {
        this.updateAdminAccountService = updateAdminAccountService;
        this.adminService = adminService;
    }

    @RequestMapping("/updateAdminAccountPage")
    public String showAdminAccountPage(@RequestParam("userId") Integer userId, Model model) { // gets userID of selected user
        Admin admin = adminService.find(userId); // get admin from on userId
        int id = admin.getId();

        model.addAttribute("id", id);
        model.addAttribute("admin", admin);

        return "updateAdminAccount";
    }

    @PostMapping("/updateAdminAccount")
    public String updateAdminAccount(@ModelAttribute Admin admin, @RequestParam("userId") Integer userId, Model model, HttpSession session) {
        try {
            updateAdminAccountService.UpdateAdminAccount(admin, userId);
            session.setAttribute("admin", adminService.find(userId));
            return "redirect:/adminHome";
        } catch (MissingFieldException | ExistingAttributeException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("id", userId);
            return "updateAdminAccount";
        }
    }

    @PostMapping("/deleteAdminAccount")
    public String deleteAdminAccount(@RequestParam("userId") Integer userID, HttpSession session) {
        session.invalidate();
        adminService.deleteById(userID);
        return "redirect:/storePage"; // Redirect to the store page after deletion
    }
}
