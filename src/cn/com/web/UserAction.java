package cn.com.web;

import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.com.domain.User;
import cn.com.service.UserService;
import cn.com.utils.MailUtils;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;
	private User user = new User();
	private UserService userService;
	private String userCode;
	
	public String login() throws Exception {
		int success = userService.checkUser(user);
		if(success == 0) {
			return "toIndex";
		}else if(success == 1) {
			ActionContext.getContext().put("error", "用户名不存在!");
			return "login";
		}else if(success == 2){
			ActionContext.getContext().put("error", "密码有误!");
			return "login";
		}else if(success == 3){
			ActionContext.getContext().put("error", "邮箱未激活!");
			return "login";
		}else {
			return "error";
		}
	}
	//激活邮箱
	public String active() throws Exception {
		userService.activeUser(userCode);
		return "toLogin";
	}
	//验证用户名是否存在
	public String checkUsername() throws Exception {
		boolean success = userService.findUserByUsername(user.getUsername());
		ServletActionContext.getResponse().getWriter().write("{\"success\":"+success+"}");
		return null;
	}
	//用户注册
	public String register() throws Exception {
		//手动封装没有的属性
		user.setState(0);
		user.setCode(UUID.randomUUID().toString());
		user.setImage("0");
		user.setLevel(1);
		user.setCoin(1000);
		userService.addUser(user);
		MailUtils.sendMail(user.getEmail(), "请激活！", "恭喜您注册成功，请您点击下面的链接进行激活！！<a href='http://localhost:8080/SSH_Forum/UserAction_active?userCode="+user.getCode()+"'>激活</a>");
		return "toRegisterSuccess";
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
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
}
