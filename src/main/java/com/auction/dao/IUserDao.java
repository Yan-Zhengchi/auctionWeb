package com.auction.dao;

import com.auction.domain.User;
import com.auction.domain.queryVo.LoginQueryVo;

public interface IUserDao {

    //用户注册方法
    public int register(User user);

    //用户登录方法
    public User login(LoginQueryVo queryVo) throws Exception;


}
