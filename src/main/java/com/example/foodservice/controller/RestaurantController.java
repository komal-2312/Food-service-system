package com.example.foodservice.controller;

import com.example.foodservice.model.Restaurant;
import com.example.foodservice.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant createdRestaurant = restaurantService.createRestaurant(restaurant);
        return ResponseEntity.ok(createdRestaurant);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long id) {
        Restaurant restaurant = restaurantService.getRestaurantById(id);
        return ResponseEntity.ok(restaurant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurantDetails) {
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(id, restaurantDetails);
        return ResponseEntity.ok(updatedRestaurant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }
}