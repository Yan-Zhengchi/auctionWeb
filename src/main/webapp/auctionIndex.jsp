<%@ page import="com.auction.domain.Admin" %>
<%@ page import="com.auction.domain.User" %>
<%@ page import="com.auction.domain.Goods" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 30256
  Date: 2020/7/9
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="css/common.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="wrap">
    <!-- main begin-->
    <div class="sale">
        <h1 class="lf">在线拍卖系统</h1>
        <%
            User admin = (User)request.getSession().getAttribute("user");
            if (admin.getUsername()!=null){
                out.print("<div class=\"logout right\"style=\"width: 150px\">"+"欢迎您："+admin.getUsername()+"   <a href=\"exit.do\" title=\"注销\">注销</a></div>");
            }else {
                out.print("<div class=\"logout right\"><a href=\"adminLogin.html\" title=\"注销\">登录</a></div>");
            }

        %>
    </div>
    <div class="forms">
        <form action="selectGoods.do" method="post">
        <label for="name">名称</label>
        <input  type="text" class="nwinput" id="name" name = "name"/>
        <label for="names">描述</label>
        <input  type="text" id="names" class="nwinput" name = "description"/>
        <label for="time">开始时间</label>
        <input  type="text" id="time" class="nwinput" name = "startTime"/>
        <label for="end-time">结束时间</label>
        <input  type="text" id="end-time" class="nwinput" name = "endTime" />
        <label for="price">起拍价</label>
        <input  type="text" id="price" class="nwinput" name = "startPrice"/>
        <input  type="submit"  value="查询" class="spbg buttombg f14  sale-buttom"/>
        </form>
    </div>
    <div class="items">
        <ul class="rows even strong">
            <li>名称</li>
            <li class="list-wd">描述</li>
            <li>开始时间</li>
            <li>结束时间</li>
            <li>起拍价</li>
            <li class="borderno">操作</li>
        </ul>
        <%
            List<Goods> goods = null;
            if (request.getAttribute("goodsAreSelected")!=null){
                 goods = (List<Goods>) request.getAttribute("goodsAreSelected");
            }else{
                goods = (List<Goods>)request.getSession().getAttribute("goods");
            }
            int i = 0;
            for (Goods good : goods) {
                if(i%2==0){
                    out.print("<ul class=\"rows\">\n" +
                            "            <li><a href=\"国书\" title=\"\">"+good.getName()+"</a></li>\n" +
                            "            <li class=\"list-wd\">"+good.getDescription()+"</li>\n" +
                            "            <li>"+good.getStartTime()+"</li>\n" +
                            "            <li>"+good.getEndTime()+"</li>\n" +
                            "            <li>"+good.getStartPrice()+"</li>\n" +
                            "            <li class=\"borderno red\"><a href=\"auction.do?goodsId="+good.getId()+"\">竞拍</a></li>\n" +
                            "        </ul>");
                }else{
                    out.print("<ul class=\"rows even\">\n" +
                            "            <li><a href=\"国书\" title=\"\">"+good.getName()+"</a></li>\n" +
                            "            <li class=\"list-wd\">"+good.getDescription()+"</li>\n" +
                            "            <li>"+good.getStartTime()+"</li>\n" +
                            "            <li>"+good.getEndTime()+"</li>\n" +
                            "            <li>"+good.getStartPrice()+"</li>\n" +
                            "            <li class=\"borderno red\"><a href=\"auction.do?goodsId="+good.getId()+"\">竞拍</a></li>\n" +
                            "        </ul>");
                }
                i++;
            }
        %>



        <div class="page">
            <a href="#" title="">首页</a>
            <a href="#" title="">上一页</a>
            <span class="red">前5页</span>
            <a href="#" title="">1</a>
            <a href="#" title="">2</a>
            <a href="#" title="">3</a>
            <a href="#" title="">4</a>
            <a href="#" title="">5</a>
            <a href="#" title="">下一页</a>
            <a href="#" title="">尾页</a>
        </div>
    </div>
    <!-- main end-->
</div>
</body>
</html>

