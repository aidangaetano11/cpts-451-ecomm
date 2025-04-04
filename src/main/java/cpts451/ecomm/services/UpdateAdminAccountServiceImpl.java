package cpts451.ecomm.services;

import cpts451.ecomm.entities.Admin;
import cpts451.ecomm.entities.Customer;
import cpts451.ecomm.exceptions.ExistingAttributeException;
import cpts451.ecomm.exceptions.MissingFieldException;
import cpts451.ecomm.repositories.AdminRepository;
import cpts451.ecomm.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateAdminAccountServiceImpl implements UpdateAdminAccountService {

    private final AdminRepository adminRepository;
    private final UserRepository userRepository;

    public UpdateAdminAccountServiceImpl(AdminRepository adminRepository, UserRepository userRepository)
    {
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void UpdateAdminAccount(Admin admin, int userId)
    {
        ValidateNullFields(admin);
        ValidateExistingFields(admin, userId);

        admin.setId(userId);
        admin.setRole("ADMIN");

        adminRepository.save(admin);
    }

    private void ValidateNullFields(Admin updateAdmin)
    {
        if (updateAdmin.getFirstName() == null || updateAdmin.getFirstName().trim().isEmpty())
        {
            throw new MissingFieldException("First name is required");
        }

        if (updateAdmin.getLastName() == null || updateAdmin.getLastName().trim().isEmpty())
        {
            throw new MissingFieldException("Last name is required.");
        }

        if (updateAdmin.getEmail() == null || updateAdmin.getEmail().trim().isEmpty())
        {
            throw new MissingFieldException("email is required.");
        }

        if (updateAdmin.getPhoneNumber() == null || updateAdmin.getPhoneNumber().trim().isEmpty())
        {
            throw new MissingFieldException("phone number is required.");
        }
    }

    private void ValidateExistingFields(Admin admin, int userId)
    {
        if (userRepository.findByEmail(admin.getEmail()) != null)
        {
            if (userRepository.findById(userId) != userRepository.findByEmail(admin.getEmail()))
            {
                throw new ExistingAttributeException("email already exists");
            }
        }

        if (userRepository.findByPhoneNumber(admin.getPhoneNumber()) != null)
        {
            if (userRepository.findById(userId) != userRepository.findByPhoneNumber(admin.getPhoneNumber()))
            {
                throw new ExistingAttributeException("phone number already exists");
            }
        }
    }
}
