package io.restaurant.manager;

import io.restaurant.manager.services.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sun.tools.jar.CommandLine;

import java.util.Scanner;

@SpringBootApplication
public class ManagerApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(ManagerApplication.class);

    @Autowired
    private RestaurantService service;

    public static void main(String[] args) {
        LOG.info("Application starting up");
        SpringApplication.run(ManagerApplication.class, args);
        LOG.info("Application finished");
    }

    @Override
    public void run(String... args) throws Exception {
        service.printMenu();
    }
}
