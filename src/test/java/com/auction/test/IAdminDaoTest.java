package com.auction.test;

import com.auction.dao.IAdminDao;
import com.auction.dao.IUserDao;
import com.auction.domain.Admin;
import com.auction.domain.queryVo.LoginQueryVo;
import com.auction.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IAdminDaoTest {
    private SqlSession session;
    private IAdminDao adminDao;


    @Before
    public void init(){
        session = MybatisUtils.getSession();
        adminDao = session.getMapper(IAdminDao.class);
    }

    @After
    public void destroy(){
        session.commit();
        session.close();
    }
    @Test
    public void testAdminLogin(){
        LoginQueryVo loginQueryVo = new LoginQueryVo();
        loginQueryVo.setAdminName("yanzhengchi");
        loginQueryVo.setAdminPassword("yzc123");
        try {
            Admin login = adminDao.login(loginQueryVo);
            System.out.println(login);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
