package com.auction.service;

import com.auction.domain.Goods;

import java.util.List;

public interface IGoodsService {
    //查询所有的商品
    public List<Goods> selectAllGoods();
}
