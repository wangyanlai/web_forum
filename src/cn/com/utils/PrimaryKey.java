package cn.com.utils;

import java.io.Serializable;

import cn.com.domain.Answer;
import cn.com.domain.User;

public class PrimaryKey implements Serializable{
	private static final long serialVersionUID = 1L;
	private User user;
	private Answer answer;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
}
