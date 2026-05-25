package com.talkevents.mongodb.service;

import com.talkevents.mongodb.document.Address;
import com.talkevents.mongodb.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public Address getById(String id) {
        return addressRepository.findById(id).orElse(null);
    }

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public void update(Address address) {
        var addressToUpdate = getById(address.getId());

        if (addressToUpdate == null)
            return;

        addressToUpdate.setStreet(address.getStreet());
        addressToUpdate.setCity(address.getCity());
        addressToUpdate.setCountry(address.getCountry());
        addressRepository.save(addressToUpdate);
    }

    public void delete(String id) {
        addressRepository.deleteById(id);
    }
}
