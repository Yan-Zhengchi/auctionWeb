package com.auction.dao.impl;

import com.auction.dao.IUserDao;
import com.auction.domain.User;

import java.sql.Connection;
import java.sql.ResultSet;

public class UserDaoImpl extends BaseDaoImpl implements IUserDao {
    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public int register(User user) {
        String sql = "insert into user(username,password,identityCode,phone,address,addressNum)values(?,?,?,?,?,?)";
        Object[] objects = {user.getUsername(),user.getPassword(),user.getIdentityCode(),user.getPhone(),user.getAddress(),user.getAddressNum()};
        int i = executeUpdate(sql, objects);
        return i;
    }

    @Override
    public User login(String loginName, String password) throws Exception {
        String sql = "select * from user where username = ? and password = ?";
        Object[] objects = {loginName,password};
        ResultSet resultSet = executeQuery(sql, objects);
        User user = tableToClass(resultSet);
        return user;

    }

    @Override
    public User tableToClass(ResultSet rs) throws Exception {
        User user = new User();
        if (rs.next()){
            user.setId(rs.getInt(1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setIdentityCode(rs.getString(4));
            user.setPhone(rs.getString(5));
            user.setAddress(rs.getString(6));
            user.setAddressNum(rs.getInt(7));
        }
        return user;
    }
}
