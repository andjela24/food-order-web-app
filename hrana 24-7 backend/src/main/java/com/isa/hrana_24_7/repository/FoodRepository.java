package com.isa.hrana_24_7.repository;

import com.isa.hrana_24_7.model.Cart;
import com.isa.hrana_24_7.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
}