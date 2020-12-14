<%@ page language="java" import="java.util.*" import="com.liu.blog.entity.User" pageEncoding="utf-8" %>
<%@ page import="com.liu.blog.entity.ArticleType" %>
<%@ page import="com.liu.blog.entity.Article" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">

    <title>修改</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expirses" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body style="background: url(img/wallhaven-73kvkv.jpg);background-size:cover">
<div class="container">
    <%@include file="layout/header.jsp" %>
    <form class="form-inline" action="manageChangeArticle" Method="Post">
        <div class="form-group">
            <label class="sr-only">articleName</label>
            文章标题：<input  id="articleName" name="articleName" value="${ article.articleName }" readonly>
        </div>

        <div class="form-group">
            <label class="sr-only">articleTypeName</label>
            文章类型：<input  id="articleTypeName" name="articleTypeName" value="${ article.articleTypeName }" readonly>
        </div>
        <br/>
        <div class="form-group">
            <label class="sr-only">content</label>
            文章内容：
            <br/>
            <textarea class="form-control" rows="40" cols="130" id="inputArticleContent" name="inputArticleContent"
                      style="min-width: 90%">${ article.articleContent }</textarea>
        </div>
        <div>
            <button type="submit" class="btn btn-default">提交修改</button>
            <h5 class="text-center" style="color:red">${Message}</h5>
        </div>
    </form>
    <%@include file="layout/footer.jsp" %>
</div>
</body>
</html>
