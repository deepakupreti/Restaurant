package com.example.restaurant.service;

import com.example.restaurant.model.response.RestaurantResponse;

import java.util.List;

public interface RestaurantService {
    public List<RestaurantResponse> getRestaurants(int pincode);

}
