/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.utilities;

import java.util.Scanner;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author David
 */
@Component
public class UserInputUtility {
    
    @Autowired
    private UuidUtility uuidUtility;
    
    // Prompt the user for input and return that input
    public String getUserInput(String prompt) {
        Scanner myObj = new Scanner(System.in);  
        System.out.println(prompt);

        String userInput = myObj.nextLine();  

        return userInput;
    }
    
    // Prompt the user to enter the UUID of the entity to be retrieved
    public UUID getUuid(String prompt) {
        UUID id = null;
        boolean isValidId = false;

        // Check that the UUID is valid before returning the ID
        while (!isValidId) {
            String uuid = this.getUserInput(prompt);
            isValidId = uuidUtility.getIsValidId(uuid);
            if(!isValidId) {
                prompt = "Please Enter a valid Id";
            } else {
                id = UUID.fromString(uuid);
            }
        }

        return id;
    }
    
}
