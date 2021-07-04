/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.controllers;

import com.domrade.models.Person;
import com.domrade.services.PersonService;
import com.domrade.utilities.UserInputUtility;
import com.domrade.utilities.UuidUtility;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

/**
 *
 * @author David
 */
@Component
public class PersonController {

    private static final Logger LOG = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    @Autowired
    private UserInputUtility userInputUtility;

    @Autowired
    private UuidUtility uuidUtility;

    public PersonController() {

    }

    public void addPerson() {
        String firstName = userInputUtility.getUserInput("Enter First Name: ");
        if (firstName.length() == 0) {
            firstName = userInputUtility.getUserInput("First Name is Required - Enter First Name");
        }
        String lastName = userInputUtility.getUserInput("Enter Last Name: ");
        if (lastName.length() == 0) {
            lastName = userInputUtility.getUserInput("Last Name is Required - Enter Last Name");
        }

        Person person = new Person(firstName, lastName);
        personService.savePerson(person);
    }

    public UUID getPersonById() {
        return uuidUtility.getUuid("Enter Person UUID to Search");
    }

    public void deletePerson() {
        UUID id = uuidUtility.getUuid("Enter Person UUID to Delete");
        try {
            personService.deletePersonById(id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("ID Not Found\n");
        }
    }

    public void editPerson() {
        Person p;
        UUID id = uuidUtility.getUuid("Enter Person UUID to Edit");
        try {
            p = personService.getPersonById(id);
        } catch (EntityNotFoundException e) {
            System.out.println("ID Not Found\n");
            return;
        }
        String updatedFirstName = userInputUtility.getUserInput("Edit First Name or press Enter to leave unchanged");
        String updatedLastName = userInputUtility.getUserInput("Edit Last Name or press Enter to leave unchanged");

        if (updatedFirstName.length() > 0) {
            p.setFirstName(updatedFirstName);
        }
        if (updatedLastName.length() > 0) {
            p.setLastName(updatedLastName);
        }
        personService.savePerson(p);
    }

    public void listPersons() {
        List<Person> persons = personService.getAllPersons();
        for (Person p : persons) {
            System.out.println("ID:\t\t\t\t\t" + p.getUuid() + "\nFirst Name:\t\t\t\t" + p.getFirstName() + "\nLast Name:\t\t\t\t" + p.getLastName());
            System.out.println();
        }

    }

    public void showCountOfPersons() {
        System.out.println("\nThere are " + Long.toString(personService.getCountOfPersons()) + " persons in the database");
    }

}
