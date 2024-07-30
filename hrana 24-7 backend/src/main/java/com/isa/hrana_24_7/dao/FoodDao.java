package com.isa.hrana_24_7.dao;

import com.isa.hrana_24_7.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FoodDao extends JpaRepository<Food,String> {

}
