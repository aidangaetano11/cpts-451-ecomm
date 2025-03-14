package cpts451.ecomm.services;

import cpts451.ecomm.entities.Admin;
import cpts451.ecomm.exceptions.MissingFieldException;
import cpts451.ecomm.repositories.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateAdminAccountServiceImpl implements CreateAdminAccountService {

    private final AdminRepository adminRepository;

    public CreateAdminAccountServiceImpl(AdminRepository adminRepository)
    {
        this.adminRepository = adminRepository;
    }

    @Override
    public void CreateNewAccount(Admin newAdmin)
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

        adminRepository.save(newAdmin);
    }
}
