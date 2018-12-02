package io.restaurant.manager.services;

import io.restaurant.manager.ManagerApplication;
import io.restaurant.manager.models.Dish;
import io.restaurant.manager.repositories.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RestaurantService {

    private static final Logger LOG = LoggerFactory.getLogger(ManagerApplication.class);

    @Autowired
    private RestaurantRepository repository;

    public void printMenu() {
        Scanner scn = new Scanner(System.in);
        while (true) {
            LOG.info("====================");
            LOG.info("Press c to stop");
            LOG.info("Press 1 to add dish");
            LOG.info("Press 2 to get list dishes");
            LOG.info("====================");
            String option = scn.nextLine();
            switch (option) {
                case "1":
                    LOG.info("Enter name: ");
                    String dishName = scn.nextLine();
                    LOG.info("Created " + createDish(dishName));
                    break;
                case "2":
                    printListDishes();
                    break;
                case "c":
                    return;
            }
        }
    }

    public Dish createDish(String name) {
        Dish dish = new Dish();
        dish.setName(name);
        return repository.save(dish);
    }

    public void printListDishes() {
        LOG.info("====================");
        LOG.info("LISTING DISH");
        List<Dish> all = repository.findAll();
        all.forEach(d -> {
            LOG.info(d.toString());
        });
        LOG.info("====================");
    }

}
