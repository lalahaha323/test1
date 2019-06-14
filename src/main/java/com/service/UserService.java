package com.service;


import com.pojo.User;
import org.springframework.stereotype.Service;

//@Service("userService")
public interface UserService {
    int login(String name, String password);
    int register(User user);
}
