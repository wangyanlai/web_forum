package cn.com.service;

import java.util.List;

import cn.com.dao.PasteDao;
import cn.com.domain.Paste;
import cn.com.utils.PageBean;

public class PasteService {
	private PasteDao pasteDao;
	public void addPaste(Paste paste) {
		pasteDao.addPaste(paste);
	}
	public PageBean getPastePageBean(Integer currentPage) {
		Integer totalCount = pasteDao.findAllPasteNum();
		PageBean pageBean = new PageBean(currentPage,totalCount,8);
		List<Paste> list = pasteDao.getPastePageList(pageBean.getStart(),pageBean.getPageSize());
		pageBean.setList(list);
		return pageBean;
	}
	
	public PasteDao getPasteDao() {
		return pasteDao;
	}
	public void setPasteDao(PasteDao pasteDao) {
		this.pasteDao = pasteDao;
	}
}
