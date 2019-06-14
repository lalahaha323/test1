package com.controller;

import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//返回Json格式
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("UserService")
    private UserService userService;

    @RequestMapping("/register")
    public String register(@RequestBody User user) {
        userService.register(user);
        return "success";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public Map<String, String> login(HttpServletRequest request,@RequestBody Map<String, String> map) {
        Map ma = new HashMap();
        String name = map.get("name");
        String password = map.get("password");
        System.out.println("用户登录:" + name + password);
        int flag = userService.login(name, password);
        if(flag == 1) {
            //登陆成功
            ma.put("loginInfo", "yes");
            ma.put("msg", "登陆成功");
        }
        return ma;
    }
}