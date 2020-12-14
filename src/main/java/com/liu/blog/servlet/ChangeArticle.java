package com.liu.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.blog.entity.Article;
import com.liu.blog.entity.ArticleType;
import com.liu.blog.service.ArticleService;
import com.liu.blog.service.ArticleTypeService;

@WebServlet("/changeArticle")
public class ChangeArticle extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = (String) request.getSession().getAttribute("UserName");
        request.setAttribute("userName", userName);


        //获取当前用户的所有文章类型
        ArticleTypeService articleTypeService = new ArticleTypeService();
        List<ArticleType> articleTypeList = articleTypeService.findByUserName(userName);
        request.setAttribute("articleTypeList", articleTypeList);

        //获取当前文章名的文章
        String articleName = String.valueOf(Integer.parseInt(request.getParameter("articleName")));
        ArticleService articleService = new ArticleService();
        Article article = articleService.findByArticleName(articleName);
        request.setAttribute("article",article);

        request.getRequestDispatcher("/changeArticle.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");

        Article article = new Article();
        article.setUserName(request.getParameter("userName"));
        article.setArticleId(Integer.parseInt(request.getParameter("articleId")));
        article.setArticleName(request.getParameter("articleName"));
        article.setArticleTypeName(request.getParameter("articleTypeName"));
        article.setArticleContent(request.getParameter("articleContent"));
        article.setModDate(request.getParameter("modDate"));
        //2. 检查数据

        ArticleService articleService = new ArticleService();
        ArticleTypeService articleTypeService = new ArticleTypeService();

        //2.1 检查文章是否为空
        if (request.getParameter("articleName").equals("")) {
            request.setAttribute("article", article);
            request.setAttribute("userName", userName);
            request.setAttribute("errorMessage", "文章名不能为空！");
            //获取文章类型列表

            List<ArticleType> articleTypeList = articleTypeService.findByUserName(userName);
            System.out.println(articleTypeList);
            request.setAttribute("articleTypeList", articleTypeList);

            request.getRequestDispatcher("/changeArticle.jsp").forward(request, response);
            return;
        }
        System.out.println(request.getParameter("articleTypeName"));
//        检查文章类型是否存在
        if (request.getParameter("articleTypeName")==null) {
            request.setAttribute("article", article);
            request.setAttribute("userName", userName);
            request.setAttribute("errorMessage", "文章类型不能为空！");
            //获取文章类型列表
            List<ArticleType> articleTypeList = articleTypeService.findByUserName(userName);
            System.out.println(articleTypeList);
            request.setAttribute("articleTypeList", articleTypeList);

            request.getRequestDispatcher("/changeArticle.jsp").forward(request, response);
            return;
        }

        //3.-1 检查文章内容是否存在
        if (request.getParameter("articleContent").equals("")) {
            request.setAttribute("article", article);
            request.setAttribute("userName", userName);
            request.setAttribute("errorMessage", "文章内容不能为空！");
            //获取文章类型列表
            List<ArticleType> articleTypeList = articleTypeService.findByUserName(userName);
            System.out.println(articleTypeList);
            request.setAttribute("articleTypeList", articleTypeList);

            request.getRequestDispatcher("/changeArticle.jsp").forward(request, response);
            return;
        }

        //3. 修改文章
        article = articleService.changeArticle(article);
        response.sendRedirect("manageMyArticle");
    }

}