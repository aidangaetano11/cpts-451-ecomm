package cpts451.ecomm.setup;

import cpts451.ecomm.entities.*;
import cpts451.ecomm.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitialSetup implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final ReviewProductRepository reviewProductRepository;
    private final CategoryRepository categoryRepository;

    public InitialSetup(AdminRepository adminRepository, CustomerRepository customerRepository, ProductRepository productRepository, ReviewProductRepository reviewProductRepository, CategoryRepository categoryRepository) {
        this.adminRepository = adminRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.reviewProductRepository = reviewProductRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        adminRepository.save(new Admin("First", "Last", "admin@example.com", "1234567890", "admin123"));
        System.out.println("Admin account created successfully!");
        adminRepository.save(new Admin("Admin", "User", "aidan.gaetano@wsu.edu", "999999999", "password"));
        System.out.println("Admin account created successfully!");

        Customer cust = customerRepository.save(new Customer("Aidan", "Gaetano", "123@gmail.com", "123456788", "password2"));
        System.out.println("Customer account created successfully!");

        Category foodCategory = categoryRepository.save(new Category("Food"));
        System.out.println("Category account created successfully!");

        Product prod = productRepository.save(new Product("Apple", "A red delicious fruit.", 1.37, 23, foodCategory, 12));
        System.out.println("Product created successfully!");

        productRepository.save(new Product("Whole Wheat Bread", "A loaf of bread created with whole wheat.", 3.25, 12, foodCategory));
        System.out.println("Product created successfully!");

        productRepository.save(new Product("Cookies", "A dozen chocolate chip cookies.", 5.50, 12, foodCategory));
        System.out.println("Product created successfully!");

        reviewProductRepository.save(new ReviewProduct(cust, 5, "It's good!", "2025-04-04", prod));
        System.out.println("ReviewProduct created successfully!");

    }
}
