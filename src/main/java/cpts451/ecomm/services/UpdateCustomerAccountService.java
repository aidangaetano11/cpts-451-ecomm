package cpts451.ecomm.services;

import cpts451.ecomm.entities.Customer;

public interface UpdateCustomerAccountService {

    public void UpdateCustomerAccount(Customer customer, int userId);
}