package com.example.restaurant.model.entity;

import com.example.restaurant.converter.IntegerListConverter;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString
public class Menu {
    @Id
    Integer id;

    @Column(name ="restaurant_id", nullable = false)
    Integer restaurantId;

    @Column
    @Convert(converter = IntegerListConverter.class)
    List<Integer> dishes;

}
