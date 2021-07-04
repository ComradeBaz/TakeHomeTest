/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.controllers;

import com.domrade.models.Address;
import com.domrade.models.Person;
import com.domrade.services.AddressService;
import com.domrade.services.PersonService;
import com.domrade.utilities.UserInputUtility;
import com.domrade.utilities.UuidUtility;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

/**
 *
 * @author David
 */
@Component
public class AddressController {

    @Autowired
    private PersonService personService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private UserInputUtility userInputUtility;

    @Autowired
    private UuidUtility uuidUtility;

    public AddressController() {

    }

    public void addAddressToPerson() {
        // Get the UUID of the Person for whom the address will be added
        UUID id = uuidUtility.getUuid("Enter Person UUID to add Address");
        Person p = personService.getPersonById(id);
        String street = userInputUtility.getUserInput("Enter Street:");
        if (street.length() == 0) {
            street = userInputUtility.getUserInput("Street Address is Required - Please Enter Street Address");
        }
        String city = userInputUtility.getUserInput("Enter City:");
        if (city.length() == 0) {
            city = userInputUtility.getUserInput("City is Required - Please Enter a City");
        }
        String state = userInputUtility.getUserInput("Enter State:");
        if (state.length() == 0) {
            state = userInputUtility.getUserInput("State is Required - Please Enter a State");
        }
        String postalCode = userInputUtility.getUserInput("Enter PostalCode:");
        if (postalCode.length() == 0) {
            postalCode = userInputUtility.getUserInput("PostalCode is Required - Please Enter a Postal Code");
        }

        Address address = new Address(p, street, city, state, postalCode);
        addressService.saveAddress(address);
    }

    public void editAddress() {
        // Get the UUID of the Address to be edited
        UUID id = uuidUtility.getUuid("Enter Address UUID to Edit");
        Address a;
        try {
            a = addressService.getAddressById(id);
        } catch (EntityNotFoundException e) {
            System.out.println("ID Not Found\n");
            return;
        }

        String updatedStreet = userInputUtility.getUserInput("Edit Street or press Enter to leave unchanged");
        if (updatedStreet.length() > 0) {
            a.setStreet(updatedStreet);
        }
        String updatedCity = userInputUtility.getUserInput("Edit City or press Enter to leave unchanged");
        if (updatedCity.length() > 0) {
            a.setCity(updatedCity);
        }
        String updatedState = userInputUtility.getUserInput("Edit State or press Enter to leave unchanged");
        if (updatedState.length() > 0) {
            a.setAddressState(updatedState);
        }
        String updatedPostalCode = userInputUtility.getUserInput("Edit PostalCode or press Enter to leave unchanged");
        if (updatedPostalCode.length() > 0) {
            a.setPostalCode(updatedPostalCode);
        }

        addressService.saveAddress(a);
    }

    public void deleteAddress() {
        UUID id = uuidUtility.getUuid("Enter Address UUID to Delete");
        try {
            addressService.deleteAddressById(id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("ID Not Found\n");
        }
    }

    public void listAddress() {
        List<Address> myList = addressService.listAddresses();
        for (Address a : myList) {
            System.out.println("ID:\t\t\t\t\t" + a.getId() + "\nStreet:\t\t\t\t\t" + a.getStreet() + "\nCity:\t\t\t\t\t" + a.getCity() + "\nState:\t\t\t\t\t"
                    + a.getAddressState() + "\nPostalCode:\t\t\t\t" + a.getPostalCode());
            System.out.println();
        }
    }
}
