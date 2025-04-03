package cpts451.ecomm.setup;

import cpts451.ecomm.entities.Admin;
import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.Product;
import cpts451.ecomm.repositories.AdminRepository;
import cpts451.ecomm.repositories.CustomerRepository;
import cpts451.ecomm.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitialSetup implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public InitialSetup(AdminRepository adminRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.adminRepository = adminRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        adminRepository.save(new Admin("First", "Last", "admin@example.com", "1234567890", "admin123"));
        System.out.println("Admin account created successfully!");
        adminRepository.save(new Admin("Admin", "User", "aidan.gaetano@wsu.edu", "999999999", "password"));
        System.out.println("Admin account created successfully!");

        customerRepository.save(new Customer("Aidan", "Gaetano", "123@gmail.com", "123456788", "password2", "address"));
        System.out.println("Customer account created successfully!");

        productRepository.save(new Product("Apple", "A red delicious fruit.", 1.50, 23));
        System.out.println("Product created successfully!");

        productRepository.save(new Product("Whole Wheat Bread", "A loaf of bread created with whole wheat.", 3.25, 12));
        System.out.println("Product created successfully!");

        productRepository.save(new Product("Cookies", "A dozen chocolate chip cookies.", 5.50, 12));
        System.out.println("Product created successfully!");

    }
}
