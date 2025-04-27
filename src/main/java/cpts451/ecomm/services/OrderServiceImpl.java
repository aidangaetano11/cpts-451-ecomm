package cpts451.ecomm.services;

import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.CustomerOrder;
import cpts451.ecomm.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) { this.orderRepository = orderRepository; }


    @Override
    public List<CustomerOrder> getAllOrders(Customer customer) {
        return orderRepository.findByCustomer(customer);
    }

    @Override
    public void addOrder(CustomerOrder customerOrder) {
        orderRepository.save(customerOrder);
    }

}
