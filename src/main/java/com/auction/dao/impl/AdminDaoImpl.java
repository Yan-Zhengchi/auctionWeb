package com.auction.dao.impl;

import com.auction.dao.IAdminDao;
import com.auction.domain.Admin;

import java.sql.Connection;
import java.sql.ResultSet;

public class AdminDaoImpl extends BaseDaoImpl implements IAdminDao {
    public AdminDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Admin login(String loginName, String password) throws Exception {
        String sql = "select * from admin where adminName = ? and adminPassword = ?";
        Object[] objects = {loginName,password};
        ResultSet resultSet = executeQuery(sql, objects);
        Admin admin = tableToClass(resultSet);
        return admin;
    }

    @Override
    public Admin tableToClass(ResultSet rs) throws Exception {
        Admin admin = new Admin();
        if (rs.next()){
            admin.setId(rs.getInt(1));
            admin.setAdminName(rs.getString(2));
            admin.setAdminPassword(rs.getString(3));

        }
        return  admin;
    }
}
