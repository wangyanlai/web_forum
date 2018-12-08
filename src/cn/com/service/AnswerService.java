package cn.com.service;

import java.util.List;

import cn.com.dao.AnswerDao;
import cn.com.dao.PasteDao;
import cn.com.domain.Answer;
import cn.com.domain.Paste;

public class AnswerService {
	private AnswerDao answerDao;
	private PasteDao pasteDao;
	public void addAnswer(Answer answer, Paste paste) {
		paste.setAnsnum(paste.getAnsnum()+1);
		answerDao.addAnswer(answer);		
	}
	//根据id取得answer对象
	public Answer findAnswerByIdReturnAnswer(String answerid) {
		Answer answer = answerDao.findAnswerById(answerid);
		return answer;
	}
	//根据pasteid取得answer列表
	public List<Answer> findAnswerByPasteid(String pasteid) {
		Paste paste = pasteDao.findPasteByIdReturnPaste(pasteid);
		List<Answer> answerList = null;
		if(paste.getSolve()==1) {
			Answer answer = answerDao.findAnswerById(paste.getAnswerid());
			answerList = answerDao.findAnswerByPasteid(pasteid);
			answerList.remove(answer);
			answerList.add(0, answer);
		}else {
			answerList = answerDao.findAnswerByPasteid(pasteid);
		}
		return answerList;
	}
	//删除回复
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
	public PasteDao getPasteDao() {
		return pasteDao;
	}
	public void setPasteDao(PasteDao pasteDao) {
		this.pasteDao = pasteDao;
	}
}
