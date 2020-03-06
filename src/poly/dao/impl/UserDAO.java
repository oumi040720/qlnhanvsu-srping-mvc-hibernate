package poly.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.dao.IUserDAO;
import poly.entity.User;

@Repository
public class UserDAO implements IUserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<User> findAll(Integer offset, Integer limit) {
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "FROM User";
		
		Query query = session.createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		
		return list;
	}
	
	@Override
	public Long getTotalItems() {
		Session session = sessionFactory.getCurrentSession();

		String hql = "SELECT count(u) FROM User u";
		
		Long count = (Long) session.createQuery(hql).uniqueResult();
		
		return count;
	}
	
	@Override
	public boolean checkLogin(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "FROM User u WHERE u.username = :username AND u.password = :password";
		
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		query.setParameter("password", password);
		
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		
		return list.isEmpty() ? false : true;
	}

	@Override
	public User findOne(String username) {
		Session session = sessionFactory.getCurrentSession();
		
		User user = (User) session.get(User.class, username);
		
		return user;
	}

	@Override
	public boolean saveOrUpdate(User user) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			session.saveOrUpdate(user);
			
			transaction.commit();
			
			return true;
		} catch (Exception e) {
			transaction.rollback();
			
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean delete(String username) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			session.delete(findOne(username));
			
			transaction.commit();
			
			return true;
		} catch (Exception e) {
			transaction.rollback();
			
			return false;
		} finally {
			session.close();
		}
	}

}
