/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services;

import com.domrade.models.Address;
import com.domrade.repositories.AddressRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David
 */
@Service
public class AddressService {
    
    @Autowired
    private AddressRepository addressRepository;
    
    public Address getAddressById(UUID id) {
        return addressRepository.getById(id);
    }
    
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }
    
    public void deleteAddressById(UUID id) {
        addressRepository.deleteById(id);
    }
    
    public List<Address> listAddresses() {
        return addressRepository.findAll();
    }
    
    public long getCountOfAddresses() {
        return addressRepository.count();
    }
    
}
