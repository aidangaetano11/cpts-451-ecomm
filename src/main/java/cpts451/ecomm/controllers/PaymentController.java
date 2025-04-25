package cpts451.ecomm.controllers;

import cpts451.ecomm.entities.Payment;
import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.Cart;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaymentController {

    public PaymentController() {

    }

    @RequestMapping("/paymentPage")
    public String paymentPage(Model model, HttpSession session) throws NullPointerException {
        double totalPrice = (double) session.getAttribute("cartTotal");
        Customer customer = (Customer) session.getAttribute("customer");
        Cart cart = (Cart) session.getAttribute("cart");

        if (customer == null) {
            throw new NullPointerException("Customer not found in session.");
        }
        if (cart.getCartItems().isEmpty()) {
            throw new NullPointerException("Cart is Empty");
        }

        model.addAttribute("userId", customer.getId());
        model.addAttribute("cart", cart);
        model.addAttribute("cartTotal", totalPrice);
        return "paymentPage";
    }
}
