package com.example.restaurant.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Bean
    @Profile("dev")
    @Primary
    public DataSource geth2DataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:deepak");
        return dataSourceBuilder.build();
    }


    @Bean("mySqlDataSource")
    @Profile("dev")
    public DataSource getMysqlDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/restaurant_db");
        dataSourceBuilder.username("deepak");
        dataSourceBuilder.password("deepak@123");
        return dataSourceBuilder.build();
    }


}
