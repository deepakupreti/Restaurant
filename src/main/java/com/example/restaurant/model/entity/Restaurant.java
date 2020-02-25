package com.example.restaurant.model.entity;

import com.example.restaurant.model.enums.CUISINE;
import com.example.restaurant.model.enums.Days;
import com.example.restaurant.model.enums.Rating;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.models.auth.In;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalTime;

//this entity annotation is from spring-boot-starter-jpa dependency
@Entity
@Table(name = "restaurant")
@Data
public class Restaurant {

    @Id
    Integer id;

    @Column(name = "name", nullable = false)
    String name;

    @Column
    Integer pincode;

    @Column(name = "menu_id", nullable = false)
    Integer menuId;

    @Enumerated(EnumType.STRING)
    @Column
    Rating rating;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "opening_time")
    LocalTime openingTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "closing_time")
    LocalTime closingTime;

    @Column(name = "day_off")
    @Enumerated(EnumType.STRING)
    Days dayOff;

    @Enumerated(EnumType.STRING)
    CUISINE cuisine;


    @Column(name = "delivery_charges")
    Integer deliveryCharges;

//    String website;
//
//    double lattitude;
//    double longitude;
//    String city;
//    String state;
//
//
//
////    @Column(name = "menu_id" , nullable = false)
//    Integer menuId;

}
