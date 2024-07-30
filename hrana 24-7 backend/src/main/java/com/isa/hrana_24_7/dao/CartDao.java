package com.isa.hrana_24_7.dao;

import com.isa.hrana_24_7.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDao extends JpaRepository<Cart,Integer> {
}
