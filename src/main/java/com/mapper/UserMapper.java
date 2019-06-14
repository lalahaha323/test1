package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    //登录
    @Select("select COUNT(*) from user where user_name = #{user_name} and user_password = #{user_password}")
    int login(@Param("user_name") String user_name, @Param("user_password") String password);
    //注册
    @Insert("insert into user(user_name, user_password, user_email) values (#{user_name}, #{user_password}, #{user_email})")
    int register(@Param("user") User user);
}
