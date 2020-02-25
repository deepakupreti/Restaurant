package com.example.restaurant.model.response;

import com.example.restaurant.model.entity.Dish;
import com.example.restaurant.model.enums.OrderStatus;
import io.swagger.models.auth.In;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
public class OrderResponse {

    OrderStatus orderStatus;
    Integer orderPrice;
    Integer OrderId;
    List<Integer> dishes;
    LocalDateTime orderTime;
    LocalDateTime estimatedDeliveryTime;

}
