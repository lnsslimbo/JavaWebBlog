<%@ page language="java" import="java.util.*" import="com.liu.blog.entity.User" pageEncoding="utf-8" %>
<%@ page import="com.liu.blog.entity.Article" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>详情</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body style="background: url(img/wallhaven-73kvkv.jpg);background-size:cover">
<div class="container">
    <%@include file="layout/header.jsp" %>
    <%Article article=(Article)request.getAttribute("article");%>
    <h2 class="text-center"><%=article.getArticleName()%></h2>
    <h5 class="text-right">作者：<%=article.getUserName()%></h5></br>
    <h5 class="text-right">发布时间：<%=article.getPublishDate()%></h5>
    </br><%=article.getArticleContent()%></br>
</div>
</body>
</html>
