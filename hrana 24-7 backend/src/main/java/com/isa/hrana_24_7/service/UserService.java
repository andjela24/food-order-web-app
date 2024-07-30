package com.isa.hrana_24_7.service;

import com.isa.hrana_24_7.model.Login;
import com.isa.hrana_24_7.model.User;
import com.isa.hrana_24_7.repository.FoodRepository;
import com.isa.hrana_24_7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public void register(User user) {
        userRepository.save(user);
    }

    public User validateUser(Login login) {
        User user = null;
        if (userRepository.findByUsername(login.getUsername()).isPresent()) {
            user = userRepository.findByUsername(login.getUsername()).get();
            if(!user.getPassword().equals(login.getPassword()))
                user=null;
        }
        return user;
    }

    public Boolean usernameExists(String username){
        return userRepository.findByUsername(username).isPresent();
    }

}
