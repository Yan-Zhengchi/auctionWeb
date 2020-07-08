package com.auction.test;

import com.auction.dao.impl.UserDaoImpl;
import com.auction.domain.User;
import com.auction.utils.JDBCUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class mainTest {

    private Connection connection;

    @Before
    public void Init() {
        try {
            connection = JDBCUtils.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void close() {
        try {
            JDBCUtils.close(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testRegister(){
        UserDaoImpl userDao = new UserDaoImpl(connection);
        User user = new User();
        user.setUsername("aaa");
        user.setPassword("123");
        user.setPhone("123456");
        user.setIdentityCode("123456789");
        user.setAddress("江苏省南京市");
        user.setAddressNum(111111);
        int register = userDao.register(user);
        System.out.println(register);
    }

    @Test
    public void testLogin() throws Exception {
        UserDaoImpl userDao = new UserDaoImpl(connection);
        User aaa = userDao.login("aaa", "123");
        System.out.println(aaa);
    }
}


