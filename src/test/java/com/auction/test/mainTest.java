package com.auction.test;

import com.auction.dao.IAuctionDao;
import com.auction.dao.impl.AuctionDaoImpl;
import com.auction.dao.impl.GoodsDaoImpl;
import com.auction.domain.AuctionRecord;
import com.auction.domain.Goods;
import com.auction.domain.User;
import com.auction.utils.JDBCUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class mainTest {

    private Connection connection;

    @Before
    public void Init() {
        try {
            connection = JDBCUtils.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void close() {
        try {
            JDBCUtils.close(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    @Test
//    public void testRegister(){
//        UserDaoImpl userDao = new UserDaoImpl(connection);
//        User user = new User();
//        user.setUsername("aaa");
//        user.setPassword("123");
//        user.setPhone("123456");
//        user.setIdentityCode("123456789");
//        user.setAddress("江苏省南京市");
//        user.setAddressNum(111111);
//        int register = userDao.register(user);
//        System.out.println(register);
//    }
//
//    @Test
//    public void testLogin() throws Exception {
//        UserDaoImpl userDao = new UserDaoImpl(connection);
//        User aaa = userDao.login("aaa", "123");
//        System.out.println(aaa);
//    }

    @Test
    public void testSelectGoods() throws Exception {
        GoodsDaoImpl goodsDao = new GoodsDaoImpl(connection);
        List<Goods> goods = goodsDao.selectAllGoods();
        for (Goods good : goods) {
            System.out.println(good);
        }
    }
    @Test
    public void testString(){
        String s = "name,商品1,description,第一件商品,startTime,2020-10-10,endTime,2020-12-12,";
        String[] split = s.split(",");
//        System.out.println(split.length);
//        for (String s1 : split) {
//            System.out.println(s1);
//        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select * from goods where ");
        for (int i = 0; i < split.length-2; i+=2) {
            stringBuffer.append(split[i]+"=? and ");
        }
        stringBuffer.append(split[split.length-2]+"=?;");
        String s1 = stringBuffer.toString();
        System.out.println(s1);
    }

    @Test
    public void testSelectGoodsById() throws Exception {
        GoodsDaoImpl goodsDao = new GoodsDaoImpl(JDBCUtils.getConnection());
        List<Goods> goods = goodsDao.selectById(1);
        for (Goods good : goods) {
            System.out.println(goods);

        }
    }

    @Test
    public void testInsertAuctionRecord() throws SQLException, ClassNotFoundException {
        IAuctionDao auctionDao = new AuctionDaoImpl(JDBCUtils.getConnection());
        AuctionRecord auctionRecord = new AuctionRecord();
        auctionRecord.setGoodsId(1);
        auctionRecord.setAuctionTime("2020-10-11 20:20:10");
        auctionRecord.setUserId(2);
        auctionRecord.setAuctionPrice(5000.0);
        int i = auctionDao.addAuctionRecord(auctionRecord);
        System.out.println(i);
    }
    @Test
    public void testSelectAuctionRecordByGoodsId() throws Exception {
        AuctionDaoImpl auctionDao = new AuctionDaoImpl(JDBCUtils.getConnection());
        List<AuctionRecord> auctionRecords = auctionDao.selectByGoodsId(1);
        for (AuctionRecord auctionRecord : auctionRecords) {
            System.out.println(auctionRecord);
        }
    }
}


