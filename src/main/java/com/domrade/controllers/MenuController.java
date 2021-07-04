/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.controllers;

import java.util.Scanner;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author David
 */
@Component
public class MenuController {

    public static final String MAIN_MENU = "1. Add Person\n"
            + "2. Edit Person\n"
            + "3. Delete Person\n"
            + "4. Add Address to Person\n"
            + "5. Edit Address\n"
            + "6. Delete Address\n"
            + "7. Count Number of Persons\n"
            + "8. List Persons\n"
            + "9. List Addresses\n\n";

    @Autowired
    private PersonController personController;

    @Autowired
    private AddressController addressController;

    public MenuController() {

    }

    public void showMenu() {
        System.out.println(MAIN_MENU);
    }

    public void getUserChoice() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter 1-9 to perform an action");

        int userChoice;

        try {
            userChoice = Integer.parseInt(myObj.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("Please choose a menu item 1-9");
            return;
        }

        switch (userChoice) {
            case 1:
                // Add Person
                personController.addPerson();
                break;
            case 2:
                // Edit Person
                personController.editPerson();
                break;
            case 3:
                // Delete Person
                personController.deletePerson();
                break;
            case 4:
                // Add Address to Person
                addressController.addAddressToPerson();
                break;
            case 5:
                // Edit Address
                addressController.editAddress();
                break;
            case 6:
                // Delete Address
                addressController.deleteAddress();
                break;
            case 7:
                // Show Count of Persons
                personController.showCountOfPersons();
                break;
            case 8:
                // List Persons
                personController.listPersons();
                break;
            case 9:
                // List Addresses
                addressController.listAddress();
                break;
        }
    }
}
