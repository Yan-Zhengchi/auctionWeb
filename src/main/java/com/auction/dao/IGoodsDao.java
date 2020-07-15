package com.auction.dao;

import com.auction.domain.Goods;

import java.util.List;

public interface IGoodsDao {
    //查询所有商品的方法
    public List<Goods> selectAllGoods() throws Exception;
    //多个参数动态查询sql的方法
    public List<Goods> selectBySomething(String[] s) throws Exception;
    //通过id查询商品的方法
    public List<Goods> selectById(Integer id) throws Exception;
}
