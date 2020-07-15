package com.auction.dao;

import com.auction.dao.impl.BaseDaoImpl;
import com.auction.domain.AuctionRecord;

import java.util.List;

public interface IAuctionDao {
    //添加竞拍记录的方法
    public int addAuctionRecord(AuctionRecord auctionRecord);
    //通过商品id查询竞拍记录
    public List<AuctionRecord> selectByGoodsId(Integer goodsId) throws Exception;
}
