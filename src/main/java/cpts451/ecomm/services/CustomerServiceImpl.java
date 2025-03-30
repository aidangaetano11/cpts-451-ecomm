package cpts451.ecomm.services;

import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.repositories.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) { this.customerRepository = customerRepository; }

    /**
     * finds customer by id
     * @param id the id of the customer we're looking for
     * @return the customer if found, otherwise null
     */
    @Override
    public Customer find(int id) { return customerRepository.findById(id).orElse(null); }

    /**
     * finds all customers
     * @return a collection of customers
     */
    @Override
    public Iterable<Customer> findAll() { return customerRepository.findAll(); }

    /**
     * saves a customer
     * @param customer the customer we're saving
     * @return the customer we just saved
     */
    @Override
    public Customer save(Customer customer) { return customerRepository.save(customer); }
}
