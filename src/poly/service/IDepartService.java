package poly.service;

import java.util.List;

import poly.entity.Depart;

public interface IDepartService {

	public List<Depart> findAll();
	
	public List<Depart> findAll(Integer offset, Integer limit);
	
	public Long getTotalItems();
	
	public Depart findOne(String id);
	
	public boolean saveOrUpdate(Depart depart);
	
	public boolean delete(String id);
	
}
