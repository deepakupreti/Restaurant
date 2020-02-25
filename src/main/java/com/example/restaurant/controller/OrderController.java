package com.example.restaurant.controller;


import com.example.restaurant.constants.Status;
import com.example.restaurant.model.entity.CustomerOrder;
import com.example.restaurant.model.response.BaseResponse;
import com.example.restaurant.model.response.OrderResponse;
import com.example.restaurant.model.entity.Dish;
import com.example.restaurant.model.enums.PaymentMode;
import com.example.restaurant.repository.DishRepository;
import com.example.restaurant.service.impl.OrderServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated // if i remove this condition alone, then even tough pattern is given in controller method but still error wont be shown and it will wor properly

@RequestMapping("/order")
@Api(value = "get-order", description = "restaurant api",tags = "Order-Controller")
public class OrderController {

    @Autowired
    OrderServiceImpl orderServiceImpl;

    @Autowired
    DishRepository dishRepository;

    // to see menu
    @GetMapping(value = "/menu", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity< BaseResponse <List<Dish> > >getmenu(
            @RequestParam(required = true) Integer restaurantId
    ){
        List<Dish> dishes = orderServiceImpl.getMenu(restaurantId);
        return new ResponseEntity<>(
                new BaseResponse<>(
                        Status.SUCCESS,
                        dishes
                ),
                HttpStatus.OK
        );
    }


    @GetMapping(value = "/placeorder", produces = MediaType.APPLICATION_JSON_VALUE)
     public ResponseEntity< BaseResponse <OrderResponse > > placeOrder(
            @RequestParam(required = true) Integer restaurantId,
            @RequestParam(required = true) String dishIds,
            @RequestParam(required = true) Integer customerId,
            @RequestParam(required =true )PaymentMode paymentMode
            )
    {
            OrderResponse orderResponse= orderServiceImpl.placeOrder(restaurantId,dishIds,customerId,paymentMode);
             return new ResponseEntity<>(
                    new BaseResponse<>(
                            Status.SUCCESS,
                            orderResponse
                    ),
                    HttpStatus.OK
            );

    }

    @GetMapping(value = "/getorderstatus", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity< BaseResponse <CustomerOrder > > getOrderStatus(
            @RequestParam(required = true) Integer orderId
    ){
       CustomerOrder customerOrder = orderServiceImpl.getOrderStatus(orderId);
        return new ResponseEntity<>(
                new BaseResponse<>(
                        Status.SUCCESS,
                        customerOrder
                ),
                HttpStatus.OK
        );
    }
}
