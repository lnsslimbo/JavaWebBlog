package com.liu.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liu.blog.common.DbObject;
import com.liu.blog.entity.User;

public class UserDao {

    public UserDao() {
    }
    //添加用户
    public User addUser(User user) {
        Connection cn;
        PreparedStatement st = null;

        cn = DbObject.getConnection();

        try {
            //4.执行sql
            //用户的信息至少包括，用户的登录名、密码、用户的姓名、性别、出生日期、手机、Email、微信号、描述信息、注册日期等。
            String sql = "insert into users (username,password,fullname,gender,birthday,phone,email,weChatId," +
                    "description,registrationDate,role,status) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            System.out.println(sql);

            st = cn.prepareStatement(sql);

            st.setString(1, user.getUserName());
            st.setString(2, user.getPassword());
            st.setString(3, user.getFullName());
            st.setString(4, user.getGender());
            st.setString(5, user.getBirthday());
            st.setString(6, user.getPhone());
            st.setString(7, user.getEmail());
            st.setString(8, user.getWeChatId());
            st.setString(9, user.getDescription());
            st.setString(10,user.getRegistrationDate());
            st.setString(11,user.getRole());
            st.setString(12,user.getStatus());

            System.out.println(user.getStatus());
            System.out.println(user.getUserName());
            int ret = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, null);
        }
        return user;
    }
    //删除用户
    public User deleteByUserName(User user){
        Connection cn = DbObject.getConnection();;
        PreparedStatement st = null;

        try {
            //4.执行sql
            String sql = "delete user where userName=?";
            System.out.println(sql);

            st = cn.prepareStatement(sql);

            st.setString(1, user.getUserName());

            int ret = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, null);
        }
        return user;
    }
    //通过用户名查找用户
    public User findByUserName(String userName) {
        PreparedStatement st = null;
        ResultSet rs = null;//结果集对象
        Connection cn = DbObject.getConnection();//获得数据库连接对象
        if (cn == null)
            return null;
        try {
            //4.执行sql
            String sql = "select * from users where username=?";
            System.out.println(sql);
            st = cn.prepareStatement(sql);//使st为可执行的语句
            st.setString(1, userName);//传入参数

            rs = st.executeQuery();
            //用户的登录名、密码、用户的姓名、性别、出生日期、手机、Email、微信号、描述信息、注册日期、用户类型、用户状态
            if (rs.next()) {
                User user = new User();
                user.setUserName(userName);
                user.setPassword(rs.getString("password"));
                user.setFullName(rs.getString("fullName"));
                user.setGender(rs.getString("gender"));
                user.setBirthday(rs.getString("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setWeChatId(rs.getString("weChatId"));
                user.setDescription(rs.getString("description"));
                user.setRegistrationDate(rs.getString("registrationDate"));
                user.setRole(rs.getString("role"));//用户类型
                user.setStatus(rs.getString("status"));//用户状态
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
    //通过邮箱查找
    public User findByEmail(String email) {
        PreparedStatement st = null;
        ResultSet rs = null;//结果集对象
        Connection cn = DbObject.getConnection();//获得数据库连接对象
        if (cn == null)
            return null;
        try {
            //4.执行sql
            String sql = "select * from users where email=?";
            System.out.println(sql);
            st = cn.prepareStatement(sql);//使st为可执行的语句
            st.setString(1, email);//传入参数

            rs = st.executeQuery();
            //用户的登录名、密码、用户的姓名、性别、出生日期、手机、Email、微信号、描述信息、注册日期、用户类型、用户状态
            if (rs.next()) {
                User user = new User();
                user.setEmail(email);
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setFullName(rs.getString("fullName"));
                user.setGender(rs.getString("gender"));
                user.setBirthday(rs.getString("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setWeChatId(rs.getString("weChatId"));
                user.setDescription(rs.getString("description"));
                user.setRegistrationDate(rs.getString("registrationDate"));
                user.setRole(rs.getString("role"));//用户类型
                user.setStatus(rs.getString("status"));//用户状态
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
    //更改信息
    public User updateUser(User user) {
        Connection cn = DbObject.getConnection();
        PreparedStatement st = null;

        try {
            //4.执行sql
            //用户的信息至少包括，用户的登录名、密码、用户的姓名、性别、出生日期、手机、Email、微信号、描述信息、注册日期等。
            String sql = "update users set fullname=?,gender=?,birthday=?,phone=?," +
                    "email=?,weChatId=?,description=? where username=?";
            System.out.println(sql);

            st = cn.prepareStatement(sql);

            st.setString(1, user.getFullName());
            st.setString(2, user.getGender());
            st.setString(3, user.getBirthday());
            st.setString(4, user.getPhone());
            st.setString(5, user.getEmail());
            st.setString(6, user.getWeChatId());
            st.setString(7, user.getDescription());
            st.setString(8,user.getUserName());

            System.out.println(st);
            int ret = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, null);
        }
        return user;
    }
    //更改密码
    public User updateUserPassword(User user) {
        Connection cn = DbObject.getConnection();
        PreparedStatement st = null;
        try {
            //4.执行sql
            String sql = "update users set password=? where username=?";
            System.out.println(sql);
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
    //查看所有用户
    public List<User> findAll() {
        ArrayList<User> userList = new ArrayList<>();

        Connection cn = DbObject.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        if (cn == null)
            return null;

        try {
            //4.执行sql
            String sql = "select * from users";
            st = cn.prepareStatement(sql);
            System.out.println(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setFullName(rs.getString("fullName"));
                user.setGender(rs.getString("gender"));
                user.setBirthday(rs.getString("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setWeChatId(rs.getString("weChatId"));
                user.setDescription(rs.getString("description"));
                user.setRegistrationDate(rs.getString("registrationDate"));
                user.setRole(rs.getString("role"));//用户类型
                user.setStatus(rs.getString("status"));//用户状态

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

    //更改用户状态
    public void changeUserStatus(String userName, String changedStatus) {
        Connection cn = null;
        PreparedStatement st = null;

        cn = DbObject.getConnection();

        try {
            //4.执行sql
            String sql = "update users set status=? where username=?";
            st = cn.prepareStatement(sql);

            st.setString(1, changedStatus);
            st.setString(2, userName);

            int ret = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, null);
        }
    }
    //检查身份
    public boolean checkRole(String userName) {
        Connection cn = DbObject.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        //用户的信息至少包括，用户的登录名、密码、用户的姓名、性别、出生日期、手机、Email、微信号、描述信息、注册日期等。
        try {
            //4.执行sql
            String sql = "select role from users where username=?";
            st = cn.prepareStatement(sql);

            st.setString(1, userName);

            rs = st.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                return role.equals("管理员");
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, rs);
        }

        return false;
    }

    public List<User> findByFullNameOrDescriptionLike(String fullNameOrDescriptionLike) {
        ArrayList<User> userList = new ArrayList<>();

        PreparedStatement st = null;
        ResultSet rs = null;

        Connection cn = DbObject.getConnection();
        if (cn == null)
            return null;

        try {
            //4.执行sql
            String sql = "select * from users where fullName like ? or description like ?";
            st = cn.prepareStatement(sql);

            st.setString(1, "%" + fullNameOrDescriptionLike + "%");
            st.setString(2, "%" + fullNameOrDescriptionLike + "%");

            rs = st.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setFullName(rs.getString("fullName"));
                user.setRole(rs.getString("role"));
                user.setStatus(rs.getString("status"));

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

