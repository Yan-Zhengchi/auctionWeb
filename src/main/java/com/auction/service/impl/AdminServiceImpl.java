package com.auction.service.impl;

import com.auction.dao.impl.AdminDaoImpl;
import com.auction.domain.Admin;
import com.auction.service.IAdminService;
import com.auction.utils.JDBCUtils;

import java.sql.SQLException;

public class AdminServiceImpl implements IAdminService {
    @Override
    public Admin login(String loginName, String password) {
        try {
            AdminDaoImpl adminDao = new AdminDaoImpl(JDBCUtils.getConnection());
            Admin login = adminDao.login(loginName, password);
            return login;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
