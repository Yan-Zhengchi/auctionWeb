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
    public List<Goods> selectBySomething(String[] s) throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select * from goods where ");
        if (s.length != 0) {

            for (int i = 0; i < s.length-2; i+=2) {
                stringBuffer.append(s[i]+"=? and ");
            }
            stringBuffer.append(s[s.length-2]+"=?;");
            String sql = stringBuffer.toString();
            List<Object> objectList = new ArrayList<>();
            for (int i = 1; i < s.length; i+=2) {
                objectList.add(s[i]);
            }
            Object[] objects = objectList.toArray();
            ResultSet resultSet = executeQuery(sql, objects);
            List<Goods> goods = tableToClass(resultSet);
            return goods;
        }
        return null;
    }

    @Override
    public List<Goods> selectById(Integer id) throws Exception {
        String sql = "select * from goods where id=?";
        Object[] objects = {id};
        ResultSet resultSet = executeQuery(sql, objects);
        List<Goods> goods = tableToClass(resultSet);
        return  goods;
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
