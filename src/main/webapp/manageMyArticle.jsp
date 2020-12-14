<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>管理我的文章</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>

<body style="background: url(img/wallhaven-73kvkv.jpg);background-size:cover">
<div class="container">
    <%@include file="layout/header.jsp" %>

    <h1>管理文章</h1>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>用户名</th>
            <th>文章号</th>
            <th>文章名</th>
            <th>文章类型</th>
            <th>查看文章</th>
            <th>修改文章</th>
            <th>删除文章</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${articleList}" var="article">
            <tr>
                <td>${article.userName}</td>
                <td>${article.articleId}</td>
                <td>${article.articleName}</td>
                <td>${article.articleTypeName}</td>
                <td><a href="manageDisplayArticle?articleName=${article.articleName}">详情</a></td>
                <td><a href="manageChangeArticle?articleName=${article.articleName}">修改</a></td>
                <td><a href="manageDeleteArticle?articleName=${article.articleName}">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%@include file="layout/footer.jsp" %>
</div>
</body>
</html>