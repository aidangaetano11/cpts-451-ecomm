package cpts451.ecomm.services;

import cpts451.ecomm.entities.Address;
import cpts451.ecomm.repositories.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address find(int id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address save(Address admin) {
        return addressRepository.save(admin);
    }

    @Override
    public void deleteById(int id) { addressRepository.deleteById(id); }
}
