package cn.com.service;

import java.util.List;

import cn.com.dao.AnswerDao;
import cn.com.dao.PasteDao;
import cn.com.domain.Answer;
import cn.com.domain.Paste;
import cn.com.domain.User;
import cn.com.utils.PageBean;

public class PasteService {
	private PasteDao pasteDao;
	private AnswerDao answerDao;
	//添加帖子
	public void addPaste(Paste paste) {
		pasteDao.addPaste(paste);
	}
	//帖子详情
	public Paste findPasteByIdReturnPaste(String pasteid) {	
		Paste paste = pasteDao.findPasteByIdReturnPaste(pasteid);
		paste.setGlanceover(paste.getGlanceover()+1);
		return paste;
	}
	//只为取得paste作为参数
	public Paste findPasteById(String pasteid) {	
		Paste paste = pasteDao.findPasteByIdReturnPaste(pasteid);
		return paste;
	}
	//解决帖子
	public void solvePasteByIdAndAnswerid(String pasteid, String answerid) {
		//通过pasteid查找到paste
		Paste paste = pasteDao.findPasteByIdReturnPaste(pasteid);
		//通过answerid查找到answer
		Answer answer = answerDao.findAnswerById(answerid);
		//获得answer下的user对象（持久化类型对象）
		User user = answer.getUser();
		//因为是持久化类型对象，即可直接修改属性，同步到数据库
		user.setCoin(user.getCoin()+paste.getOffer());
		//解决问题（采纳回复）
		pasteDao.solvePasteByIdAndAnswerid(pasteid,answerid);		
	}
	//得到帖子
	public PageBean getPastePageBean(Integer currentPage) {
		Integer totalCount = pasteDao.findAllPasteNum();
		PageBean pageBean = new PageBean(currentPage,totalCount,8);
		List<Paste> list = pasteDao.getPastePageList(pageBean.getStart(),pageBean.getPageSize());
		pageBean.setList(list);
		return pageBean;
	}
	//最近热帖
	public PageBean getGlanceoverPageBean(Integer currentPage) {
		Integer totalCount = pasteDao.findAllPasteNum();
		PageBean glanceoverPageBean = new PageBean(currentPage,totalCount,8);
		List<Paste> list = pasteDao.getGlanceoverPageList();
		glanceoverPageBean.setList(list);
		return glanceoverPageBean;
	}
	//最近热议
	public PageBean getAnsnumPageBean(Integer currentPage) {
		Integer totalCount = pasteDao.findAllPasteNum();
		PageBean ansnumPageBean = new PageBean(currentPage,totalCount,8);
		List<Paste> list = pasteDao.getAnsnumPageList();
		ansnumPageBean.setList(list);
		return ansnumPageBean;
	}
	
	public PasteDao getPasteDao() {
		return pasteDao;
	}
	public void setPasteDao(PasteDao pasteDao) {
		this.pasteDao = pasteDao;
	}
	public AnswerDao getAnswerDao() {
		return answerDao;
	}
	public void setAnswerDao(AnswerDao answerDao) {
		this.answerDao = answerDao;
	}
}
