package cpts451.ecomm.controllers;

import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.Product;
import cpts451.ecomm.entities.ReviewProduct;
import cpts451.ecomm.exceptions.ExistingAttributeException;
import cpts451.ecomm.exceptions.MissingFieldException;
import cpts451.ecomm.services.CreateReviewProductService;
import cpts451.ecomm.services.ReviewProductService;
import cpts451.ecomm.services.ProductService;
import cpts451.ecomm.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDate;

@Controller
public class CreateReviewProductController {

    private final CreateReviewProductService createReviewProductService;
    private final ReviewProductService reviewProductService;
    private final ProductService productService;
    private final CustomerService customerService;

    public CreateReviewProductController(CreateReviewProductService createReviewProductService, ReviewProductService reviewProductService, ProductService productService, CustomerService customerService) {
        this.createReviewProductService = createReviewProductService;
        this.reviewProductService = reviewProductService;
        this.productService = productService;
        this.customerService = customerService;
    }

    @RequestMapping("/createReviewProductPage")
    public String showCreateReviewProductPage(@RequestParam("productId") Integer productId, @RequestParam("customerId") Integer customerId, Model model) {

        Customer customer = customerService.find(customerId);
        ReviewProduct reviewProduct = reviewProductService.findByCustomerProductId(customerId, productId);
        boolean delete = true;

        // check if customer already left review for this product
        if (reviewProduct == null)
        {
            delete = false;
            reviewProduct = new ReviewProduct();
            reviewProduct.setProduct(productService.find(productId));
            reviewProduct.setCustomer(customerService.find(customerId));
            reviewProduct.setDate(LocalDate.now().toString());
        }

        model.addAttribute("reviewProduct", reviewProduct);
        model.addAttribute("customerId", customerId);
        model.addAttribute("productId", productId);
        model.addAttribute("delete", delete);
        return "createReviewProduct";
    }

    @PostMapping("/createReviewProduct")
    public String createReviewProduct(@ModelAttribute ReviewProduct reviewProduct, Model model) {
        try {
            createReviewProductService.CreateNewReviewProduct(reviewProduct);
            return "redirect:/storePage";
        } catch (MissingFieldException e) {
            model.addAttribute("error", e.getMessage());
            return "createReviewProduct";
        }
    }

    @PostMapping("/deleteReviewProduct")
    public String deleteReviewProduct(@RequestParam("customerId") int customerId, @RequestParam("productId") int productId, Model model) {
        try {
            reviewProductService.deleteByCustomerProductId(customerId, productId);
            return "redirect:/storePage";
        } catch (MissingFieldException e) {
            model.addAttribute("error", e.getMessage());
            return "createReviewProduct";
        }
    }
}
