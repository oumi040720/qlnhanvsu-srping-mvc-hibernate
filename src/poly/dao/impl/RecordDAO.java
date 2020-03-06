package poly.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import poly.dao.IRecordDAO;
import poly.entity.Record;

@Repository
public class RecordDAO implements IRecordDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Record> findAll(Integer offset, Integer limit) {
		Session session = sessionFactory.getCurrentSession();

		String hql = "FROM Record r ORDER BY r.date DESC";

		Query query = session.createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		
		@SuppressWarnings("unchecked")
		List<Record> list = query.list();
		
		return list;
	}

	@Override
	public Long getTotalItems() {
		Session session = sessionFactory.getCurrentSession();

		String hql = "SELECT count(r) FROM Record r";
		
		Long count = (Long) session.createQuery(hql).uniqueResult();
		
		return count;
	}
	
	@Override
	public List<String> getAllYear() {
		Session session = sessionFactory.getCurrentSession();

		String hql = "SELECT distinct year(r.date) FROM Record r";
		
		@SuppressWarnings("unchecked")
		List<String> list = session.createQuery(hql).list();
		
		return list;
	}
	
	@Override
	public Long getTotalItemsByYear(Integer year) {
		Session session = sessionFactory.getCurrentSession();

		String hql = "SELECT count(r) FROM Record r WHERE year(r.date) = :year";
		
		Query query = session.createQuery(hql);
		query.setParameter("year", year);
		
		Long count = (Long) query.uniqueResult();
		
		return count;
	}
	
	@Override
	public List<Record> findAllByYear(Integer year, Integer offset, Integer limit) {
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "FROM Record r WHERE year(r.date) = :year ORDER BY r.date DESC";
		
		Query query = session.createQuery(hql);
		query.setParameter("year", year);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		
		@SuppressWarnings("unchecked")
		List<Record> list = query.list();
		
		return list;
	}
	
	@Override
	public List<Object[]> findAllStaffReport(Integer offset, Integer limit) {
		Session session = sessionFactory.getCurrentSession();

		StringBuffer hql = new StringBuffer("SELECT r.staff.id, r.staff.name, SUM(case when r.type=1 then 1 else 0 end), ");
		hql.append("SUM(case when r.type=0 then 1 else 0 end), r.staff.photo FROM Record r  ");
		hql.append("GROUP BY r.staff.id, r.staff.name, r.staff.photo");
		
		
		Query query = session.createQuery(hql.toString());
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();

		return list;
	}
	

	@Override
	public List<Object[]> findAllStaffReportByYear(Integer year, Integer offset, Integer limit) {
		Session session = sessionFactory.getCurrentSession();

		StringBuffer hql = new StringBuffer("SELECT r.staff.id, r.staff.name, SUM(case when r.type=1 then 1 else 0 end), ");
		hql.append("SUM(case when r.type=0 then 1 else 0 end), r.staff.photo FROM Record r  ");
		hql.append("WHERE year(r.date) = :year ");
		hql.append("GROUP BY r.staff.id, r.staff.name, r.staff.photo");
		
		
		Query query = session.createQuery(hql.toString());
		query.setParameter("year", year);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();

		return list;
	}

	@Override
	public Long getTotalStaffReportItems() {
		Session session = sessionFactory.getCurrentSession();

		String hql = "SELECT count(DISTINCT r.staff.id) FROM Record r";
		
		Long count = (Long) session.createQuery(hql).uniqueResult();
		
		return count;
	}
	
	@Override
	public Long getTotalStaffReportItemsByYear(Integer year) {
		Session session = sessionFactory.getCurrentSession();

		String hql = "SELECT count(DISTINCT r.staff.id) FROM Record r WHERE year(r.date) = :year";
		
		Query query = session.createQuery(hql);
		query.setParameter("year", year);
		
		Long count = (Long) query.uniqueResult();
		
		return count;
	}
	
	@Override
	public List<Object[]> findExcellentStaff() {
		Session session = sessionFactory.getCurrentSession();

		StringBuffer hql = new StringBuffer("SELECT r.staff.id, r.staff.name, SUM(case when r.type=1 then 1 else 0 end) AS a, ");
		hql.append("SUM(case when r.type = 0 then 1 else 0 end), r.staff.photo FROM Record r ");
		hql.append("GROUP BY r.staff.id, r.staff.name, r.staff.photo ");
		hql.append("HAVING (SUM(case when r.type=1 then 1 else 0 end) - SUM(case when r.type = 0 then 1 else 0 end)) > 0 ");
		hql.append("ORDER BY  a DESC ");
		
		Query query = session.createQuery(hql.toString());
		query.setMaxResults(10);
		
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();

		return list;
	}
	
	@Override
	public List<Object[]> findExcellentStaffByYear(Integer year) {
		Session session = sessionFactory.getCurrentSession();

		StringBuffer hql = new StringBuffer("SELECT r.staff.id, r.staff.name, SUM(case when r.type=1 then 1 else 0 end) AS a, ");
		hql.append("SUM(case when r.type = 0 then 1 else 0 end), r.staff.photo FROM Record r WHERE year(r.date) = :year ");
		hql.append("GROUP BY r.staff.id, r.staff.name, r.staff.photo ");
		hql.append("HAVING (SUM(case when r.type=1 then 1 else 0 end) - SUM(case when r.type = 0 then 1 else 0 end)) > 0 ");
		hql.append("ORDER BY  a DESC ");
		
		Query query = session.createQuery(hql.toString());
		query.setParameter("year", year);
		query.setMaxResults(10);
		
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();

		return list;
	}
	
	@Override
	public List<Object[]> findAllDepartReport(Integer offset, Integer limit) {
		Session session = sessionFactory.getCurrentSession();

		StringBuffer hql = new StringBuffer("SELECT	d.id, d.name, SUM(case when r.type=1 then 1 else 0 end), ");
		hql.append("SUM(case when r.type=0 then 1 else 0 end) FROM Record r JOIN r.staff s JOIN s.depart d ");
		hql.append("GROUP BY d.id, d.name");

		Query query = session.createQuery(hql.toString());
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();

		return list;
	}
	
	@Override
	public List<Object[]> findAllDepartReportByYear(Integer year, Integer offset, Integer limit) {
		Session session = sessionFactory.getCurrentSession();

		StringBuffer hql = new StringBuffer("SELECT	d.id, d.name, SUM(case when r.type=1 then 1 else 0 end), ");
		hql.append("SUM(case when r.type=0 then 1 else 0 end) FROM Record r JOIN r.staff s JOIN s.depart d ");
		hql.append("WHERE year(r.date) = :year GROUP BY d.id, d.name");

		Query query = session.createQuery(hql.toString());
		query.setParameter("year", year);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();

		return list;
	}
	
	@Override
	public Long getTotalDepartReportItems() {
		Session session = sessionFactory.getCurrentSession();

		String hql = "SELECT count(DISTINCT s.depart.id) FROM Record r, Staff s";
		
		Long count = (Long) session.createQuery(hql).uniqueResult();
		
		return count;
	}
	
	@Override
	public Long getTotalDepartReportItemsByYear(Integer year) {
		Session session = sessionFactory.openSession();

		String hql = "SELECT count(DISTINCT s.depart.id) FROM Record r, Staff s WHERE year(r.date) = :year";
			
		Query query = session.createQuery(hql);
		query.setParameter("year", year);
			
		Long count = (Long) query.uniqueResult();
		
		session.close();
		
		return count;
	}
	
	@Override
	public Record findOne(Long id) {
		Session session = sessionFactory.openSession();
		
		Record record = (Record) session.get(Record.class, id);
		
		session.close();
		
		return record;
	}

	@Override
	public boolean saveOrUpdate(Record record) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			record.setDate(new Date(System.currentTimeMillis()));
			session.saveOrUpdate(record);
			
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
	public boolean delete(Long id) {
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
