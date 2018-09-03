package com.serhey.service;

import com.serhey.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public User getUser(String login) {
        User user = new User();
        user.setLogin("root");
        user.setPassword("7110eda4d09e062aa5e4a390b0a572ac0d2c0220");
        return user;
    }
}
