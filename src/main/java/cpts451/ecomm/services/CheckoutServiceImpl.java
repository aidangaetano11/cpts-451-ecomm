package cpts451.ecomm.services;

import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.entities.Address;
import cpts451.ecomm.entities.Payment;
import cpts451.ecomm.exceptions.ExistingAttributeException;
import cpts451.ecomm.exceptions.MissingFieldException;
import cpts451.ecomm.repositories.CustomerRepository;
import cpts451.ecomm.repositories.AddressRepository;
import cpts451.ecomm.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class CheckoutServiceImpl implements CheckoutService
{
    private final PaymentRepository paymentRepository;
    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;

    public CheckoutServiceImpl(AddressRepository addressRepository, PaymentRepository paymentRepository, CustomerRepository customerRepository)
    {
        this.addressRepository = addressRepository;
        this.paymentRepository = paymentRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void NewCheckoutService(Payment payment, Address address, int userId)
    {
        paymentRepository.save(payment);
        addressRepository.save(address);
    }
}
