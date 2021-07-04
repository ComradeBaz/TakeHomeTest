/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services;

import com.domrade.models.Person;
import com.domrade.repositories.PersonRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person getPersonById(UUID id) {
        return personRepository.getById(id);
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePersonById(UUID id) {
        personRepository.deleteById(id);
    }

    public long getCountOfPersons() {
        return personRepository.count();
    }
    
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}
