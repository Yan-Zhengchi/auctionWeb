package com.auction.controller;

import com.auction.domain.Admin;
import com.auction.domain.Goods;
import com.auction.service.impl.AdminServiceImpl;
import com.auction.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/adminLogin.do")
public class AdminLoginServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminName = req.getParameter("adminName");
        String adminPassword = req.getParameter("adminPassword");
        AdminServiceImpl adminService = new AdminServiceImpl();
        Admin login = adminService.login(adminName, adminPassword);
        req.getSession().setAttribute("admin",login);
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        List<Goods> goods = goodsService.selectAllGoods();
        req.getSession().setAttribute("goods",goods);
        resp.sendRedirect("adminAuctionIndex.jsp");
    }
}
