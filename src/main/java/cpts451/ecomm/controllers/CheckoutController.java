package cpts451.ecomm.controllers;

import cpts451.ecomm.entities.CustomerOrder;
import cpts451.ecomm.entities.Payment;
import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.Address;
import cpts451.ecomm.exceptions.ExistingAttributeException;
import cpts451.ecomm.exceptions.MissingFieldException;
import cpts451.ecomm.services.CartService;
import cpts451.ecomm.services.CheckoutService;
import cpts451.ecomm.services.CustomerService;
import cpts451.ecomm.services.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckoutController {

    private final CheckoutService checkoutService;
    private final CustomerService customerService;
    private final OrderService orderService;
    private final CartService cartService;

    public CheckoutController(CheckoutService checkoutService, CustomerService customerService, OrderService orderService, CartService cartService) {
        this.checkoutService = checkoutService;
        this.customerService = customerService;
        this.orderService = orderService;
        this.cartService = cartService;
    }

    @RequestMapping("/checkoutPage")
    public String checkoutPage(Model model, HttpSession session, @RequestParam("cartTotal") double cartTotal) throws NullPointerException {
        Customer customer = (Customer) session.getAttribute("customer");

        if (customer == null) {
            throw new NullPointerException("Customer not found in session.");
        }
        int id = customer.getId();
        Payment payment = new Payment();
        Address address = new Address();

        model.addAttribute("payment", payment);
        model.addAttribute("address", address);
        model.addAttribute("id", id);
        model.addAttribute("cartTotal", cartTotal);
        return "checkoutPage";
    }

    @PostMapping("/checkout")
    public String checkout(@ModelAttribute Payment payment, @ModelAttribute Address address, @RequestParam("userId") Integer userId, @RequestParam("amount") double amount, Model model, HttpSession session) {
        try {
            CustomerOrder order = new CustomerOrder(customerService.find(userId));
            cartService.emptyCart(customerService.find(userId));
            payment.setAmount(amount);
            payment.setUserID(userId);
            address.setUserID(userId);

            checkoutService.NewCheckoutService(payment, address, userId);
            return "redirect:/storePage";
        } catch (MissingFieldException | ExistingAttributeException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("id", userId);
            return "checkoutPage";
        }
    }
}
