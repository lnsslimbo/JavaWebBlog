package com.liu.blog.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.blog.entity.User;
import com.liu.blog.service.UserService;

@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");
        userName = new String(userName.getBytes("utf-8"), "utf-8");

        UserService service = new UserService();
        User user = service.findByUserName(userName);



        service.deleteByUserName(userName);

        request.setAttribute("userName", userName);
        response.sendRedirect("manageDeleteUser");
    }
}