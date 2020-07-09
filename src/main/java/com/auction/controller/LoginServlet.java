package com.auction.controller;

import com.auction.domain.Goods;
import com.auction.domain.User;
import com.auction.service.impl.GoodsServiceImpl;
import com.auction.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserServiceImpl userService = new UserServiceImpl();
        User login = userService.login(username, password);
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        List<Goods> goods = goodsService.selectAllGoods();
        req.getSession().setAttribute("goods",goods);
        if(login!=null){
            req.getSession().setAttribute("user",login);
            resp.sendRedirect("auctionIndex.jsp");
        }else{
            resp.sendRedirect("index.html");
        }

    }
}
