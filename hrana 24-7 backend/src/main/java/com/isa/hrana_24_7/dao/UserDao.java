package com.isa.hrana_24_7.dao;

import com.isa.hrana_24_7.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,String> {
}
