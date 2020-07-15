package com.auction.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class MybatisUtils {
    public static SqlSession getSession(){
        try {
            return new SqlSessionFactoryBuilder().
                    build(Resources.
                            getResourceAsStream("MybatisConfig.xml")).
                    openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
