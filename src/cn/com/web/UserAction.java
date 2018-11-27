package cn.com.web;

import java.util.UUID;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.com.domain.User;
import cn.com.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;
	private User user = new User();
	private UserService userService;
	public String checkUsername() throws Exception {
		
		return "";
	}
	public String register() throws Exception {
		//手动封装没有的属性
		user.setState(0);
		user.setCode(UUID.randomUUID().toString());
		user.setImage("0");
		user.setLevel(1);
		user.setCoin(1000);
		userService.addUser(user);
		return "toLogin";
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
