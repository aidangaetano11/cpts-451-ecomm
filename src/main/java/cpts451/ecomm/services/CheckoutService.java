package cpts451.ecomm.services;

import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.Payment;
import cpts451.ecomm.entities.Address;

public interface CheckoutService {
    public void NewCheckoutService(Payment payment, Address address, int userId);
}
