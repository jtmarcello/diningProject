package com.dining.diningProject.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.dining.diningProject.Entities.Restaurant;

import java.util.Optional;


public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    Optional<Restaurant> findByZipAndAtLeastOneScore(Integer ZipCode, Restaurant.AllergyCategory category);
}
