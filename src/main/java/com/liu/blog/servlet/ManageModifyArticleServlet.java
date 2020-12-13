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


@WebServlet("/managerModifyArticle")
public class ManageModifyArticleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session=request.getSession();

        ArticleService serviceArticle = new ArticleService();
        UserService serviceUser=new UserService();
        ArticleTypeService serviceArticleType=new ArticleTypeService();
        List<ArticleType> listArticleType=serviceArticleType.findAll();


        String articleName=request.getParameter("articleName");

        Article passage=serviceArticle.findByArticleName(articleName);
        User user=serviceUser.findByEmail(passage.getUserEmail());

        session.setAttribute("passageSession", passage);
        session.setAttribute("userSession", user);

        request.setAttribute("passage", passage);
        request.setAttribute("user", user);
        request.setAttribute("listArticleType", listArticleType);
        request.getRequestDispatcher("/ManagerModifyArticle.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");

        HttpSession session=request.getSession();

        String articleName=request.getParameter("inputArticleTitle");
        String articleType=request.getParameter("inputArticleArticleType");
        String articleContent=request.getParameter("inputArticleContent");
        String email=request.getParameter("email");

        ArticleService service =new ArticleService();
        UserService serviceUser=new UserService();

        Article passage = new Article();
        User user=serviceUser.findByEmail(email);

        passage.setArticleName(articleName);
        passage.setArticleTypeName(articleType);
        passage.setArticleContent(articleContent);
        passage.setUserEmail(email);

        service.modifyArticle(passage);

        session.setAttribute("email", email);
        session.setAttribute("articleName", articleName);

        session.setAttribute("passage", passage);
        session.setAttribute("userSession", user);

        request.setAttribute("articleName", articleName);
        request.setAttribute("user", user);
        request.setAttribute("passage", passage);

        request.getRequestDispatcher("/managerDisplayArticle").forward(request,response);
    }

}
