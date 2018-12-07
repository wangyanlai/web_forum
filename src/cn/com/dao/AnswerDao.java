package cn.com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.com.domain.Answer;

public class AnswerDao extends HibernateDaoSupport{
	public void addAnswer(Answer answer) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.save(answer);
	}
	public List<Answer> findAnswerByPasteid(String pasteid) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql = "select * from answer where pasteid = ?";
		NativeQuery query = session.createSQLQuery(sql);
		query.addEntity(Answer.class);
		query.setParameter(1, pasteid);
		List<Answer> list = query.list();
		return list;
	}
	public void deleteAnswerById(String answerid) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql = "delete from answer where id = ?";
		NativeQuery query = session.createSQLQuery(sql);
		query.setParameter(1, answerid);
		query.executeUpdate();
	}
}
