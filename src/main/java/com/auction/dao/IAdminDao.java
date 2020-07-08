package com.auction.dao;

import com.auction.domain.Admin;

public interface IAdminDao {
    //管理员登陆的方法
    public Admin login(String loginName, String password) throws Exception;
}
