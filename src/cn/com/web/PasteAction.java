package cn.com.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.com.domain.Paste;
import cn.com.domain.User;
import cn.com.service.PasteService;
import cn.com.utils.PageBean;

public class PasteAction extends ActionSupport implements ModelDriven<Paste>{
	private static final long serialVersionUID = 1L;
	private Paste paste = new Paste();
	private PasteService pasteService;
	private String pasteid;
	//添加帖子
	public String addPaste() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user == null) {
			ActionContext.getContext().put("error", "只有登录之后才能发帖！！！");
			return "error";
		}
		paste.setAnsnum(0);
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		paste.setCreatetime(format.format(date));
		paste.setGlanceover(0);
		paste.setSolve(0);
		paste.setIsdelete(0);
		paste.setUser(user);
		pasteService.addPaste(paste);
		return "toIndex";
	}
	//帖子详情
	public String getDetail() throws Exception {
		Paste paste = pasteService.findPasteByIdReturnPaste(pasteid);
		ActionContext.getContext().put("paste", paste);
		//得到最近热帖
		PageBean glanceoverPageBean = pasteService.getGlanceoverPageBean(null);
		ActionContext.getContext().put("glanceoverPageBean", glanceoverPageBean);
		//得到最近热议
		PageBean ansnumPageBean = pasteService.getAnsnumPageBean(null);
		ActionContext.getContext().put("ansnumPageBean", ansnumPageBean);
		return "detail";
	}
	@Override
	public Paste getModel() {
		// TODO Auto-generated method stub
		return paste;
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
}
