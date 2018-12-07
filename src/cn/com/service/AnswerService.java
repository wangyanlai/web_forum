package cn.com.service;

import java.util.List;

import cn.com.dao.AnswerDao;
import cn.com.domain.Answer;
import cn.com.domain.Paste;

public class AnswerService {
	private AnswerDao answerDao;
	public void addAnswer(Answer answer, Paste paste) {
		paste.setAnsnum(paste.getAnsnum()+1);
		answerDao.addAnswer(answer);		
	}
	public List<Answer> findAnswerByPasteid(String pasteid) {
		List<Answer> answerList = answerDao.findAnswerByPasteid(pasteid);
		return answerList;
	}
	public void deleteAnswerById(String answerid, Paste paste) {
		paste.setAnsnum(paste.getAnsnum()-1);
		answerDao.deleteAnswerById(answerid);
	}
	public AnswerDao getAnswerDao() {
		return answerDao;
	}
	public void setAnswerDao(AnswerDao answerDao) {
		this.answerDao = answerDao;
	}
}
