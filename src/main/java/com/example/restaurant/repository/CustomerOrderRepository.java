package com.example.restaurant.repository;

import com.example.restaurant.model.entity.CustomerOrder;
import com.example.restaurant.model.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Integer> {
    CustomerOrder findById(int id);
}
