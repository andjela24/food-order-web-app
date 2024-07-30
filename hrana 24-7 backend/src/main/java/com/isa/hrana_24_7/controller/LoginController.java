package com.isa.hrana_24_7.controller;

import com.isa.hrana_24_7.dao.UserDaoImpl;
import com.isa.hrana_24_7.model.Login;
import com.isa.hrana_24_7.model.User;
import com.isa.hrana_24_7.service.UserService;
import com.isa.hrana_24_7.utility.StrongAES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public Login showLogin() {
        return new Login();
    }

    @PostMapping("/login")
    public User loginProcess(@RequestBody Login login, Model model) {
        User user = null;
        user = userService.validateUser(login);
        if(user!=null)
        user.setPassword(null);
        return user;
    }

    @RequestMapping("/xx")
    private String xx(){
        return new StrongAES().encrypt("");
    }

}
