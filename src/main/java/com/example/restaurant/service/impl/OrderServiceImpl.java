package com.example.restaurant.service.impl;

import com.example.restaurant.converter.OrderResponseConverter;
import com.example.restaurant.exception.CustomExceptions;
import com.example.restaurant.model.entity.*;
import com.example.restaurant.model.enums.OrderStatus;
import com.example.restaurant.model.enums.PaymentMode;
import com.example.restaurant.model.enums.PaymentStatus;
import com.example.restaurant.model.response.OrderResponse;
import com.example.restaurant.model.response.RestaurantResponse;
import com.example.restaurant.repository.*;
import com.example.restaurant.service.OrderService;
import com.example.restaurant.utils.ObjectConverter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Value("${restaurant.open.order.max}")
    private Integer maxOpenOrdersLimit;

    @Autowired
    RestaurantRepository restaurantRepository;


    @Autowired
    RestaurantOrderRepository restaurantOrderRepository;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    DishRepository dishRepository;

    @Autowired
    CustomerOrderRepository customerOrderRepository;


    public List<Dish> getMenu(int restaurantId){
        Menu menu = menuRepository.findByRestaurantId(restaurantId);
        List<Dish> dishes = Collections.EMPTY_LIST;
        if(menu !=null){
            List<Integer> dishIds = menu.getDishes();
            dishes = dishRepository.getDishesbyIds(dishIds);
        }
        return dishes ;
    }

    public OrderResponse placeOrder(Integer restaurantId, String dish, Integer customerId, PaymentMode paymentMode){
        List<Integer> dishesIds = getDishList(dish);
        int orderPrice = calculateOrderPrice(dishesIds);
        List<RestaurantOrder> restaurantOrderList = restaurantOrderRepository.findAllByPreparationTimeAfterAndRestaurantId(LocalDateTime.now(), restaurantId);

        if(restaurantOrderList.size() == maxOpenOrdersLimit){
            throw new CustomExceptions.MaximumOrderLimitBreachedException("restaurants order limit breached "+ restaurantOrderList.size());
        }
        if(!isRestaurantOpen(restaurantId)){
            throw new CustomExceptions.RestaurantClosedException("restaurant is closed kindly come later");
        }

        CustomerOrder customerOrder = new CustomerOrder();

        customerOrder.setCustomerId(customerId);
        customerOrder.setDeliveryTime(LocalDateTime.now());
        customerOrder.setOrderPrice(orderPrice);
        customerOrder.setDishes(dishesIds);
        customerOrder.setOrderTime(LocalDateTime.now());
        customerOrder.setOrderStatus(OrderStatus.CREATED);
        customerOrder.setPaymentMode(paymentMode);
        customerOrder.setPaymentStatus(PaymentStatus.COMPLETED);
        customerOrder.setRestaurantId(restaurantId);
        customerOrderRepository.save(customerOrder);

        RestaurantOrder restaurantOrder = new RestaurantOrder(customerOrder.getId(), restaurantId, LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(1));
        restaurantOrderRepository.save(restaurantOrder);

        return OrderResponseConverter.getOrderResponse(customerOrder);
    }


    public boolean isRestaurantOpen(int restaurantId){
        Restaurant restaurant = restaurantRepository.findRestaurantById(restaurantId);
        LocalTime currentTime = LocalTime.now();
        if(currentTime.compareTo(restaurant.getOpeningTime()) >=0 && currentTime.compareTo(restaurant.getClosingTime())<=0){
            return true;
        }
        return false;
    }
    public int calculateOrderPrice(List<Integer> dishIds){
        List<Dish> dishes = dishRepository.getDishesbyIds(dishIds);
        int orderPrice =0;
        Iterator<Dish> it = dishes.iterator();
        while(it.hasNext()){
            orderPrice += it.next().getPrice();
        }
        return orderPrice;
    }
    public List<Integer> getDishList(String dish){
        List<Integer> dishes= Stream.of(dish.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return dishes;
    }

    public String getdishes (List<Dish> dishes){
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Dish> iterator = dishes.iterator();
        while (iterator.hasNext()){
            stringBuilder.append(iterator.next());
        }
        return stringBuilder.toString();
    }

    public CustomerOrder getOrderStatus(int orderId){
        return customerOrderRepository.findById(orderId);
    }

}
