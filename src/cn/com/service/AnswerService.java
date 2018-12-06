package cn.com.service;

import cn.com.dao.AnswerDao;
import cn.com.domain.Answer;

public class AnswerService {
	private AnswerDao answerDao;
	public void addAnswer(Answer answer) {
		answerDao.addAnswer(answer);		
	}
	public AnswerDao getAnswerDao() {
		return answerDao;
	}
	public void setAnswerDao(AnswerDao answerDao) {
		this.answerDao = answerDao;
	}
}
