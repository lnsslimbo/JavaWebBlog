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
public class ManageDisplayArticleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();

        String email=request.getParameter("email");

        ArticleService serviceArticle = new ArticleService();
        UserService serviceUser=new UserService();

        User user=serviceUser.findByEmail(email);

        String articleName=null;

        if(session.getAttribute("email")!=null) {
            articleName=(String) session.getAttribute("articleName");
            Article article=serviceArticle.findByArticleName(articleName);
            session.setAttribute("article", article);
            session.setAttribute("userSession", user);

            session.setAttribute("email", email);


            request.setAttribute("article", article);
        }else {
            articleName=request.getParameter("articleName");
            Article article=serviceArticle.findByArticleName(articleName);
            session.setAttribute("article", article);
            session.setAttribute("userSession", user);

            session.setAttribute("email", email);

            request.setAttribute("article", article);
        }
        request.setAttribute("user", user);

        request.getRequestDispatcher("/ManagerDisplayArticle.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
