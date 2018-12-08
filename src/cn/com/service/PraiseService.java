package cn.com.service;

import cn.com.dao.PraiseDao;
import cn.com.domain.Praise;

public class PraiseService {
	private PraiseDao praiseDao;
	public void addPraise(Praise praise) {
		praiseDao.addPraise(praise);
	}
	public PraiseDao getPraiseDao() {
		return praiseDao;
	}
	public void setPraiseDao(PraiseDao praiseDao) {
		this.praiseDao = praiseDao;
	}
}
