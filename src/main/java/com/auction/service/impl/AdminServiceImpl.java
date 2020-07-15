package com.auction.service.impl;

import com.auction.dao.IAdminDao;
import com.auction.domain.Admin;
import com.auction.domain.queryVo.LoginQueryVo;
import com.auction.service.IAdminService;
import com.auction.utils.JDBCUtils;
import com.auction.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;

public class AdminServiceImpl implements IAdminService {
    @Override
    public Admin login(String loginName, String password) {
        SqlSession session = MybatisUtils.getSession();
        IAdminDao mapper = session.getMapper(IAdminDao.class);
        LoginQueryVo loginQueryVo = new LoginQueryVo();
        loginQueryVo.setAdminName(loginName);
        loginQueryVo.setAdminPassword(password);
        try {
            Admin login = mapper.login(loginQueryVo);
            return login;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
