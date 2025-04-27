package cpts451.ecomm.services;

import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders(Customer customer);
}
