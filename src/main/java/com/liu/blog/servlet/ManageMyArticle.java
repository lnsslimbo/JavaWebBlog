package com.liu.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.blog.entity.Article;

import com.liu.blog.service.ArticleService;


@WebServlet("/manageMyArticle")
public class ManageMyArticle extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArticleService articleService = new ArticleService();
        String userName = (String) request.getSession().getAttribute("UserName");


        List<Article> articleList = articleService.findByUserName(userName);
        request.setAttribute("articleList", articleList);
        request.getRequestDispatcher("/manageMyArticle.jsp").forward(request, response);
    }

}