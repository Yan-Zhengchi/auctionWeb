package com.auction.domain;

import java.io.Serializable;

public class AuctionRecord implements Serializable {
    private Integer id;
    private Integer goodsId;
    private String auctionTime;
    private Integer userId;
    private Double auctionPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(String auctionTime) {
        this.auctionTime = auctionTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getAuctionPrice() {
        return auctionPrice;
    }

    public void setAuctionPrice(Double auctionPrice) {
        this.auctionPrice = auctionPrice;
    }

    @Override
    public String toString() {
        return "AuctionRecord{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", auctionTime='" + auctionTime + '\'' +
                ", userId=" + userId +
                ", auctionPrice=" + auctionPrice +
                '}';
    }
}
