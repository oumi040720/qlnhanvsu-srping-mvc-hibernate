package poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import poly.dao.IUserDAO;
import poly.entity.User;
import poly.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserDAO userDAO;
	
	@Override
	@Transactional
	public List<User> findAll(Integer offset, Integer limit) {
		return userDAO.findAll(offset, limit);
	}

	@Override
	@Transactional
	public Long getTotalItems() {
		return userDAO.getTotalItems();
	}
	
	@Override
	@Transactional
	public boolean checkLogin(String username, String password) {
		return userDAO.checkLogin(username, password);
	}
	
	@Override
	@Transactional
	public User findOne(String username) {
		return userDAO.findOne(username);
	}

	@Override
	@Transactional
	public boolean saveOrUpdate(User user) {
		return userDAO.saveOrUpdate(user);
	}

	@Override
	@Transactional
	public boolean delete(String username) {
		return userDAO.delete(username);
	}

}
