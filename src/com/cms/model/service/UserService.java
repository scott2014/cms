package com.cms.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cms.model.dao.UserDAO;
import com.cms.model.entity.User;

@Service("userService")
public class UserService {
	
	@Autowired
	@Resource(name="userDAO")
	private UserDAO userDAO;
	
	@Transactional
	public void save(User user) {
		this.userDAO.save(user);
	}
	
	@Transactional
	public boolean exist(String username) {
		return this.userDAO.findByUsername(username) != null;
	}
	
	@Transactional
	public User checkUser(String username,String password) {
		return this.userDAO.checkUser(username, password);
	}
	
	@Transactional
	public User findById(long id) {
		return this.userDAO.findById(id);
	}
	
	@Transactional
	public List<User> findAll() {
		return this.userDAO.loadAll();
	}
}
