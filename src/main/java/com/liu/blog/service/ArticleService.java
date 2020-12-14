package com.liu.blog.service;

import com.liu.blog.dao.ArticleDao;
import com.liu.blog.dao.UserDao;
import com.liu.blog.entity.Article;

import java.util.List;

public class ArticleService {
    public Article addArticle(Article article) {
        ArticleDao articleDao = new ArticleDao();

        Article newArticle = articleDao.addArticle(article);

        return newArticle;
    }

    public void deleteArticle(Article article){

        ArticleDao articleDao = new ArticleDao();
        articleDao.deleteArticle(article);
    }

    public List<Article> findAll() {
        ArticleDao articleDao = new ArticleDao();
        return articleDao.findAll();
    }

    public Article findByArticleTypeNameAndUserName(String articleTypeName, String userName){
        ArticleDao articleDao = new ArticleDao();
        return articleDao.findByArticleTypeNameAndUserName(articleTypeName,userName);
    }

    public Article findByArticleName(String articleName){
        ArticleDao articleDao = new ArticleDao() ;
        return articleDao.findByArticleName(articleName);
    }

    public Article changeArticle(Article article){
        ArticleDao articleDao = new ArticleDao();
        return articleDao.changeArticle(article);
    }

    public List<Article> findByUserName(String articleName){
        ArticleDao articleDao = new ArticleDao();
        return articleDao.findByUserName(articleName);
    }

    public List<Article> findByArticleNameLike(String articleNameLike) {
        ArticleDao articleDao = new ArticleDao();
        return articleDao.findByArticleNameLike(articleNameLike);
    }
}
