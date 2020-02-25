package com.example.restaurant.repository;

import com.example.restaurant.model.entity.Dish;
import com.example.restaurant.model.entity.Restaurant;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    List<Restaurant> findByPincode(int pincode);

    Restaurant findRestaurantById(int restauranId);

    @Query(name = "select * from Restaurant rt where rt.pincode = ?1",  nativeQuery=true)
    List<Restaurant> findRestaurantByPincode(Integer id);

}
