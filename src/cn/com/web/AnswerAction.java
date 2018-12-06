package cn.com.web;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.com.domain.Answer;
import cn.com.service.AnswerService;

public class AnswerAction extends ActionSupport implements ModelDriven<Answer>{
	private static final long serialVersionUID = 1L;
	private Answer answer = new Answer();
	private AnswerService answerService;
	public String addAnswer() throws Exception {
		answerService.addAnswer(answer);
		return "";
	}
	@Override
	public Answer getModel() {
		// TODO Auto-generated method stub
		return answer;
	}
	public AnswerService getAnswerService() {
		return answerService;
	}
	public void setAnswerService(AnswerService answerService) {
		this.answerService = answerService;
	}
}
