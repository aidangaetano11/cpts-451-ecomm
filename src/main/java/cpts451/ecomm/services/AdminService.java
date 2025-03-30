package cpts451.ecomm.services;

import cpts451.ecomm.entities.Admin;

public interface AdminService {
    public Admin find(int id);

    public Iterable<Admin> findAll();

    public Admin save(Admin admin);
}
