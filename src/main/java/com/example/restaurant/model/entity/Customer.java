package com.example.restaurant.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Data
@Table( name = "customer")
public class Customer {

    @Id
    int id;

    String name;

    @Column(name= "phone_number")
    int phoneNumber;

    @Column
    String address;

}
