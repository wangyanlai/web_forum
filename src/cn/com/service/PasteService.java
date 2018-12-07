package cn.com.service;

import java.util.List;

import cn.com.dao.PasteDao;
import cn.com.domain.Paste;
import cn.com.utils.PageBean;

public class PasteService {
	private PasteDao pasteDao;
	//�������
	public void addPaste(Paste paste) {
		pasteDao.addPaste(paste);
	}
	//��������
	public Paste findPasteByIdReturnPaste(String pasteid) {	
		Paste paste = pasteDao.findPasteByIdReturnPaste(pasteid);
		paste.setGlanceover(paste.getGlanceover()+1);
		return paste;
	}
	//ֻΪȡ��paste��Ϊ����
	public Paste findPasteById(String pasteid) {	
		Paste paste = pasteDao.findPasteByIdReturnPaste(pasteid);
		return paste;
	}
	//�������
	public void solvePasteByIdAndAnswerid(String pasteid, String answerid) {
		pasteDao.solvePasteByIdAndAnswerid(pasteid,answerid);		
	}
	//�õ�����
	public PageBean getPastePageBean(Integer currentPage) {
		Integer totalCount = pasteDao.findAllPasteNum();
		PageBean pageBean = new PageBean(currentPage,totalCount,8);
		List<Paste> list = pasteDao.getPastePageList(pageBean.getStart(),pageBean.getPageSize());
		pageBean.setList(list);
		return pageBean;
	}
	//�������
	public PageBean getGlanceoverPageBean(Integer currentPage) {
		Integer totalCount = pasteDao.findAllPasteNum();
		PageBean glanceoverPageBean = new PageBean(currentPage,totalCount,8);
		List<Paste> list = pasteDao.getGlanceoverPageList();
		glanceoverPageBean.setList(list);
		return glanceoverPageBean;
	}
	//�������
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
}
