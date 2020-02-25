package com.example.restaurant.service;

import com.example.restaurant.model.entity.Dish;
import com.example.restaurant.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    @Autowired
    DishRepository dishRepository;

    public List<Dish> getDishes(List<Integer> dishIds){
        return dishRepository.getDishesbyIds(dishIds);
    }


}
