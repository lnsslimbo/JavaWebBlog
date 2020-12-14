package com.liu.blog.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liu.blog.entity.User;
import com.liu.blog.service.UserService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/register.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1. 接收表单数据
		//用户的信息至少包括，用户的登录名、密码、用户的姓名、性别、出生日期、手机、Email、微信号、描述信息、注册日期等。
		User user = new User();
		user.setUserName(request.getParameter("userName"));
		user.setPassword(request.getParameter("password"));
		user.setFullName(request.getParameter("fullName"));
		user.setGender(request.getParameter("gender"));
		user.setBirthday(request.getParameter("birthday"));
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		user.setEmail(request.getParameter("email"));
		user.setWeChatId(request.getParameter("weChatId"));
		user.setDescription(request.getParameter("description"));
		user.setRegistrationDate(request.getParameter("registrationDate"));
		user.setRole(request.getParameter("role"));
		user.setStatus(request.getParameter("status"));
		System.out.println(user);


		/*String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String passwordAgain = request.getParameter("passwordAgain");*/
		//2. 检查数据
		UserService userservice = new UserService();

		/*String errorMessage = UserService.registerVerify(userName, password,passwordAgain);

		if (errorMessage.equals("success")) {
			HttpSession session = request.getSession();
			session.setAttribute("UserName", userName);
			response.sendRedirect("main?errorMessage=" + errorMessage);
		} else {
			request.setAttribute("userName", userName);
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
*/


		//用户名不为空
		if (request.getParameter("userName").equals("")){
			request.setAttribute("errorMessage", "用户名不能为空！");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		//用户名应在3~12之间
		if(request.getParameter("userName").length()<2||request.getParameter("userName").length()>12){
			request.setAttribute("errorMessage","用户名应在2-12之间!");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		//密码不为空
		if (request.getParameter("password").equals("")){
			request.setAttribute("user", user);
			request.setAttribute("errorMessage", "密码不能为空！");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		//密码长度应在8~16之间
		if(request.getParameter("password").length()<8||request.getParameter("password").length()>16){
			request.setAttribute("user",user);
			request.setAttribute("errorMessage","密码应在8-16之间!");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		//密码是否相同
		if (!request.getParameter("password").equals(request.getParameter("passwordAgain"))){
			request.setAttribute("user", user);
			request.setAttribute("errorMessage", "两次输入的密码不相同！");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		//3.-1 检查用户是否存在
		if (userservice.exists(user.getUserName())){
			request.setAttribute("user", user);
			request.setAttribute("errorMessage", "用户名已经存在！");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		//3. 新加用户
		user = userservice.addUser(user);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/success.jsp").forward(request, response);
	}
}
