package com.isa.hrana_24_7.controller;
import com.isa.hrana_24_7.dao.UserDaoImpl;
import com.isa.hrana_24_7.model.User;

import com.isa.hrana_24_7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping("/api/register")
    public User showRegister() {
        return new User();
    }

    @PostMapping("/register")
    public User addUser(@RequestBody User user, Model model) {
        System.out.println(user.toString());
        userService.register(user);
        return user;
    }

    @PostMapping("/checkUserName")
    public boolean checkAvailability(@RequestBody String username, Model model){
        return userService.usernameExists(username);
    }
}
