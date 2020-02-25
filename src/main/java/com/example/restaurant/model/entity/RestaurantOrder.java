package com.example.restaurant.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "restaurant_order")
public class RestaurantOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "order_id", nullable = false)
    Integer orderId;

    @Column(name = "restaurant_id", nullable = false)
    Integer restaurantId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "order_time")
    LocalDateTime orderTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "preparation_time")
    LocalDateTime preparationTime;

    public RestaurantOrder(){

    }
    public RestaurantOrder(int orderId, int restaurantId, LocalDateTime orderTime, LocalDateTime preparationTime){
        this.orderId = orderId;
        this.restaurantId = restaurantId;
        this.orderTime = orderTime;
        this.preparationTime = preparationTime;
    }
}
