package com.liu.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.blog.dao.ArticleTypeDao;
import com.liu.blog.entity.Article;
import com.liu.blog.entity.ArticleType;
import com.liu.blog.service.ArticleService;
import com.liu.blog.service.ArticleTypeService;
import com.liu.blog.service.UserService;

@WebServlet("/changeUserStatus")
public class ChangeUserStatus extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");

        UserService userService = new UserService();
        userService.changeUserStatus(userName);

        response.sendRedirect("manageUsers");
    }

}