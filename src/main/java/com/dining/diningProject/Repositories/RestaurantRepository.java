package com.dining.diningProject.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.dining.diningProject.Entities.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    
}
