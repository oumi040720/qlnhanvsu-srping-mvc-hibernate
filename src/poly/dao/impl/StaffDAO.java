package poly.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.dao.IStaffDAO;
import poly.entity.Staff;

@Repository
public class StaffDAO implements IStaffDAO {

	@Autowired
	SessionFactory sessionFactory; 
	
	@Override
	public List<Staff> findAll() {
		Session session = sessionFactory.getCurrentSession();
		
		String hql ="FROM Staff";
		
		@SuppressWarnings("unchecked")
		List<Staff> list = session.createQuery(hql).list();
		
		return list;
	}

	@Override
	public List<Staff> findAll(Integer offset, Integer limit) {
		Session session = sessionFactory.getCurrentSession();
		
		String hql ="FROM Staff";
		
		Query query = session.createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		
		@SuppressWarnings("unchecked")
		List<Staff> list = query.list();
		
		return list;
	}
	
	@Override
	public List<Staff> searchStaff(String key, Integer offset, Integer limit) {
		Session session = sessionFactory.getCurrentSession();
		
		String hql ="FROM Staff s WHERE s.id LIKE '%" + key + "%' OR s.name LIKE '%" + key + "%'";
		
		Query query = session.createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		
		@SuppressWarnings("unchecked")
		List<Staff> list = query.list();
		
		return list;
	}
	
	@Override
	public Long getTotalItems() {
		Session session = sessionFactory.getCurrentSession();

		String hql = "SELECT count(s) FROM Staff s";
		
		Long count = (Long) session.createQuery(hql).uniqueResult();
		
		return count;
	}

	@Override
	public Long getTotalItemsByKey(String key) {
		Session session = sessionFactory.getCurrentSession();

		String hql = "SELECT count(s) FROM Staff s WHERE s.id LIKE '%" + key + "%' OR s.name LIKE '%" + key + "%'";
		
		Long count = (Long) session.createQuery(hql).uniqueResult();
		
		return count;
	}
	
	@Override
	public Staff findOne(String id) {
		Session session = sessionFactory.openSession();
		
		Staff staff = (Staff) session.get(Staff.class, id);
		
		session.close();
		
		return staff;
	}

	@Override
	public boolean saveOrUpdate(Staff staff) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			session.saveOrUpdate(staff);
			
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
