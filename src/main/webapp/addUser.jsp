<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>添加用户</title>

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
    <h1>添加用户</h1>
    <form action="addUser" method="POST">
        <div class="form-group">
            <label for="userName">用户名</label>
            <input type="userName" class="form-control" id="userName" aria-describedby="userNameHelp" name="userName"
                   value="${user.userName}">
            <small id="userNameHelp" class="form-text text-muted">用户名长度在2-12之间</small>
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" class="form-control" id="password" name="password">
        </div>
        <div class="form-group">
            <label for="passwordAgain">再次输入密码</label>
            <input type="password" class="form-control" id="passwordAgain" name="passwordAgain">
        </div>
        <div class="form-group">
            <label for="fullName">姓名</label>
            <input type="fullName" class="form-control" id="fullName" name="fullName"
                   value="${user.fullName}">
        </div>
        <div class="form-group">
            <label for="gender">性别</label>
            <select class="form-control" id="gender" name="gender">
                <option>男</option>
                <option>女</option>
                <option>其他</option>
            </select>
        </div>
        <div class="form-group">
            <label for="birthday">生日</label>
            <input type="text" class="form-control" id="birthday" name="birthday" value="${user.birthday}">
        </div>
        <div class="form-group">
            <label for="phone">手机</label>
            <input type="text" class="form-control" id="phone" name="phone" value="${user.phone}">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" value="${user.email}">
        </div>
        <div class="form-group">
            <label for="weChatId">微信号</label>
            <input type="text" class="form-control" id="weChatId" name="weChatId" value="${user.weChatId}">
        </div>
        <div class="form-group">
            <label for="description">描述信息</label>
            <input type="text" class="form-control" id="description" name="description" value="${user.description}">
        </div>
        <div class="form-group">
            <label for="role">角色</label>
            <select class="form-control" id="role" name="role">
                <option selected>用户</option>
                <option>管理员</option>
            </select>
        </div>
        <div class="form-group">
            <label for="status">状态</label>
            <select class="form-control" id="status" name="status">
                <option selected>启用</option>
                <option>禁用</option>
            </select>
        </div>
        <span style="color:red">${errorMessage}</span><br>
        <button type="submit" class="btn btn-primary">添加用户</button>
    </form>
    <%@include file="layout/footer.jsp" %>
</div>
</body>
</html>