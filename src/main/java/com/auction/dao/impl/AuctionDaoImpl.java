package com.auction.dao.impl;

import com.auction.dao.IAuctionDao;
import com.auction.domain.AuctionRecord;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AuctionDaoImpl extends BaseDaoImpl implements IAuctionDao {
    public AuctionDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public int addAuctionRecord(AuctionRecord auctionRecord) {
        String sql = "insert into auctionRecord(goodsId,auctionTime,userId,auctionPrice) values(?,?,?,?)";
        Object[] objects = {auctionRecord.getGoodsId(),auctionRecord.getAuctionTime(),auctionRecord.getUserId(),auctionRecord.getAuctionPrice()};
        int i = executeInsert(sql, objects);
        return i;
    }

    @Override
    public List<AuctionRecord> selectByGoodsId(Integer goodsId) throws Exception {
        String sql = "select * from auctionRecord where goodsId=?";
        Object[] objects = {goodsId};
        ResultSet resultSet = executeQuery(sql, objects);
        List<AuctionRecord> auctionRecords = tableToClass(resultSet);
        return auctionRecords;
    }

    @Override
    public List<AuctionRecord> tableToClass(ResultSet rs) throws Exception {
        ArrayList<AuctionRecord> auctionRecords = new ArrayList<>();
        while(rs.next()){
            AuctionRecord auctionRecord = new AuctionRecord();
            auctionRecord.setId(rs.getInt(1));
            auctionRecord.setGoodsId(rs.getInt(2));
            auctionRecord.setAuctionTime(rs.getString(3));
            auctionRecord.setUserId(rs.getInt(4));
            auctionRecord.setAuctionPrice(rs.getDouble(5));
            auctionRecords.add(auctionRecord);
        }
        return auctionRecords;
    }
}
