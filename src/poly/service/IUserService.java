package poly.service;

import java.util.List;

import poly.entity.User;

public interface IUserService {

	public List<User> findAll(Integer offset, Integer limit);
	
	public Long getTotalItems();
	
	public boolean checkLogin(String username, String password);
	
	public User findOne(String username);
	
	public boolean saveOrUpdate(User user);
	
	public boolean delete(String username);
	
}
