package com.auction.dao;

import com.auction.domain.Admin;
import com.auction.domain.queryVo.LoginQueryVo;

public interface IAdminDao {
    //管理员登陆的方法
    public Admin login(LoginQueryVo queryVo) throws Exception;
}
