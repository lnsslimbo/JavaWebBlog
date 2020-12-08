package com.liu.blog.service;

import java.util.List;

import com.liu.blog.dao.UserDao;
import com.liu.blog.entity.User;

public class UserService {

	public UserService() {
	}
	//判断用户是否已经存在
	public boolean exists(String userName){
		User user = findByUserName(userName);
		if (user == null)
			return false;
		else
			return true;
	}
	//用户登录
	public boolean loginVerify(String userName, String password){

		//1. 根据用户名从dao对象得到用户的实体对象
		UserDao userDao = new UserDao();
		User user = userDao.findByUserName(userName);

		//2. 判断密码是否正确
		if (user.getPassword().equals(password))
			return true;
		else
			return false;
	}
	//3. 判断用户是否禁用
	public String checkStatus(String userName){
		UserDao dao = new UserDao();
		return dao.checkStatus(userName);
	}
	//4. 判断用户是否拥有权限
	public String checkRole(String userName,String role){
		UserDao dao = new UserDao();
		return dao.checkRole(userName,role);
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
	//检查是否为管理员
	public String checkManager(String userName){
		UserDao dao = new UserDao();
		return dao.checkManager(userName);
	}
	//查询所有用户类型
	public List<User> findAllRole(){
		UserDao dao = new UserDao();
		return dao.findAllRole();
	}
	//启用用户
	public User onUser(String userName){
		UserDao dao = new UserDao();
		return dao.onUser(userName);
	}
	//禁用用户
	public User offUser(String userName){
		UserDao dao = new UserDao();
		return dao.offUser(userName);
	}
}
