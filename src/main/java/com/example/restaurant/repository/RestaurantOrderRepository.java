package com.example.restaurant.repository;

import com.example.restaurant.model.entity.RestaurantOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface RestaurantOrderRepository extends JpaRepository<RestaurantOrder, Integer> {

    List<RestaurantOrder> findAllByPreparationTimeAfterAndRestaurantId(LocalDateTime localDateTime, int restaurantId);

}
