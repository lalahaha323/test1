package com.service.impl;

import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int  login(String name, String password) {
        return (userMapper.login(name, password));
    }
    @Override
    public int register(User user) {
        return(userMapper.register(user));
    }
}
