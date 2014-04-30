package com.cms.model.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cms.model.dao.UserDAO;
import com.cms.model.entity.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	public void save(User user) {
		this.hibernateTemplate.save(user);
	}

	public void del(User user) {
		
	}

	public void update(User user) {
		this.hibernateTemplate.update(user);
	}

	public User findById(long id) {
		return this.hibernateTemplate.get(User.class, id);
	}

	public void delById(long id) {
		// TODO Auto-generated method stub
		
	}

	public List<User> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public User findByUsername(String username) {
		String hql = "from User where username=?";
		List<User> result = this.hibernateTemplate.find(hql,username);
		return result != null && result.size() > 0 ? result.get(0) : null;
	}

	public User checkUser(String username, String password) {
		String hql = "from User where username=? and password=?";
		List<User> result = this.hibernateTemplate.find(hql,username,password);
		return result != null && result.size() > 0 ? result.get(0) : null;
	}
	
}
