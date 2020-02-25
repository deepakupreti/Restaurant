package com.example.restaurant.repository;

import com.example.restaurant.model.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish,Integer> {


    @Query("SELECT ds FROM Dish ds Where ds.id in (:dishIds)")
    public List<Dish> getDishesbyIds (@Param("dishIds") List<Integer> dishIds);

}
