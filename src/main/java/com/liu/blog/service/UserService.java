package com.liu.blog.service;

import java.util.List;

import com.liu.blog.dao.UserDao;
import com.liu.blog.entity.User;

public class UserService {

	public UserService() {
	}

	//用户登录检查
	public String loginVerify(String userName, String password) {

		String errorMessage = "success";

		//根据用户名从dao对象得到用户的实体对象
		UserDao userDao = new UserDao();
		User user = userDao.findByUserName(userName);

		//判断密码是否正确
		if (!user.getPassword().equals(password)) {
			errorMessage = "用户名或密码错误";
			return errorMessage;
		}
		//判断用户名为空
		if(userName.equals("")){
			errorMessage = "用户名不能为空";
			return errorMessage;
		}
		//判断用户名是否存在
		if (!exists(userName)){
			errorMessage = "用户名不存在";
			return errorMessage;
		}
		//判断密码是否相等
		if (!user.getPassword().equals(password)){
			errorMessage = "用户名或密码错误";
			return errorMessage;
		}
		//判断用户是否禁用
		if (!user.getStatus().equals("启用")){
			errorMessage = "用户被禁用！";
			return errorMessage;
		}
		//判断用户是否拥有权限
		/*if(!user.getRole().equals(role){
			errorMessage = "用户权限不足";
			return errorMessage;
		}*/
			return errorMessage;
	}
	//用户注册检查
/*
	public String registerVerify(String userName, String password,String passwordAgain) {

		String errorMessage = "success";

		//判断密码是否正确
		if (passwordAgain.equals(password)) {
			errorMessage = "两次密码输入不一致";
			return errorMessage;
		}
		//判断用户名为空
		if(userName.equals("")){
			errorMessage = "用户名不能为空";
			return errorMessage;
		}
		//密码不为空
		if (password.equals("") && !userName.equals("")) {
			errorMessage = "密码不能为空！";
			return errorMessage;
		}
		//判断用户名是否存在
		if (exists(userName)){
			errorMessage = "用户名已存在";
			return errorMessage;
		}
		//用户名应在3~12之间
		if(userName.length()<2||userName.length()>12){
			errorMessage = "用户名应在2-12之间!";
			return errorMessage ;
		}

		//密码长度应在8~16之间
		if(password.length()<8||password.length()>16 && !userName.equals("")){
			errorMessage = "密码应在8-16之间!";
			return errorMessage ;
		}
		return errorMessage;
	}
*/

	//通过用户名查询
	public User findByUserName(String userName) {
		UserDao userDao = new UserDao();
		return userDao.findByUserName(userName);
	}
	//通过邮箱查询
	public User findByEmail(String email) {
		UserDao userDao = new UserDao();
		return findByEmail(email);
	}
	//判断用户是否已经存在
	public boolean exists(String userName){
		User user = findByUserName(userName);
		return user != null;
	}
	//更改密码
	public User updateUserPassword(User user) {
		UserDao userDao = new UserDao();

		User newUser = userDao.updateUserPassword(user);

		//记录日志等。。。。。。

		return newUser;
	}
	//添加用户
	public User addUser(User user){
		UserDao userDao = new UserDao();
		
		User newUser = userDao.addUser(user);
		
		//记录日志等。。。。。。
		
		return newUser;
	}
	//更改用户信息
	public User updateUser(User user){
		UserDao userDao = new UserDao();

		User newUser = userDao.updateUser(user);

		//记录日志等。。。。。。
		
		return newUser;
	}
	//删除用户名
	public User deleteByUserName(User user){
		UserDao dao = new UserDao();
		return dao.deleteByUserName(user);
	}
	//查看所有用户
	public List<User> findAll() {
		UserDao userDao = new UserDao();
		
		return userDao.findAll();
	}
	//更改用户状态
	public void changeUserStatus(String userName) {
		UserDao userDao = new UserDao();
		User user = userDao.findByUserName(userName);
		String status = user.getStatus();
		String changedStatus = null;
		if (status.equals("启用")){
			changedStatus = "禁用";
		}else if (status.equals("禁用")){
			changedStatus = "启用";
		}
		userDao.changeUserStatus(userName,changedStatus);
	}

	public boolean checkRole(String userName) {
		UserDao userDao = new UserDao();
		return userDao.checkRole(userName);
	}

	public List<User> findByFullNameOrDescriptionLike(String fullNameOrDescriptionLike) {
		UserDao userDao = new UserDao();
		return userDao.findByFullNameOrDescriptionLike(fullNameOrDescriptionLike);
	}
}
