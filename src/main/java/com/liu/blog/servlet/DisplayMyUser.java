package com.liu.blog.servlet;

import com.liu.blog.entity.User;
import com.liu.blog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/displayMyUser")
public class DisplayMyUser extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = (String) request.getSession().getAttribute("UserName");

        UserService service = new UserService();
        User user = service.findByUserName(userName);

        request.setAttribute("user", user);
        request.getRequestDispatcher("/displayUserInformation.jsp").forward(request, response);
    }

}