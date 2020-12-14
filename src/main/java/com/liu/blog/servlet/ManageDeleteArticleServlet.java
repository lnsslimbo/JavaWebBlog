package com.liu.blog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.blog.entity.Article;
import com.liu.blog.service.ArticleService;

@WebServlet( "/manageDeleteArticle")
public class ManageDeleteArticleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String articleName=request.getParameter("articleName");

        ArticleService service=new ArticleService();

        Article article=service.findByArticleName(articleName);
        request.setAttribute("article", article);

        service.deleteArticle(article);

        request.getRequestDispatcher("/manageMyArticle").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
