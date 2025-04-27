package cpts451.ecomm.services;

import cpts451.ecomm.entities.Address;

public interface AddressService {
    public Address find(int id);

    public Iterable<Address> findAll();

    public Address save(Address admin);

    public void deleteById(int id);
}
