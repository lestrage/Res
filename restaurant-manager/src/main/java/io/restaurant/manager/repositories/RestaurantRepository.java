package io.restaurant.manager.repositories;

import io.restaurant.manager.models.Dish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends CrudRepository<Dish, Integer> {

    List<Dish> findAll();

}
