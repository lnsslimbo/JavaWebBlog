package com.liu.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liu.blog.entity.Article;
import com.liu.blog.entity.ArticleType;
import com.liu.blog.entity.User;
import com.liu.blog.service.ArticleService;
import com.liu.blog.service.ArticleTypeService;
import com.liu.blog.service.UserService;


@WebServlet("/manageChangeArticle")
public class ManageChangeArticle extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();

        ArticleService serviceArticle = new ArticleService();

        ArticleTypeService serviceArticleType=new ArticleTypeService();
        List<ArticleType> listArticleType=serviceArticleType.findAll();


        String articleName=request.getParameter("articleName");

        Article article=serviceArticle.findByArticleName(articleName);

        session.setAttribute("articleSession", article);

        request.setAttribute("article", article);

        request.setAttribute("listArticleType", listArticleType);
        request.getRequestDispatcher("/manageChangeArticle.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");

        HttpSession session=request.getSession();

        String articleName=request.getParameter("articleName");
        String articleContent=request.getParameter("inputArticleContent");


        ArticleService service =new ArticleService();

        Article article = service.findByArticleName(articleName);

        article.setArticleName(articleName);
        article.setArticleContent(articleContent);

        article=service.changeArticle(article);
        session.setAttribute("articleName", articleName);

        session.setAttribute("article", article);

        request.setAttribute("articleName", articleName);
        request.setAttribute("article", article);

        request.getRequestDispatcher("/manageDisplayArticle.jsp").forward(request,response);
    }

}
