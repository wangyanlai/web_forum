package cn.com.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.com.domain.Paste;
import cn.com.domain.User;
import cn.com.service.PasteService;

public class PasteAction extends ActionSupport implements ModelDriven<Paste>{
	private static final long serialVersionUID = 1L;
	private Paste paste = new Paste();
	private PasteService pasteService;
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
}
