package cn.com.dao;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.com.domain.User;

public class UserDao extends HibernateDaoSupport{
	public void addUser(User user) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.save(user);
	}
}
