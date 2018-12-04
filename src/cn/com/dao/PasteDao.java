package cn.com.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.com.domain.Paste;

public class PasteDao extends HibernateDaoSupport{

	public void addPaste(Paste paste) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.save(paste);
	}
	public Integer findAllPasteNum() {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql = "select count(*) from paste";
		NativeQuery query = session.createSQLQuery(sql);
		BigInteger result = (BigInteger) query.uniqueResult();
		return result.intValue();
	}
	public List<Paste> getPastePageList(Integer start, Integer pageSize) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql = "select * from paste limit ?,?";
		NativeQuery query = session.createSQLQuery(sql);
		query.addEntity(Paste.class);
		query.setParameter(1, start);
		query.setParameter(2, pageSize);
		List list = query.list();
		return list;
	}
//	public List<Paste> findAllPaste() {
//		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
//		String hql = "from cn.com.domain.Paste";
//		Query query = session.createQuery(hql);
//		List<Paste> list = query.list();
//		return list;
//	}
}
