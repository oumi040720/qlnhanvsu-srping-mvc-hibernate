package poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poly.dao.IDepartDAO;
import poly.entity.Depart;
import poly.service.IDepartService;

@Service
public class DepartService implements IDepartService {

	@Autowired
	IDepartDAO departDAO;
	
	@Override
	public List<Depart> findAll() {
		return departDAO.findAll();
	}
	
	@Override
	@Transactional
	public List<Depart> findAll(Integer offset, Integer limit) {
		return departDAO.findAll(offset, limit);
	}

	@Override
	@Transactional
	public Long getTotalItems() {
		return departDAO.getTotalItems();
	}
	
	@Override
	@Transactional
	public Depart findOne(String id) {
		return departDAO.findOne(id);
	}

	@Override
	@Transactional
	public boolean saveOrUpdate(Depart depart) {
		return departDAO.saveOrUpdate(depart);
	}

	@Override
	@Transactional
	public boolean delete(String id) {
		return departDAO.delete(id);
	}

}
