package com.auction.service;

import com.auction.domain.Goods;

import java.sql.SQLException;
import java.util.List;

public interface IGoodsService {
    //查询所有的商品
    public List<Goods> selectAllGoods();
    //多个参数动态查询商品的方法
    public List<Goods> selectBySomething(String s) throws SQLException, ClassNotFoundException;
    //通过id查询商品
    public Goods selectById(Integer id);
}
