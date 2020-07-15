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

    @Override
    public List<Goods> selectBySomething(String s)   {
        String[] split = s.split(",");
        try {
            GoodsDaoImpl goodsDao = new GoodsDaoImpl(JDBCUtils.getConnection());
            List<Goods> goods = goodsDao.selectBySomething(split);
            return goods;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Goods selectById(Integer id) {
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
            goods = goodsDao.selectById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Goods good = goods.get(0);
        return good;
    }
}
