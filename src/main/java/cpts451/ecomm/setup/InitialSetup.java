package cpts451.ecomm.setup;

import cpts451.ecomm.entities.Admin;
import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.repositories.AdminRepository;
import cpts451.ecomm.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitialSetup implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final CustomerRepository customerRepository;

    public InitialSetup(AdminRepository adminRepository, CustomerRepository customerRepository) {
        this.adminRepository = adminRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        adminRepository.save(new Admin("First", "Last", "admin@example.com", "1234567890", "admin123"));
        System.out.println("Admin account created successfully!");
        adminRepository.save(new Admin("Admin", "User", "aidan.gaetano@wsu.edu", "999999999", "password"));
        System.out.println("Admin account created successfully!");

        customerRepository.save(new Customer("Aidan", "Gaetano", "123@gmail.com", "123456788", "password2", "address"));
        System.out.println("Customer account created successfully!");
    }
}
