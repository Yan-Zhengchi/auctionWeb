package com.auction.dao;

import com.auction.domain.Goods;

import java.util.List;

public interface IGoodsDao {
    //查询所有商品的方法
    public List<Goods> selectAllGoods() throws Exception;
}
