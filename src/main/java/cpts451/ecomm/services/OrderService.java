package cpts451.ecomm.services;

import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.CustomerOrder;

import java.util.List;

public interface OrderService {

    List<CustomerOrder> getAllOrders(Customer customer);
}
