/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.repositories;

import com.domrade.models.Person;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author David
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
    
}
