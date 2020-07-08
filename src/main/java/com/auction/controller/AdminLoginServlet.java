package com.auction.controller;

import com.auction.domain.Admin;
import com.auction.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        resp.sendRedirect("adminIndex.jsp");
    }
}
