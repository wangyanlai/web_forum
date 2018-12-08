package cn.com.dao;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.com.domain.Praise;

public class PraiseDao extends HibernateDaoSupport{
	public void addPraise(Praise praise) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.save(praise);
	}
}
