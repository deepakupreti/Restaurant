package com.example.restaurant.controller;

import com.example.restaurant.constants.Status;
import com.example.restaurant.model.response.BaseResponse;
import com.example.restaurant.model.response.RestaurantResponse;
import com.example.restaurant.service.RestaurantService;
import com.example.restaurant.service.impl.OrderServiceImpl;
import com.example.restaurant.service.impl.RestaurantServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@RequestMapping("/restaurant")
@Validated
@Slf4j
public class RestaurantController {

    @Autowired
    RestaurantServiceImpl restaurantService;

    // to get list of restaurants given pincode
    @GetMapping(value = "/getRestaurants", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<List<RestaurantResponse>>>getRestaurant(
            @RequestParam
            @Pattern(regexp = "^[1-9][0-9]{5}$", message = "INVALID PINCODE") String pincode
    ){
        List<RestaurantResponse> restaurantIds = restaurantService.getRestaurants(Integer.parseInt(pincode));

        return new ResponseEntity<>(
                new BaseResponse<>(
                        Status.SUCCESS,
                        restaurantIds
                ),
                HttpStatus.OK
        );
    }
}
