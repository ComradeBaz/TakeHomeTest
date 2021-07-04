package com.domrade.app;

import com.domrade.controllers.MainController;
import com.domrade.models.Person;
import com.domrade.services.PersonService;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.domrade"})
@EntityScan(basePackages = {"com.domrade.models"})
@EnableJpaRepositories(basePackages = {"com.domrade.repositories"})
@SpringBootApplication
public class AppApplication implements CommandLineRunner {
    
    private static boolean isProd = false;

    @Autowired
    private MainController mainController;

    private static final Logger LOG = LoggerFactory
            .getLogger(AppApplication.class);

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        if(args.length > 0) {
            if (args[0].equalsIgnoreCase("prod")) {
                isProd = true;
            }
        }
        SpringApplication.run(AppApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) { 
        // This is a workaround to fix the issue described @ https://gangmax.me/blog/2019/11/12/spring-boot-unit-test-hang-issue/
        // That workaround didn't work for me
        if (isProd) {
            LOG.info("About to start user interface");
            mainController.startInterface();
        }
    }
}
