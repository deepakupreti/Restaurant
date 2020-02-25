package com.example.restaurant.utils;

import com.example.restaurant.model.response.RestaurantResponse;

import java.util.ArrayList;
import java.util.List;

public class ObjectConverter {
    public static List<RestaurantResponse> getRestaurantObject(List<com.example.restaurant.model.entity.Restaurant> restaurants){
        List<RestaurantResponse> restaurants1 = new ArrayList<>();
        for(com.example.restaurant.model.entity.Restaurant restaurant1 :restaurants){
            RestaurantResponse restaurant = new RestaurantResponse();
            restaurant.setRestaurantId(restaurant1.getId());
            restaurant.setRestaurantName(restaurant1.getName());
            restaurants1.add(restaurant);

        }
        return restaurants1;
    }
}
