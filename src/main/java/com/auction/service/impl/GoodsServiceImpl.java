package com.auction.service.impl;

import com.auction.dao.impl.GoodsDaoImpl;
import com.auction.domain.Goods;
import com.auction.service.IGoodsService;
import com.auction.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class GoodsServiceImpl implements IGoodsService {
    @Override
    public List<Goods> selectAllGoods() {
        GoodsDaoImpl goodsDao = null;
        try {
            goodsDao = new GoodsDaoImpl(JDBCUtils.getConnection());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Goods> goods = null;
        try {
            goods = goodsDao.selectAllGoods();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goods;
    }
}
