package com.liu.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liu.blog.entity.User;
import com.liu.blog.service.UserService;

@WebServlet("/login")      
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获取用户名和密码
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		//2.检查用户名和密码正确性
		UserService userService = new UserService();

		String msg = userService.loginVerify(userName, password);

		if (msg.equals("success")) {
			HttpSession session = request.getSession();
			session.setAttribute("UserName", userName);
			response.sendRedirect("main?msg=" + msg);
		} else {
			request.setAttribute("userName", userName);
			request.setAttribute("errorMessage", msg);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
