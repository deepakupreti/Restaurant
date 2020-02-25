package com.example.restaurant.model.entity;

import com.example.restaurant.model.enums.DishType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "dish")
@Data
public class Dish {
    @Id
    @Column
    Integer id;

    @Column(nullable = false)
    Integer price;

    @Column
    String name;

    @Column(name = "dish_type")
    @Enumerated(EnumType.STRING)
    DishType dishType;
}
