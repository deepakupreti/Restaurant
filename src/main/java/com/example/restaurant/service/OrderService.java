package com.example.restaurant.service;

import com.example.restaurant.model.entity.CustomerOrder;
import com.example.restaurant.model.entity.Dish;
import com.example.restaurant.model.enums.PaymentMode;
import com.example.restaurant.model.response.OrderResponse;
import io.swagger.models.auth.In;

import java.util.List;

public interface OrderService {
    public OrderResponse placeOrder(Integer restaurantId, String dish, Integer customerId, PaymentMode paymentMode);
    public List<Dish> getMenu(int restaurantId);
    public CustomerOrder getOrderStatus(int orderId);
}
