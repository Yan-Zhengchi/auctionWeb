package com.auction.dao.impl;

import com.auction.dao.IGoodsDao;
import com.auction.domain.Goods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl extends BaseDaoImpl implements IGoodsDao {
    public GoodsDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Goods> selectAllGoods() throws Exception {
        String sql = "select * from goods";
        ResultSet resultSet = executeQuery(sql, new Object[0]);
        List<Goods> goods = tableToClass(resultSet);
        return goods;
    }

    @Override
    public List<Goods> tableToClass(ResultSet rs) throws Exception {
        ArrayList<Goods> goods = new ArrayList<>();
        while(rs.next()){
            Goods goods1 = new Goods();
            goods1.setId(rs.getInt(1));
            goods1.setName(rs.getString(2));
            goods1.setDescription(rs.getString(3));
            goods1.setStartTime(rs.getString(4));
            goods1.setEndTime(rs.getString(5));
            goods1.setStartPrice(rs.getDouble(6));
            goods1.setStatus(rs.getInt(7));
            goods.add(goods1);
        }
        return goods;
    }
}
