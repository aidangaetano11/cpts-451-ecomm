package cpts451.ecomm.services;

import cpts451.ecomm.entities.Admin;
import cpts451.ecomm.exceptions.ExistingAttributeException;
import cpts451.ecomm.exceptions.MissingFieldException;
import cpts451.ecomm.repositories.AdminRepository;
import cpts451.ecomm.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateAdminAccountServiceImpl implements CreateAdminAccountService {

    private final AdminRepository adminRepository;
    private final UserRepository userRepository;

    public CreateAdminAccountServiceImpl(AdminRepository adminRepository, UserRepository userRepository)
    {
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void CreateNewAccount(Admin newAdmin)
    {
        ValidateNullFields(newAdmin);
        ValidateExistingFields(newAdmin);


        adminRepository.save(newAdmin);
    }

    private void ValidateNullFields(Admin newAdmin)
    {
        if (newAdmin.getFirstName() == null || newAdmin.getFirstName().trim().isEmpty())
        {
            throw new MissingFieldException("First name is required");
        }

        if (newAdmin.getLastName() == null || newAdmin.getLastName().trim().isEmpty())
        {
            throw new MissingFieldException("Last name is required.");
        }

        if (newAdmin.getEmail() == null || newAdmin.getEmail().trim().isEmpty())
        {
            throw new MissingFieldException("email is required.");
        }

        if (newAdmin.getPhoneNumber() == null || newAdmin.getPhoneNumber().trim().isEmpty())
        {
            throw new MissingFieldException("phone number is required.");
        }

        if (newAdmin.getPassword() == null || newAdmin.getPassword().trim().isEmpty())
        {
            throw new MissingFieldException("password is required.");
        }
    }

    private void ValidateExistingFields(Admin newAdmin)
    {
        if (userRepository.findByEmail(newAdmin.getEmail()) != null)
        {
            throw new ExistingAttributeException("email already exists");
        }

        if (userRepository.findByPhoneNumber(newAdmin.getPhoneNumber()) != null)
        {
            throw new ExistingAttributeException("phone number already exists");
        }
    }
}
