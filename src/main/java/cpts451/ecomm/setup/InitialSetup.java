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
    private final OrderRepository orderRepository;

    public InitialSetup(AdminRepository adminRepository, CustomerRepository customerRepository, ProductRepository productRepository, ReviewProductRepository reviewProductRepository, CategoryRepository categoryRepository, OrderRepository orderRepository) {
        this.adminRepository = adminRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.reviewProductRepository = reviewProductRepository;
        this.categoryRepository = categoryRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        /*adminRepository.save(new Admin("First", "Last", "admin@example.com", "1234567890", "admin123"));
        System.out.println("Admin account created successfully!");
        adminRepository.save(new Admin("Admin", "User", "aidan.gaetano@wsu.edu", "999999999", "password"));
        System.out.println("Admin account created successfully!");

        Customer cust = new Customer("Aidan", "Gaetano", "123@gmail.com", "123456788", "password2");
        customerRepository.save(cust);
        System.out.println("Customer account created successfully!");

        Category foodCategory = categoryRepository.save(new Category("Food"));
        System.out.println("Category account created successfully!");

        Product prod = productRepository.save(new Product("Apple", "A red delicious fruit.", 1.37, 23, foodCategory, 12));
        System.out.println("Product created successfully!");

        Product p1 = new Product("Whole Wheat Bread", "A loaf of bread created with whole wheat.", 3.25, 12, foodCategory);
        productRepository.save(p1);
        System.out.println("Product created successfully!");

        Product p2 = new Product("Cookies", "A dozen chocolate chip cookies.", 5.50, 12, foodCategory);
        productRepository.save(p2);
        System.out.println("Product created successfully!");

        reviewProductRepository.save(new ReviewProduct(cust, 5, "It's good!", "2025-04-04", prod));
        System.out.println("ReviewProduct created successfully!");

        CustomerOrder order = new CustomerOrder(cust, "2025-04-04");
        OrderItem item = new OrderItem(p1, order, 5);
        order.addOrderItem(item);
        OrderItem item2 = new OrderItem(p2, order, 3);
        order.addOrderItem(item2);
        orderRepository.save(order);
        System.out.println("Order created successfully!");

        CustomerOrder order2 = new CustomerOrder(cust, "2025-04-25");
        OrderItem item3 = new OrderItem(p1, order2, 1);
        order2.addOrderItem(item3);
        orderRepository.save(order2);
        System.out.println("Order created successfully!");*/
    }
}
