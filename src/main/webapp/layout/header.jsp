<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="main">博客</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active">
				<a class="nav-link" href="main">主页 <span class="sr-only">(my)</span></a>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="VisitorDropdown" role="button" data-toggle="dropdown"
				   aria-haspopup="true" aria-expanded="false">
					访客
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="manageArticle">所有文章</a>
					<a class="dropdown-item" href="searchArticle">查询文章</a>
					<a class="dropdown-item" href="searchUser">查询用户</a>
				</div>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="ArticleDropdown" role="button" data-toggle="dropdown"
				   aria-haspopup="true" aria-expanded="false">
					写作
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="addArticleType">添加文章类型</a>
					<a class="dropdown-item" href="displayMyArticleType">查看文章类型</a>
					<a class="dropdown-item" href="changeArticleType">修改文章类型</a>
					<a class="dropdown-item" href="deleteArticleType">删除文章类型</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="addArticle">添加文章</a>
					<a class="dropdown-item" href="manageMyArticle">管理文章</a>
				</div>
			</li>

			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="UserDropdown" role="button" data-toggle="dropdown"
				   aria-haspopup="true" aria-expanded="false">
					我的
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="displayUser">个人信息</a>
					<a class="dropdown-item" href="changeMyUserInformation">修改个人信息</a>
					<a class="dropdown-item" href="changeMyUserPassword">修改个人密码</a>
				</div>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="ManagerDropdown" role="button" data-toggle="dropdown"
				   aria-haspopup="true" aria-expanded="false">
					管理员
				</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="addUser">添加用户</a>
					<a class="dropdown-item" href="manageUsers">查看用户</a>
				</div>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="logout">注销</a>
			</li>
		</ul>
	</div>
</nav>