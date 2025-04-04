package cpts451.ecomm.services;

import cpts451.ecomm.entities.Admin;
import cpts451.ecomm.repositories.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    private AdminRepository adminRepository;

    /**
     * Initializes a new AdminServiceImpl
     * @param adminRepository the admin repository
     */
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    /**
     * finds an admin via id
     * @param id the admin id
     * @return an Admin if found, otherwise null
     */
    @Override
    public Admin find(int id) {
        return adminRepository.findById(id).orElse(null);
    }

    /**
     * finds all admins
     * @return a collection of admins
     */
    @Override
    public Iterable<Admin> findAll() {
        return adminRepository.findAll();
    }

    /**
     * saves an Admin to the repository
     * @param admin the admin we're saving
     * @return the admin we just saved
     */
    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    /**
     * deletes an Admin from the repository
     * @param id the id of the admin to delete
     */
    @Override
    public void deleteById(int id) { adminRepository.deleteById(id); }
}
