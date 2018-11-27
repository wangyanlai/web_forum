package cn.com.service;

import cn.com.dao.UserDao;
import cn.com.domain.User;

public class UserService {
	private UserDao userDao;
	public void addUser(User user) {
		userDao.addUser(user);
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
