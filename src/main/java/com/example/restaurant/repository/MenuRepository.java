package com.example.restaurant.repository;

import com.example.restaurant.model.entity.Menu;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    Menu findByRestaurantId(int id);

}
