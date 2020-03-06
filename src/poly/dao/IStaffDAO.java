package poly.dao;

import java.util.List;

import poly.entity.Staff;

public interface IStaffDAO {

	public List<Staff> findAll();
	
	public List<Staff> findAll(Integer offset, Integer limit);
	
	public List<Staff> searchStaff(String key, Integer offset, Integer limit);
	
	public Long getTotalItems();
	
	public Long getTotalItemsByKey(String key);
	
	public Staff findOne(String id);
	
	public boolean saveOrUpdate(Staff staff);
	
	public boolean delete(String id);
	
}
