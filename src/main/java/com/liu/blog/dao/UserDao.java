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
    //查找用户名
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
    //查找所有用户
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
    //是否为管理员
//    public String checkManager(String userName){
//        String success = "";
//        Connection cn = DbObject.getConnection();
//        PreparedStatement st = null;
//        ResultSet rs = null;
//
//        try{
//            String sql = "select Position from Users where userName =?";
//            System.out.println(sql);
//
//            st = cn.prepareStatement(sql);
//
//            st.setString(1, userName);
//
//            rs = st.executeQuery();
//            if(rs.next()){
//                if(rs.getString("role").equals("管理员")){
//                    success = "";
//                    return success;
//                }
//                else{
//                    //System.out.println(1);
//                    success += "该用户不是管理员，没有权限！";
//                    return success;
//                }
//            }
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }finally{
//            DbObject.close(cn, st, rs);
//        }
//        return success;
//    }
//    //检查用户状态
//    public String checkStatus(String userName) {
//
//        PreparedStatement st = null;
//        ResultSet rs = null;
//        Connection cn = DbObject.getConnection();
//        String success = "";
//        try{
//
//            String sql = "select status from Users where userName =?";
//            System.out.println(sql);
//
//            st = cn.prepareStatement(sql);
//            st.setString(1, userName);
//            rs = st.executeQuery();
//
//            if(rs.next()){
//                if(rs.getString("status").equals("启用")){
//                    success = "";
//                    return success;
//                }
//                else{
//                    success += "该用户被禁用，不能登录！";
//                    return success;
//                }
//            }
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }finally{
//            DbObject.close(cn, st, rs);
//        }
//        return success;
//    }
//    //检查用户类型
//    public String checkRole(String userName,String role){
//        String success = "";
//        Connection cn = DbObject.getConnection();
//        PreparedStatement st = null;
//        ResultSet rs = null;
//
//        try{
//            String sql = "select role from Users where userName =?";
//            System.out.println(sql);
//
//            st = cn.prepareStatement(sql);
//
//            st.setString(1, userName);
//
//            rs = st.executeQuery();
//            if(rs.next()){
//                if(rs.getString("Position").equals(role)){
//                    success = "";
//                    return success;
//                }
//                else{
//                    //System.out.println(1);
//                    success += "该用户不是" + role + "，请重新选择角色！";
//                    return success;
//                }
//            }
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }finally{
//            DbObject.close(cn, st, rs);
//        }
//        return success;
//    }
    //删除用户
    public User deleteByUserName(String userName){
        Connection cn = DbObject.getConnection();
        PreparedStatement st = null;
        User user;

        try {

            String sql = "delete from Users where UserName = ?;";
            System.out.println(sql);

            st = cn.prepareStatement(sql);
            st.setString(1, userName);

            int ret = st.executeUpdate();

            if(ret>0){
                user = new User();
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DbObject.close(cn, st, null);
        }

        return null;

    }
    /*//启用用户
    public User onUser(String userName){
        Connection cn = DbObject.getConnection();
        PreparedStatement st = null;
        User user = null;

        try {

            String sql = "update Users set status = ? where UserName = ?;";
            System.out.println(sql);

            st = cn.prepareStatement(sql);
            st.setString(1, "启用");
            st.setString(2, userName);

            int ret = st.executeUpdate();
            if(ret>0){
                user = new User();
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DbObject.close(cn, st, null);
        }

        return user;
    }
    //禁用用户
    public User offUser(String userName){
        Connection cn = DbObject.getConnection();
        PreparedStatement st = null;
        User user = null;

        try {

            String sql = "update Users set status = ? where UserName = ?;";
            System.out.println(sql);

            st = cn.prepareStatement(sql);
            st.setString(1, "禁用");
            st.setString(2, userName);

            int ret = st.executeUpdate();
            if(ret>0){
                user = new User();
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DbObject.close(cn, st, null);
        }

        return user;
    }*/
    //更改用户状态
    public void modifyUserStatus(String userName, String changedStatus) {
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
}

