package cn.com.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.com.domain.Answer;
import cn.com.domain.Praise;
import cn.com.domain.User;
import cn.com.service.AnswerService;
import cn.com.service.PraiseService;
import cn.com.utils.PrimaryKey;

public class PraiseAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private AnswerService answerService;
	private PraiseService praiseService;
	private String answerid;
	private String pasteid;
	public String addPraise() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user == null) {
			ActionContext.getContext().put("error", "Î´µÇÂ¼²»ÔÊÐíµãÔÞ£¡£¡£¡");
			return "error";
		}
		Answer answer = answerService.findAnswerByIdReturnAnswer(answerid);
		PrimaryKey primaryKey = new PrimaryKey();
		primaryKey.setUser(user);
		primaryKey.setAnswer(answer);
		Praise praise = new Praise();
		praise.setPrimaryKey(primaryKey);
		praiseService.addPraise(praise);
		answer.setAgree(answer.getAgree()+1);
		ActionContext.getContext().put("pasteid", pasteid);
		return "toDetail";
	}
	public AnswerService getAnswerService() {
		return answerService;
	}
	public void setAnswerService(AnswerService answerService) {
		this.answerService = answerService;
	}
	public PraiseService getPraiseService() {
		return praiseService;
	}
	public void setPraiseService(PraiseService praiseService) {
		this.praiseService = praiseService;
	}
	public String getAnswerid() {
		return answerid;
	}
	public void setAnswerid(String answerid) {
		this.answerid = answerid;
	}
	public String getPasteid() {
		return pasteid;
	}
	public void setPasteid(String pasteid) {
		this.pasteid = pasteid;
	}	
}
