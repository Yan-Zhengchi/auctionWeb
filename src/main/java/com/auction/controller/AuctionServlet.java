package com.auction.controller;

import com.auction.domain.Goods;
import com.auction.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/auction.do")
public class AuctionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String goodsId = req.getParameter("goodsId");
        System.out.println(goodsId);
        Integer integer = Integer.valueOf(goodsId);
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        Goods goods = goodsService.selectById(integer);
        req.setAttribute("goods",goods);
        System.out.println(goods);
        req.getRequestDispatcher("auction.jsp").forward(req,resp);
    }
}
