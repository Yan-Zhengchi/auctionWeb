package com.auction.service;

import com.auction.domain.User;

public interface IUserService {
    //用户注册方法
    public int register(User user);

    //用户登录方法
    public User login(String loginName, String password) throws Exception;
}
