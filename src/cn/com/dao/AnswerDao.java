package cn.com.dao;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.com.domain.Answer;

public class AnswerDao extends HibernateDaoSupport{
	public void addAnswer(Answer answer) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.save(answer);
	}
}
