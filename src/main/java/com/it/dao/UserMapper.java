package com.it.dao;

import com.it.entity.User;

/**
 * @auther: 曹云博
 * @create: 2020-06-2020/6/10 15:46
 */
/*
用户模块dao层
 */
public interface UserMapper {

    //用户注册
    public void register(User user);

    //激活用户
    public void active(String code);

    //用户登录
    public User login(User user);

    //验证用户名是否存在
    public String checkUserName(String username);
}
