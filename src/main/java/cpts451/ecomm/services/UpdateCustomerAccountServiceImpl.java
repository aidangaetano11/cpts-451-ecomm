package cpts451.ecomm.services;

import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.exceptions.ExistingAttributeException;
import cpts451.ecomm.exceptions.MissingFieldException;
import cpts451.ecomm.repositories.CustomerRepository;
import cpts451.ecomm.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateCustomerAccountServiceImpl implements UpdateCustomerAccountService
{
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;

    public UpdateCustomerAccountServiceImpl(CustomerRepository customerRepository, UserRepository userRepository)
    {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void UpdateCustomerAccount(Customer customer, int userId)
    {
        ValidateNullFields(customer);
        ValidateExistingFields(customer, userId);
        customer.setId(userId);
        customer.setRole("CUSTOMER");

        customerRepository.save(customer);
    }

    private void ValidateNullFields(Customer customer)
    {
        if (customer.getFirstName() == null || customer.getFirstName().trim().isEmpty())
        {
            throw new MissingFieldException("First name is required");
        }

        if (customer.getLastName() == null || customer.getLastName().trim().isEmpty())
        {
            throw new MissingFieldException("Last name is required.");
        }

        if (customer.getEmail() == null || customer.getEmail().trim().isEmpty())
        {
            throw new MissingFieldException("email is required.");
        }

        if (customer.getPhoneNumber() == null || customer.getPhoneNumber().trim().isEmpty())
        {
            throw new MissingFieldException("phone number is required.");
        }

    }

    private void ValidateExistingFields(Customer customer, int userId)
    {
        if (userRepository.findByEmail(customer.getEmail()) != null)
        {
            if (userRepository.findById(userId) != userRepository.findByEmail(customer.getEmail()))
            {
                throw new ExistingAttributeException("email already exists");
            }
        }

        if (userRepository.findByPhoneNumber(customer.getPhoneNumber()) != null)
        {
            if (userRepository.findById(userId) != userRepository.findByPhoneNumber(customer.getPhoneNumber()))
            {
                throw new ExistingAttributeException("phone number already exists");
            }
        }
    }
}
