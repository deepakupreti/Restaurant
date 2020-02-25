package com.example.restaurant.model.entity;
import com.example.restaurant.converter.IntegerListConverter;
import com.example.restaurant.model.enums.OrderStatus;
import com.example.restaurant.model.enums.PaymentMode;
import com.example.restaurant.model.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "customer_order")
@Entity
@Data
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Integer id;

    @Column(name = "restaurant_id", nullable = false)
    Integer restaurantId;

    @Column(name = "customer_id")
    Integer customerId;
//
    @Column(name = "order_price")
    Integer orderPrice;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "order_time")
    LocalDateTime orderTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "delivery_time")
    LocalDateTime deliveryTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "estimated_delivery_time")
    LocalDateTime estimatedDeliveryTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_mode")
    PaymentMode paymentMode;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status")
    PaymentStatus paymentStatus;

    @Column
    @Convert(converter = IntegerListConverter.class)
    List<Integer> dishes;

//    @JoinColumn(insertable = false, updatable = false)
//    @ManyToOne
//    Customer customer;

}


