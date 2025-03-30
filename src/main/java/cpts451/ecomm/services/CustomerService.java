package cpts451.ecomm.services;

import cpts451.ecomm.entities.Customer;

public interface CustomerService {
    Customer find(int id);

    Iterable<Customer> findAll();

    Customer save(Customer customer);
}
