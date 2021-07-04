package com.domrade.app;

import com.domrade.models.Address;
import com.domrade.models.Person;
import com.domrade.services.AddressService;
import com.domrade.services.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AppApplicationTest {

    @Autowired
    private PersonService personService;
    
    @Autowired
    private AddressService addressService;
    
    private Person person;
    private Address address;
    private long originalCountOfPersons;
    private long originalCountOfAddresses;
    
    @BeforeEach
    public void init() {
        originalCountOfPersons = personService.getCountOfPersons();
        originalCountOfAddresses = addressService.getCountOfAddresses();
        person = new Person("testFirstName", "testLastName");
        // Get the db object so I can access the UUID
        person = personService.savePerson(person);        
    }

    @Test
    public void testAddPerson() {          
        // Count of Persons should increase by 1
        Assertions.assertEquals(originalCountOfPersons + 1, personService.getCountOfPersons());
    }

    @Test
    public void testDeletePerson() {
        Assertions.assertEquals(originalCountOfPersons + 1, personService.getCountOfPersons());
        personService.deletePersonById(person.getUuid());
        Assertions.assertEquals(originalCountOfPersons, personService.getCountOfPersons());
    }
    
    @Test
    public void testAddAddress() {
        address = new Address(person, "testStreet", "testCity", "testState", "testPostalCode");
        address = addressService.saveAddress(address);
        Assertions.assertEquals(originalCountOfAddresses + 1, addressService.getCountOfAddresses());
    }

    @Test
    public void testDeleteAddress() {
        address = new Address(person, "testStreet", "testCity", "testState", "testPostalCode");
        address = addressService.saveAddress(address);
        Assertions.assertEquals(originalCountOfAddresses + 1, addressService.getCountOfAddresses());
        addressService.deleteAddressById(address.getId());
        Assertions.assertEquals(originalCountOfAddresses, addressService.getCountOfAddresses());
    }
}
