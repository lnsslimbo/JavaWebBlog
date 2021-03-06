package com.liu.blog.dao;

import com.liu.blog.common.DbObject;
import com.liu.blog.entity.ArticleType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleTypeDao {
    public static List<ArticleType> findByUserName(String userName) {
        ArrayList<ArticleType> articleTypeList = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;

        Connection cn = DbObject.getConnection();
        if (cn == null)
            return null;
        try {
            //4.执行sql
            String sql = "select * from articleTypes where userName=?";
            st = cn.prepareStatement(sql);

            st.setString(1, userName);


            rs = st.executeQuery();
            while (rs.next()) {
                ArticleType articleType = new ArticleType();
                articleType.setArticleTypeName(rs.getString("articleTypeName"));
                articleType.setUserName(rs.getString("userName"));
                articleTypeList.add(articleType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, rs);
        }

        return articleTypeList;
    }

    public ArticleType findByArticleTypeNameAndUserName(String userName, String articleTypeName) {
        PreparedStatement st = null;
        ResultSet rs = null;

        Connection cn = DbObject.getConnection();
        if (cn == null)
            return null;
        try {
            //4.执行sql
            String sql = "select * from articleTypes where articleTypeName=? and userName=?";
            st = cn.prepareStatement(sql);

            st.setString(1, articleTypeName);
            st.setString(2, userName);


            rs = st.executeQuery();
            if (rs.next()) {
                ArticleType articleType = new ArticleType();
                articleType.setArticleTypeName(articleTypeName);
                articleType.setUserName(rs.getString("userName"));
                return articleType;
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

    public ArticleType addArticleType(ArticleType articleType) {
        PreparedStatement st = null;

        Connection cn = DbObject.getConnection();

        try {
            String sql = "insert into articleTypes(articleTypeName,userName) values(?,?)";
            st = cn.prepareStatement(sql);

            st.setString(1, articleType.getArticleTypeName());
            st.setString(2, articleType.getUserName());


            int ret = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, null);
        }
        return articleType;
    }

    public List<ArticleType> findAll() {
        ArrayList<ArticleType> articleTypeList = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;

        Connection cn = DbObject.getConnection();
        if (cn == null)
            return null;

        try {
            //4.执行sql
            String sql = "select * from articleTypes";
            st = cn.prepareStatement(sql);

            rs = st.executeQuery();
            while (rs.next()) {
                ArticleType articleType = new ArticleType();
                articleType.setArticleTypeName(rs.getString("articleTypeName"));
                articleType.setUserName(rs.getString("userName"));
                articleTypeList.add(articleType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, rs);
        }

        return articleTypeList;
    }

    public ArticleType updateArticleType(String articleTypeName,ArticleType articleType) {
        PreparedStatement st = null;

        Connection cn = DbObject.getConnection();

        try {
            //4.执行sql
            String sql = "update articleTypes set articleTypeName=? where articleTypeName=? and userName=?";
            st = cn.prepareStatement(sql);

            st.setString(1, articleType.getArticleTypeName());
            st.setString(2, articleTypeName);
            st.setString(3, articleType.getUserName());

            System.out.println(st);
            int ret = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, null);
        }
        return articleType;
    }

    public void deleteArticleType(String articleTypeName, String userName) {
        PreparedStatement st = null;

        Connection cn = DbObject.getConnection();

        try {
            //4.执行sql
            String sql = "delete from articleTypes where articleTypeName=? and userName=?";
            st = cn.prepareStatement(sql);

            st.setString(1, articleTypeName);
            st.setString(2, userName);

            System.out.println(st);
            int ret = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, null);
        }
    }
}
