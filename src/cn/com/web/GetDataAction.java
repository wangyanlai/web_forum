package cn.com.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.com.service.PasteService;
import cn.com.service.UserService;
import cn.com.utils.PageBean;

public class GetDataAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private PasteService pasteService;
	private UserService userService;
	private Integer currentPage; 
	public String getData() throws Exception {
		//得到所有帖子
		PageBean pastePageBean = pasteService.getPastePageBean(currentPage);
		ActionContext.getContext().put("pastePageBean", pastePageBean);
		//得到最近热帖
		PageBean glanceoverPageBean = pasteService.getGlanceoverPageBean(currentPage);
		ActionContext.getContext().put("glanceoverPageBean", glanceoverPageBean);
		//得到最近热议
		PageBean ansnumPageBean = pasteService.getAnsnumPageBean(currentPage);
		ActionContext.getContext().put("ansnumPageBean", ansnumPageBean);
		//得到专家排行榜
		PageBean userPageBean = userService.getUserPageBean(currentPage);
		ActionContext.getContext().put("userPageBean", userPageBean);
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
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
