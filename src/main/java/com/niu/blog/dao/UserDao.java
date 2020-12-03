package com.niu.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.niu.blog.common.DbObject;
import com.niu.blog.entity.User;

public class UserDao {
    public User findByUserName(String userName) {
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        cn = DbObject.getConnection();
        if (cn == null)
            return null;
        //用户的信息至少包括，用户的登录名、密码、用户的姓名、性别、出生日期、手机、Email、微信号、描述信息、注册日期等。
        try {
            //4.执行sql
            String sql = "select * from users where username=?";
            st = cn.prepareStatement(sql);

            st.setString(1, userName);

            rs = st.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserName(userName);
                user.setPassword(rs.getString("password"));
                user.setFullName(rs.getString("fullName"));

                return user;
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

    public User addUser(User user) {
        Connection cn;
        PreparedStatement st = null;

        cn = DbObject.getConnection();

        try {
            //4.执行sql
            //用户的信息至少包括，用户的登录名、密码、用户的姓名、性别、出生日期、手机、Email、微信号、描述信息、注册日期等。
            String sql = "insert into users (username,password,fullname,gender,birthday,phone,email,weChatId," +
                    "description,registrationDate) values(?,?,?,?,?,?,?,?,?,?)";
            st = cn.prepareStatement(sql);
//			System.out.println(user.getGender());

            st.setString(1, user.getUserName());
            st.setString(2, user.getPassword());
            st.setString(3, user.getFullName());
            st.setString(4, user.getGender());
            st.setString(5, user.getBirthday());
            st.setString(6, user.getPhone());
            st.setString(7, user.getEmail());
            st.setString(8, user.getWeChatId());
            st.setString(9,user.getDescription());
            st.setString(10,user.getRegistrationDate());



            int ret = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, null);
        }
        return user;
    }

    public User updateUser(User user) {
        Connection cn = null;
        PreparedStatement st = null;

        cn = DbObject.getConnection();

        try {
            //4.执行sql
            String sql = "update users set fullname=? where username=?";
            st = cn.prepareStatement(sql);

            st.setString(1, user.getFullName());
            st.setString(2, user.getUserName());

            int ret = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, null);
        }
        return user;
    }

    public User updateUserPassword(User user) {
        Connection cn = null;
        PreparedStatement st = null;

        cn = DbObject.getConnection();

        try {
            //4.执行sql
            String sql = "update users set password=? where username=?";
            st = cn.prepareStatement(sql);

            st.setString(1, user.getPassword());
            st.setString(2, user.getUserName());

            int ret = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, null);
        }
        return user;
    }

    public List<com.niu.blog.entity.User> findAll() {
        ArrayList<User> userList = new ArrayList<User>();

        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        cn = DbObject.getConnection();
        if (cn == null)
            return null;

        try {
            //4.执行sql
            String sql = "select * from users";
            st = cn.prepareStatement(sql);

            rs = st.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setFullName(rs.getString("fullName"));

                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, rs);
        }

        return userList;
    }


}
