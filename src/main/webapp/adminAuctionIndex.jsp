<%@ page import="com.auction.domain.Admin" %>
<%@ page import="com.auction.domain.Goods" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 30256
  Date: 2020/7/9
  Time: 17:17
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
            Admin admin = (Admin)request.getSession().getAttribute("admin");
            if (admin.getAdminName()!=null){
                out.print("<div class=\"logout right\"style=\"width: 200px\">"+"欢迎您管理员："+admin.getAdminName()+"   <a href=\"exitAdmin.do\" title=\"注销\">注销</a></div>");
            }else {
//                out.print("<div class=\"logout right\"><a href=\"adminLogin.html\" title=\"注销\">登录</a></div>");
                response.sendRedirect("adminLogin.html");
            }

        %>

    </div>
    <div class="forms">
        <label for="name">名称</label>
        <input name="" type="text" class="nwinput" id="name"/>
        <label for="names">描述</label>
        <input name="" type="text" id="names" class="nwinput"/>
        <label for="time">开始时间</label>
        <input name="" type="text" id="time" class="nwinput"/>
        <label for="end-time">结束时间</label>
        <input name="" type="text" id="end-time" class="nwinput" />
        <label for="price">起拍价</label>
        <input name="" type="text" id="price" class="nwinput" />
        <input name="" type="button"  value="查询" class="spbg buttombg f14  sale-buttom"/>
        <input type="button"  value="发布" class="spbg buttombg f14  sale-buttom buttomb"/>
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
            List<Goods> goods = (List<Goods>)request.getSession().getAttribute("goods");
            int i = 0;
            for (Goods good : goods) {
                if(i%2==0){
                    out.print("<ul class=\"rows\">\n" +
                            "            <li><a href=\"国书\" title=\"\">"+good.getName()+"</a></li>\n" +
                            "            <li class=\"list-wd\">"+good.getDescription()+"</li>\n" +
                            "            <li>"+good.getStartTime()+"</li>\n" +
                            "            <li>"+good.getEndTime()+"</li>\n" +
                            "            <li>"+good.getStartPrice()+"</li>\n" +
                            "            <li class=\"borderno red\">\n" +
                            "                <a href=\"#\" title=\"竞拍\">修改</a>|\n" +
                            "                <a href=\"#\" title=\"竞拍\" onclick=\"abc();\">删除</a>\n" +
                            "            </li>" +
                            "        </ul>");
                }else{
                    out.print("<ul class=\"rows even\">\n" +
                            "            <li><a href=\"国书\" title=\"\">"+good.getName()+"</a></li>\n" +
                            "            <li class=\"list-wd\">"+good.getDescription()+"</li>\n" +
                            "            <li>"+good.getStartTime()+"</li>\n" +
                            "            <li>"+good.getEndTime()+"</li>\n" +
                            "            <li>"+good.getStartPrice()+"</li>\n" +
                            "            <li class=\"borderno red\">\n" +
                            "                <a href=\"#\" title=\"竞拍\">修改</a>|\n" +
                            "                <a href=\"#\" title=\"竞拍\" onclick=\"abc();\">删除</a>\n" +
                            "            </li>" +
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
    <script>
        function abc(){

            if(confirm("你真的确认要删除吗？请确认")){

                return true;
            }
            else{
                return false;
            }

        };
        function dele(){
            if(confirm("你真的确认要修改吗？请确认")){
                return true;
            }
            else{
                return false;
            }
        }
    </script>
    <!-- main end-->
</div>
</body>
</html>

