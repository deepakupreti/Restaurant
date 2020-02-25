package com.example.restaurant.converter;

import com.example.restaurant.model.entity.CustomerOrder;
import com.example.restaurant.model.response.OrderResponse;

public class OrderResponseConverter {
    public static OrderResponse getOrderResponse(CustomerOrder customerOrder){
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderStatus(customerOrder.getOrderStatus());
        orderResponse.setEstimatedDeliveryTime(customerOrder.getEstimatedDeliveryTime());
        orderResponse.setOrderId(customerOrder.getId());
        orderResponse.setOrderTime(customerOrder.getOrderTime());
        orderResponse.setOrderPrice(customerOrder.getOrderPrice());

        orderResponse.setDishes(customerOrder.getDishes());
        return orderResponse;
    }
}
