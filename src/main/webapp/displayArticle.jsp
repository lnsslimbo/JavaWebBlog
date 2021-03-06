<%@ page language="java" import="java.util.*" import="com.liu.blog.entity.User" pageEncoding="utf-8" %>
<%@ page import="com.liu.blog.entity.ArticleType" %>
<%@ page import="com.liu.blog.entity.Article" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>显示文章</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>

<body style="background: url(img/wallhaven-73kvkv.jpg);background-size:cover">
<div style="height:100%;background: url(img/o_200403112626wallhaven-3kgjv6.png);background-size: inherit" class="container">
<%@include file="layout/header.jsp" %>
<%
    List<Article> articleList = (List<Article>) request.getAttribute("articleList");
%>
<table class="table table-hover">
    <thead>
    <tr>
        <th>用户名</th>
        <th>文章名</th>
        <th>文章类型</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (Article article : articleList) {
    %>
    <tr>
        <td><%=article.getUserName()%>
        </td>
        <td><%=article.getArticleName()%>
        </td>
        <td><%=article.getArticleTypeName()%>
        </td>
            <td>
                <a href="manageDisplayArticle?articleName=${article.articleName}">详情</a>
<%--                <a href="manageChangeArticle?articleName=<%=article.getArticleName()%>">修改</a>--%>
<%--                <a href="manageDeleteArticle?articleName=<%=article.getArticleName()%>">删除</a>--%>
            </td>
        </tr>
    <%
        }
    %>
    </tbody>
</table>
<%@include file="layout/footer.jsp" %>
</div>
</body>
</html>
