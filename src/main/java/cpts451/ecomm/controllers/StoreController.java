package cpts451.ecomm.controllers;
import cpts451.ecomm.entities.Admin;
import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.Product;
import cpts451.ecomm.services.CartService;
import cpts451.ecomm.services.ProductService;
import cpts451.ecomm.services.ReviewProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Controller
@RequestMapping("/storePage")
public class StoreController {
    private final ProductService productService;
    private final CartService cartService;
    private final ReviewProductService reviewProductService;

    public StoreController(ProductService productService, CartService cartService, ReviewProductService reviewProductService) {
        this.productService = productService;
        this.cartService = cartService;
        this.reviewProductService = reviewProductService;
    }

    @GetMapping
    public String showStorePage(@RequestParam(required = false) String sortBy, Model model, HttpSession session, Sort sort)
    {
        Iterable<Product> productIterable = productService.findAll();
        List<Product> products = StreamSupport.stream(productIterable.spliterator(), false).collect(Collectors.toList()); // Converts iterable to list

        if (sortBy != null)
        {
            products = sortProducts(products, sortBy);
        }

        model.addAttribute("products", products);
        model.addAttribute("reviewProduct", reviewProductService.findAll());


        return "storePage";
    }

    private List<Product> sortProducts(List<Product> products, String sortBy)
    {
        switch (sortBy) {
            case "name":
                return products.stream()
                        .sorted(Comparator.comparing(Product::getProductName))
                        .collect(Collectors.toList());
            case "nameDesc":
                return products.stream()
                        .sorted(Comparator.comparing(Product::getProductName).reversed())
                        .collect(Collectors.toList());
            case "category":
                return products.stream()
                        .sorted(Comparator.comparing(p -> p.getProductCategory().getCategoryName()))
                        .collect(Collectors.toList());
            case "categoryDesc":
                return products.stream()
                        .sorted(Comparator.comparing((Product p) -> p.getProductCategory().getCategoryName()).reversed())
                        .collect(Collectors.toList());
            case "price":
                return products.stream()
                        .sorted(Comparator.comparing(Product::getProductPrice))
                        .collect(Collectors.toList());
            case "priceDesc":
                return products.stream()
                        .sorted(Comparator.comparing(Product::getProductPrice).reversed())
                        .collect(Collectors.toList());
            case "quantity":
                return products.stream()
                        .sorted(Comparator.comparing(Product::getProductQuantity))
                        .collect(Collectors.toList());
            case "quantityDesc":
                return products.stream()
                        .sorted(Comparator.comparing(Product::getProductQuantity).reversed())
                        .collect(Collectors.toList());
            default:
                return products.stream()
                        .sorted(Comparator.comparing(Product::getProductName))
                        .collect(Collectors.toList());
        }
    }
}
