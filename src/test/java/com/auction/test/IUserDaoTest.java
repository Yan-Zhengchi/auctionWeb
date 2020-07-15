package com.auction.test;

import com.auction.dao.IUserDao;
import com.auction.domain.User;
import com.auction.domain.queryVo.LoginQueryVo;
import com.auction.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IUserDaoTest {
    private SqlSession session;
    private IUserDao userDao;


    @Before
    public void init(){
        session = MybatisUtils.getSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destroy(){
        session.commit();
        session.close();
    }


    @Test
    public void testRegister() {
        User user = new User();
        user.setUsername("aaaaa");
        user.setPassword("12345");
        user.setPhone("123456");
        user.setIdentityCode("123456789");
        user.setAddress("江苏省南京市");
        user.setAddressNum(111111);
        int register = userDao.register(user);
        System.out.println(register);
    }


    @Test
    public void testLogin(){
        User aaa = null;
        try {
            LoginQueryVo loginQueryVo = new LoginQueryVo();
            loginQueryVo.setUsername("aaa");
            loginQueryVo.setPassword("123");
            aaa = userDao.login(loginQueryVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(aaa);
    }




}
