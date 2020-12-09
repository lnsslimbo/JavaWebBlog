package com.liu.blog.service;

import java.util.List;

import com.liu.blog.dao.UserDao;
import com.liu.blog.entity.User;

public class UserService {

	public UserService() {
	}

	//用户登录检查
	public String loginVerify(String userName, String password) {

		String msg = "success";

		//1. 根据用户名从dao对象得到用户的实体对象
		UserDao userDao = new UserDao();
		User user = userDao.findByUserName(userName);

		//2. 判断密码是否正确
		if (!user.getPassword().equals(password)) {
			msg = "用户名或密码错误";
			return msg;
		}
		//判断用户名为空
		if(userName.equals("")){
			msg = "用户名不能为空";
			return msg;
		}

		if (!exists(userName)){
			msg = "用户名不存在";
			return msg;
		}

		if (!user.getPassword().equals(password)){
			msg = "用户名或密码错误";
			return msg;
		}

		//3. 判断用户是否禁用
		if (!user.getStatus().equals("启用")){
			msg = "用户被禁用";
			return msg;
		}
//		//4. 判断用户是否拥有权限
//		if(!user.getRole().equals(role){
//			msg = "用户权限不足";
//			return msg;
//		}
			return msg;
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
	public User deleteByUserName(String userName){
		UserDao dao = new UserDao();
		return dao.deleteByUserName(userName);
	}
	//查找用户名
	public User findByUserName(String userName) {
		UserDao userDao = new UserDao();
		return userDao.findByUserName(userName);
	}
	//查看所有用户
	public List<User> findAll() {
		UserDao userDao = new UserDao();
		
		return userDao.findAll();
	}
	//查询所有用户类型
	public List<User> findAllRole(){
		UserDao dao = new UserDao();
		return dao.findAllRole();
	}

	public void modifyUserStatus(String userName) {
		UserDao userDao = new UserDao();
		User user = userDao.findByUserName(userName);
		String status = user.getStatus();
		String changedStatus = null;
		if (status.equals("启用")){
			changedStatus = "禁用";
		}else if (status.equals("禁用")){
			changedStatus = "启用";
		}
		userDao.modifyUserStatus(userName,changedStatus);
	}

//	//启用用户
//	public User onUser(String userName){
//		UserDao dao = new UserDao();
//		return dao.onUser(userName);
//	}
//	//禁用用户
//	public User offUser(String userName){
//		UserDao dao = new UserDao();
//		return dao.offUser(userName);
//	}
}
