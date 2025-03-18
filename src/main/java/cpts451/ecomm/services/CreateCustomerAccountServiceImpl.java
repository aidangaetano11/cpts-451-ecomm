package cpts451.ecomm.services;

import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.exceptions.ExistingAttributeException;
import cpts451.ecomm.exceptions.MissingFieldException;
import cpts451.ecomm.repositories.CustomerRepository;
import cpts451.ecomm.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerAccountServiceImpl implements CreateCustomerAccountService
{
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;

    public CreateCustomerAccountServiceImpl(CustomerRepository customerRepository, UserRepository userRepository)
    {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void CreateNewAccount(Customer newCustomer)
    {
        ValidateNullFields(newCustomer);
        ValidateExistingFields(newCustomer);

        customerRepository.save(newCustomer);
    }

    private void ValidateNullFields(Customer newCustomer)
    {
        if (newCustomer.getFirstName() == null || newCustomer.getFirstName().trim().isEmpty())
        {
            throw new MissingFieldException("First name is required");
        }

        if (newCustomer.getLastName() == null || newCustomer.getLastName().trim().isEmpty())
        {
            throw new MissingFieldException("Last name is required.");
        }

        if (newCustomer.getEmail() == null || newCustomer.getEmail().trim().isEmpty())
        {
            throw new MissingFieldException("email is required.");
        }

        if (newCustomer.getPhoneNumber() == null || newCustomer.getPhoneNumber().trim().isEmpty())
        {
            throw new MissingFieldException("phone number is required.");
        }

        if (newCustomer.getPassword() == null || newCustomer.getPassword().trim().isEmpty())
        {
            throw new MissingFieldException("password is required.");
        }
    }

    private void ValidateExistingFields(Customer newCustomer)
    {
        if (userRepository.findByEmail(newCustomer.getEmail()) != null)
        {
            throw new ExistingAttributeException("email already exists");
        }

        if (userRepository.findByPhoneNumber(newCustomer.getPhoneNumber()) != null)
        {
            throw new ExistingAttributeException("phone number already exists");
        }
    }
}
