package com.isa.hrana_24_7.dao;

import com.isa.hrana_24_7.model.Login;
import com.isa.hrana_24_7.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl{

    @Autowired
    private UserDao userDao;


    public void register(User user) {
        userDao.save(user);
    }

    public User validateUser(Login login) {
        User user = null;
        if (userDao.findById(login.getUsername()).isPresent()) {
            user = userDao.findById(login.getUsername()).get();
            if(!user.getPassword().equals(login.getPassword()))
                user=null;
        }
        return user;
    }

    public Boolean usernameExists(String username){
       return userDao.findById(username).isPresent();
    }

}
