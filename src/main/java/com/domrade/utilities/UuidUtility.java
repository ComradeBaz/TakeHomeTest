/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.utilities;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author David
 */
@Component
public class UuidUtility {
    
    @Autowired
    private UserInputUtility userInputUtility;
    
    // Prompt the user to enter the UUID of the entity to be retrieved
    public UUID getUuid(String prompt) {
        UUID id = null;
        boolean isValidId = false;

        // Check that the UUID is valid before returning the ID
        while (!isValidId) {
            String uuid = userInputUtility.getUserInput(prompt);
            isValidId = this.getIsValidId(uuid);
            if(!isValidId) {
                prompt = "Please Enter a valid Id";
            } else {
                id = UUID.fromString(uuid);
            }
        }

        return id;
    }

    // Check the UUID to see if it is valid
    public boolean getIsValidId(String uuid) {
        try {
            UUID id = UUID.fromString(uuid);
            return true;
        } catch (IllegalArgumentException ia) {
            return false;
        }
    }
    
    
    
}
