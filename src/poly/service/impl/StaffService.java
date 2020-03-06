package poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poly.dao.IStaffDAO;
import poly.entity.Staff;
import poly.service.IStaffService;

@Service
public class StaffService implements IStaffService {

	@Autowired
	IStaffDAO staffDAO;

	@Override
	@Transactional
	public List<Staff> findAll() {
		return staffDAO.findAll();
	}

	@Override
	@Transactional
	public List<Staff> findAll(Integer offset, Integer limit) {
		return staffDAO.findAll(offset, limit);
	}

	@Override
	@Transactional
	public List<Staff> searchStaff(String key, Integer offset, Integer limit) {
		return staffDAO.searchStaff(key, offset, limit);
	}

	@Override
	@Transactional
	public Long getTotalItems() {
		return staffDAO.getTotalItems();
	}

	@Override
	@Transactional
	public Long getTotalItemsByKey(String key) {
		return staffDAO.getTotalItemsByKey(key);
	}
	
	@Override
	@Transactional
	public Staff findOne(String id) {
		return staffDAO.findOne(id);
	}

	@Override
	@Transactional
	public boolean saveOrUpdate(Staff staff) {
		return staffDAO.saveOrUpdate(staff);
	}

	@Override
	@Transactional
	public boolean delete(String id) {
		return staffDAO.delete(id);
	}

}
