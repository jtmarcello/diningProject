package com.dining.diningProject.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dining.diningProject.Repositories.RestaurantRepository;
import com.dining.diningProject.Entities.Restaurant;
import com.dining.diningProject.Entities.DiningReview;

import java.util.Optional;
import java.util.List;
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    
    private RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
    
    @PostMapping
    public ResponseEntity<?> createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant newRestaurant = restaurant;

        if (restaurantRepository.existsByNameAndZipCode(
            restaurant.getName(),
            restaurant.getZipCode())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    "A restaurant with that name and zipcode already exists"
                );
        }

        this.restaurantRepository.save(newRestaurant);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRestaurant);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRestaurant(@PathVariable Long id) {
        Optional<Restaurant> restaurantOptional = this.restaurantRepository.findById(id);

        if (!restaurantOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Restaurant with that ID");
        }

        Restaurant restaurant = restaurantOptional.get();
        return ResponseEntity.status(HttpStatus.OK).body(restaurant);
    }

    @GetMapping
    public List<Restaurant> getRestaurantsByZipAndAllergy(
        @RequestParam Integer zipCode,
        @RequestParam Restaurant.AllergyCategory allergy
    ) {
        var status = DiningReview.Status.ACCEPTED;

        return switch (allergy) {
            case PEANUT ->
                restaurantRepository.findPeanutRestaurantsByZip(zipCode, status);
            case EGG ->
                restaurantRepository.findEggRestaurantsByZip(zipCode, status);
            case DAIRY ->
                restaurantRepository.findDairyRestaurantsByZip(zipCode, status);
        };
    }
    
}
