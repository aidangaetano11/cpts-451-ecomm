package cpts451.ecomm.controllers;

import cpts451.ecomm.entities.Admin;
import cpts451.ecomm.entities.Product;
import cpts451.ecomm.exceptions.ExistingAttributeException;
import cpts451.ecomm.exceptions.MissingFieldException;
import cpts451.ecomm.services.UpdateProductService;
import cpts451.ecomm.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UpdateProductController {

    private final UpdateProductService updateProductService;
    private final ProductService productService;

    public UpdateProductController(UpdateProductService updateProductService, ProductService productService) {
        this.updateProductService = updateProductService;
        this.productService = productService;
    }

    @RequestMapping("/updateProductPage")
    public String showUpdateProductPage(@RequestParam("productId") Integer productID, Model model) { // gets productID of selected product
        model.addAttribute("product", productService.find(productID)); // gets product of selected product by productID
        return "updateProduct";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute Product product, @RequestParam("productName") String productName, @RequestParam("productDescription") String productDescription,
                                @RequestParam("productPrice") double productPrice, @RequestParam("productQuantity") int productQuantity, Model model) {
        try {
            Product newProduct = productService.find(product.getProductID());
            updateProductService.UpdateProduct(newProduct, productName, productDescription, productPrice, productQuantity);
            return "redirect:/adminHome";
        } catch (MissingFieldException e) {
            model.addAttribute("error", e.getMessage());
            return "updateProduct";
        }
    }

    @PostMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("productId") Integer productID) {
        productService.deleteById(productID);
        return "redirect:/adminHome"; // Redirect to the product list page after deletion
    }
}
