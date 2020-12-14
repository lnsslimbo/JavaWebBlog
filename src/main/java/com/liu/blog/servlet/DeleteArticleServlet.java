package com.liu.blog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liu.blog.entity.Article;
import com.liu.blog.entity.User;
import com.liu.blog.service.ArticleService;
import com.liu.blog.service.UserService;


@WebServlet( "/deleteArticle" )
public class DeleteArticleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();

        String articleName=request.getParameter("articleName");
        String email=request.getParameter("email");

        ArticleService service=new ArticleService();
        UserService serviceUser=new UserService();

        Article article=service.findByArticleName(articleName);
        User user=serviceUser.findByEmail(email);

        request.setAttribute("article", article);
        request.setAttribute("user", user);
        session.setAttribute("articleName",articleName);

        session.setAttribute("userSession", user);
        session.setAttribute("articleSession", article);

        service.deleteArticle(article);
        
        request.getRequestDispatcher("MyPassage").forward(request,response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}

