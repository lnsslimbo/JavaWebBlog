package com.liu.blog.servlet;

import com.liu.blog.entity.Article;
import com.liu.blog.entity.User;
import com.liu.blog.service.ArticleService;
import com.liu.blog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/manageDisplayArticle")
public class ManageDisplayArticle extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();

        String articleName=request.getParameter("articleName");

        ArticleService serviceArticle = new ArticleService();

            Article article=serviceArticle.findByArticleName(articleName);

            session.setAttribute("article", article);

            request.setAttribute("article", article);

        request.getRequestDispatcher("/manageDisplayArticle.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
