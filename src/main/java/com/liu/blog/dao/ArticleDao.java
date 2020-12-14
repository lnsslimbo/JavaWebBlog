package com.liu.blog.dao;

import com.liu.blog.entity.Article;
import com.liu.blog.common.DbObject;
import com.liu.blog.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {

    public ArticleDao(){
    }
    //增加文章
    public Article addArticle(Article article) {
        Connection cn = DbObject.getConnection();
        PreparedStatement st = null;

        try {
            String sql = "insert into article(articleName,userName,articleTypeName,articleContent,PublishDate,ModDate)" +
                    " values(?,?,?,?,?,?)";
            st = cn.prepareStatement(sql);

            st.setString(1, article.getArticleName());
            st.setString(2, article.getUserName());
            st.setString(3, article.getArticleTypeName());
            st.setString(4, article.getArticleContent());
            st.setString(5, article.getPublishDate());
            st.setString(6, article.getModDate());


            int ret = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, null);
        }
        return article;
    }
    //删除文章
    public Article deleteArticle(Article article) {
        Connection cn = DbObject.getConnection();
        PreparedStatement st = null;

        try {
            //4.执行sql
            String sql = "delete from article where articleName=?";
            st = cn.prepareStatement(sql);

            st.setString(1, article.getArticleName());

            System.out.println(st);
            int ret = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, null);
        }
        return article;
    }
    //查看所有文章
    public List<Article> findAll() {
        ArrayList<Article> articleList = new ArrayList<>();

        Connection cn = DbObject.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        if (cn == null)
            return null;

        try {
            //4.执行sql
            String sql = "select * from article";
            st = cn.prepareStatement(sql);

            rs = st.executeQuery();
            while (rs.next()) {
                User user = new User();
                Article article = new Article();
                article.setArticleName(rs.getString("articleName"));
                article.setArticleTypeName(rs.getString("articleTypeName"));
                article.setArticleContent(rs.getString("articleContent"));
                article.setUserName(rs.getString("userName"));

                article.setPublishDate(rs.getString("publishDate"));
                article.setModDate(rs.getString("modDate"));

                articleList.add(article);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, rs);
        }

        return articleList;
    }
    //通过用户名和文章类型查询文章
    public Article findByArticleTypeNameAndUserName(String articleTypeName, String userName) {
        Connection cn = DbObject.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        if (cn == null)
            return null;
        //用户的信息至少包括，用户的登录名、密码、用户的姓名、性别、出生日期、手机、Email、微信号、描述信息、注册日期等。
        try {
            //4.执行sql
            String sql = "select * from article where articleTypeName=? and username=?";

            st = cn.prepareStatement(sql);

            st.setString(1, articleTypeName);
            st.setString(2, userName);
            System.out.println(st);

            rs = st.executeQuery();
            if (rs.next()) {
                Article article = new Article();
                article.setArticleName(rs.getString("articleName"));
                article.setArticleTypeName(rs.getString("articleTypeName"));
                article.setArticleContent(rs.getString("articleContent"));
                article.setUserName(rs.getString("userName"));

                return article;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, rs);
        }

        return null;
    }
    //通过用户名查询文章
    public List<Article> findByUserName(String userName) {
        ArrayList<Article> articleList = new ArrayList<>();
        Connection cn = DbObject.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        if (cn == null)
            return null;
        //用户的信息至少包括，用户的登录名、密码、用户的姓名、性别、出生日期、手机、Email、微信号、描述信息、注册日期等。
        try {
            //4.执行sql
            String sql = "select * from article where username=?";

            st = cn.prepareStatement(sql);

            st.setString(1, userName);
            System.out.println(st);

            rs = st.executeQuery();
            while (rs.next()) {
                Article article = new Article();
                article.setArticleId(rs.getInt("articleId"));
                article.setArticleName(rs.getString("articleName"));
                article.setArticleTypeName(rs.getString("articleTypeName"));
                article.setArticleContent(rs.getString("articleContent"));
                article.setUserName(rs.getString("userName"));

                articleList.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, rs);
        }
        return articleList;
    }
    //通过文章名查询文章
    public Article findByArticleName(String articleName) {
        Connection cn = DbObject.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        if (cn == null)
            return null;
        try {
            //4.执行sql
            String sql = "select * from article where articleName=?";

            st = cn.prepareStatement(sql);

            st.setString(1, articleName);
            System.out.println(st);

            rs = st.executeQuery();
            if (rs.next()) {
                Article article = new Article();
                article.setArticleId(rs.getInt("articleId"));
                article.setArticleName(rs.getString("articleName"));
                article.setArticleTypeName(rs.getString("articleTypeName"));
                article.setArticleContent(rs.getString("articleContent"));
                article.setUserName(rs.getString("userName"));

                return article;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, rs);
        }

        return null;
    }
    //更改文章
    public Article changeArticle(Article article) {
        Connection cn = DbObject.getConnection();
        PreparedStatement st = null;

        try {
            String sql = "update article set articleName=?,articleTypeName=?,articleContent=? where articleId=?";
            st = cn.prepareStatement(sql);

            st.setString(1, article.getArticleName());
            st.setString(2, article.getArticleTypeName());
            st.setString(3, article.getArticleContent());
            st.setString(4, String.valueOf(article.getArticleId()));

            System.out.println(st);
            int ret = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, null);
        }
        return article;
    }
    //模糊查询
    public List<Article> findByArticleNameLike(String articleNameLike) {
        ArrayList<Article> articleList = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;

        Connection cn = DbObject.getConnection();
        if (cn == null)
            return null;

        try {
            //4.执行sql
            String sql = "select * from article where articleName like ?";
            st = cn.prepareStatement(sql);
            st.setString(1, "%"+articleNameLike+"%");
            System.out.println(st);


            rs = st.executeQuery();
            while (rs.next()) {
                User user = new User();
                Article article = new Article();
                article.setArticleId(rs.getInt("articleId"));
                article.setArticleName(rs.getString("articleName"));
                article.setArticleTypeName(rs.getString("articleTypeName"));
                article.setArticleContent(rs.getString("articleContent"));
                article.setUserName(rs.getString("userName"));
                article.setPublishDate(rs.getString("publishDate"));
                article.setModDate(rs.getString("modDate"));

                articleList.add(article);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, rs);
        }

        return articleList;
    }
}

