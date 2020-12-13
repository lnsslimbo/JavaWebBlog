<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="com.liu.blog.entity.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
    <base href="<%=basePath%>">

    <title>My JSP 'login.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link href="html/css/bootstrap.min.css" rel="stylesheet">
    <script src="html/jquery.js"></script>

    <script>
        $(function(){
            $("#login").click(function(){
                hasError=false;
                if($("#name").val()==''){
                    $("#nameError").html("用户名不能为空！");
                    hasError=true;
                }
                else{
                    $("#nameError").html("");
                }

                if(hasError){
                    return false;
                }
            });
        });
    </script>
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="html/js/bootstrap.min.js"></script>
    <style>
        .username input,.password input{
            height: 50px;
            padding-left: 30px;
        }

        .form-control-feedback {
            line-height: 50px;
            left: 525px;
        }

        .btn {background-color: lightblue;
        }

        .form-horizontal{text-align: center;}
        .checkbox{left:400px;}

    </style>

</head>

<body background="html/tu3.jpg">



<form action="login" method="POST" class="form-horizontal">
    <h1 class="text-center text-info">用户登录</h1><br>

    <div class="form-group has-feedback">
        <div class="username">
            <span class="glyphicon glyphicon-user form-control-feedback"></span>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
            用户名：<input type="text" class="input-large" id="name" placeholder="用户名"
                       aria-describedby="userNameHelp" name="userName" value="${userName}"><br>
            <small id="userNameHelp" class="form-text text-muted">用户名长度在2-12之间</small>
        </div>
    </div>

    <div class="form-group pwd-top has-feedback">
        <div class="password">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
            密码：<input type="password" class="input-large" id="password" placeholder="密码" name="password" value="${password}">
            <span></span><br>
        </div>
    </div>

    <div class="form-group">
        <a href="register">注册</a>
    </div>

    <span style="color:red">${errorMessage}</span><br>

    <div class="form-group">
        <button class="btn btn-login" type="submit" id="login">登录</button>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="index" class="btn btn-info">返回主页</a>
    </div>

</form>

<%@include file="layout/footer.jsp" %>
</body>

</html>