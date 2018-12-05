package cn.com.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.com.domain.Paste;
import cn.com.domain.User;

public class UserDao extends HibernateDaoSupport{
	//用户注册
	public void addUser(User user) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.save(user);
	}
	//用户激活
	public void activeUser(String userCode) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql = "update user set state = 1 where code = ?";
		NativeQuery query = session.createSQLQuery(sql);
		query.setParameter(1, userCode);
		query.executeUpdate();
	}
	//异步用户名校验是否存在
	public Long findUserByUsernameResultNumber(String username) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql = "select count(*) from user where username = ?";
		NativeQuery query = session.createSQLQuery(sql);
		query.setParameter(1, username);
		BigInteger result = (BigInteger) query.uniqueResult();
		return result.longValue();
	}
	//用户是否注册成功
	public User findUserByUsernameResultUser(User user) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql = "select * from user where username = ?";
		NativeQuery query = session.createSQLQuery(sql);
		query.addEntity(User.class);
		query.setParameter(1, user.getUsername());
		User temp = (User) query.uniqueResult();
		return temp;
	}
	public Integer findAllUserNum() {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql = "select count(*) from user";
		NativeQuery query = session.createSQLQuery(sql);
		BigInteger result = (BigInteger) query.uniqueResult();
		return result.intValue();
	}
	public List<User> getUserPageList() {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		String sql = "select * from user order by concat(coin,level) desc limit 0,8";
		NativeQuery query = session.createSQLQuery(sql);
		query.addEntity(User.class);
		List list = query.list();
		return list;
	}
}
