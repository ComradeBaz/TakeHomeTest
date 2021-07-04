/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author David
 */
@Component
public class MainController {

    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private MenuController menuController;

    @Autowired
    private PersonController personController;

    public MainController() {

    }

    public void startInterface() {

        while (true) {
            menuController.showMenu();
            menuController.getUserChoice();
        }
        //LOG.info(Integer.toString(menuController.getUserChoice()));
        // Get user choice
        //int userChoice = menuController.getUserChoice();

        //personController.addPerson();
    }
}
