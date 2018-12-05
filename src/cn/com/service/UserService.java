package cn.com.service;

import java.util.List;

import cn.com.dao.UserDao;
import cn.com.domain.Paste;
import cn.com.domain.User;
import cn.com.utils.PageBean;

public class UserService {
	private UserDao userDao;
	public PageBean getUserPageBean(Integer currentPage) {
		Integer totalCount = userDao.findAllUserNum();
		PageBean userPageBean = new PageBean(currentPage,totalCount,8);
		List<User> list = userDao.getUserPageList();
		userPageBean.setList(list);
		return userPageBean;
	}
	//用户登录验证
	public int checkUser(User user) {
		User temp = userDao.findUserByUsernameResultUser(user);
		if(temp == null) {
			return 1;
		}else {
			if(temp.getPassword().equals(user.getPassword())) {
				if(temp.getState() == 1) {
					return 0;
				}else {
					return 3;
				}
			}else {
				return 2;
			}
		}
	}
	public User findUserByUsernameResultUser(User user) {
		User temp = userDao.findUserByUsernameResultUser(user);
		return temp;
	}
	//异步用户名验证是否存在
	public boolean findUserByUsername(String username) {
		Long count = userDao.findUserByUsernameResultNumber(username);
		return count == 0 ? true:false;
	}
	//用户激活
	public void activeUser(String userCode) {
		userDao.activeUser(userCode);
	}
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
