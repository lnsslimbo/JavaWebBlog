package com.liu.blog.servlet;

import com.liu.blog.entity.User;
import com.liu.blog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manageDeleteUser")
public class ManageDeleteUser extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");

        UserService service = new UserService();

        User user = service.findByUserName(userName);

        request.setAttribute("user", user);
        service.deleteByUserName(userName);

        request.getRequestDispatcher("/manageUsers").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
