package com.auction.service.impl;

import com.auction.dao.impl.UserDaoImpl;
import com.auction.domain.User;
import com.auction.service.IUserService;
import com.auction.utils.JDBCUtils;

import java.sql.SQLException;

public class UserServiceImpl implements IUserService {
    @Override
    public int register(User user) {
        UserDaoImpl userDao = null;
        try {
            userDao = new UserDaoImpl(JDBCUtils.getConnection());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int register = userDao.register(user);
        return register;
    }

    @Override
    public User login(String loginName, String password){
        UserDaoImpl userDao = null;
        try {
            userDao = new UserDaoImpl(JDBCUtils.getConnection());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        User user = null;
        try {
            user = userDao.login(loginName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
