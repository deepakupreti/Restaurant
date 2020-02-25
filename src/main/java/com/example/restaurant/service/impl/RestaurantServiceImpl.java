package com.example.restaurant.service.impl;

import com.example.restaurant.constants.EntityConstants;
import com.example.restaurant.model.entity.CustomerOrder;
import com.example.restaurant.model.entity.Restaurant;
import com.example.restaurant.model.response.RestaurantResponse;
import com.example.restaurant.repository.CustomerOrderRepository;
import com.example.restaurant.repository.RestaurantRepository;
import com.example.restaurant.service.RestaurantService;
import com.example.restaurant.utils.ObjectConverter;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    CustomerOrderRepository customerOrderRepository;

    public List<RestaurantResponse> getRestaurants(int pincode){
        List<Restaurant> restaurants = restaurantRepository.findRestaurantByPincode(pincode);
        List<RestaurantResponse> restaurantResponse= ObjectConverter.getRestaurantObject(restaurants);
        return restaurantResponse;
    }
}
