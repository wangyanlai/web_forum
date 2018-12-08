package cn.com.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.com.domain.Answer;
import cn.com.domain.Paste;
import cn.com.domain.User;
import cn.com.service.AnswerService;
import cn.com.service.PasteService;

public class AnswerAction extends ActionSupport implements ModelDriven<Answer>{
	private static final long serialVersionUID = 1L;
	private Answer answer = new Answer();
	private AnswerService answerService;
	private PasteService pasteService;
	private String pasteid;
	private String answerid;
	//删除回复
	public String deleteAnswer() throws Exception {
		Paste paste = pasteService.findPasteByIdReturnPaste(pasteid);
		answerService.deleteAnswerById(answerid,paste);
		ActionContext.getContext().put("pasteid", pasteid);
		return "toDetail";
	}
	//添加回复
	public String addAnswer() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user == null) {
			ActionContext.getContext().put("error", "未登陆不能回复！！！");
			return "error";
		}
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		answer.setAnstime(format.format(date));
		answer.setAgree(0);
		answer.setSolve(0);
		answer.setUser(user);
		Paste paste = pasteService.findPasteById(pasteid);
		answer.setPaste(paste);
		answerService.addAnswer(answer,paste);
		return "toDetail";
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
	public PasteService getPasteService() {
		return pasteService;
	}
	public void setPasteService(PasteService pasteService) {
		this.pasteService = pasteService;
	}
	public String getPasteid() {
		return pasteid;
	}
	public void setPasteid(String pasteid) {
		this.pasteid = pasteid;
	}
	public String getAnswerid() {
		return answerid;
	}
	public void setAnswerid(String answerid) {
		this.answerid = answerid;
	}
}
