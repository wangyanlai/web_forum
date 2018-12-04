package cn.com.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.com.service.PasteService;
import cn.com.utils.PageBean;

public class GetDataAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private PasteService pasteService;
	private Integer currentPage; 
	public String getData() throws Exception {
		PageBean pastePageBean = pasteService.getPastePageBean(currentPage);
		ActionContext.getContext().put("pastePageBean", pastePageBean);
		return "index";
	}
	public PasteService getPasteService() {
		return pasteService;
	}
	public void setPasteService(PasteService pasteService) {
		this.pasteService = pasteService;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
}
