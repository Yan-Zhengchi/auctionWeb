package com.auction.service;

import com.auction.domain.Admin;

public interface IAdminService {
    //管理员登陆的方法
    public Admin login(String loginName, String password);
}
