package com.auction.service.impl;

import com.auction.dao.IUserDao;
import com.auction.domain.User;
import com.auction.domain.queryVo.LoginQueryVo;
import com.auction.service.IUserService;
import com.auction.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements IUserService {

    private SqlSession session;
    private IUserDao userDao;

    public UserServiceImpl(){
        session = MybatisUtils.getSession();
        userDao = session.getMapper(IUserDao.class);
    }
    @Override
    public int register(User user) {
        int register = userDao.register(user);
        session.commit();
        return register;
    }

    @Override
    public User login(String username, String password)  {
        LoginQueryVo loginQueryVo = new LoginQueryVo();
        loginQueryVo.setUsername(username);
        loginQueryVo.setPassword(password);
        User user = null;
        try {
            user = userDao.login(loginQueryVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
