package poly.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.dao.IDepartDAO;
import poly.entity.Depart;

@Repository
public class DepartDAO implements IDepartDAO {

	@Autowired
	SessionFactory sessionFactory; 
	
	@Override
	public List<Depart> findAll() {
		Session session = sessionFactory.openSession();
		
		String hql ="FROM Depart";
		
		Query query = session.createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Depart> list = query.list();
		
		session.close();
		
		return list;
	}
	
	@Override
	public List<Depart> findAll(Integer offset, Integer limit) {
		Session session = sessionFactory.getCurrentSession();
		
		String hql ="FROM Depart";
		
		Query query = session.createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		
		@SuppressWarnings("unchecked")
		List<Depart> list = query.list();
		
		return list;
	}

	@Override
	public Long getTotalItems() {
		Session session = sessionFactory.getCurrentSession();

		String hql = "SELECT count(d) FROM Depart d";
		
		Long count = (long) session.createQuery(hql).uniqueResult();
		
		return count;
	}
	
	@Override
	public Depart findOne(String id) {
		Session session = sessionFactory.openSession();
		
		Depart depart = (Depart) session.get(Depart.class, id);
		
		session.close();
		
		return depart;
	}

	@Override
	public boolean saveOrUpdate(Depart depart) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			session.saveOrUpdate(depart);
			
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
	public boolean delete(String id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.delete(findOne(id));
			
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
