package com.auction.controller;

import com.auction.dao.impl.GoodsDaoImpl;
import com.auction.domain.Goods;
import com.auction.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectGoods.do")
public class SelectGoodsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String startTime = req.getParameter("startTime");
        String endTime = req.getParameter("endTime");
        String startPrice = req.getParameter("startPrice");
        StringBuffer stringBuffer = new StringBuffer();
        if(name!=null&&!name.equals("")){
            stringBuffer.append("name"+","+name+",");
        }
        if ((description!=null&&!description.equals(""))){
            stringBuffer.append("description"+","+description+",");
        }
        if ((startTime!=null&&!startTime.equals(""))){
            stringBuffer.append("startTime"+","+startTime+",");
        }
        if ((endTime!=null&&!endTime.equals(""))){
            stringBuffer.append("endTime"+","+endTime+",");
        }
        if ((startPrice!=null&&!startPrice.equals(""))){
            stringBuffer.append("startPrice"+","+startPrice+",");
        }
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        List<Goods> goods = goodsService.selectBySomething(stringBuffer.toString());
        req.setAttribute("goodsAreSelected",goods );
        req.getRequestDispatcher("auctionIndex.jsp").forward(req,resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
