package com.cms.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cms.model.constant.UserRight;
import com.cms.model.dao.UserDAO;
import com.cms.model.dao.UserMedicinalDAO;
import com.cms.model.entity.Right;
import com.cms.model.entity.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	@Resource(name="userMedicinalDAO")
	private UserMedicinalDAO userMedicinalDAO;
	
	@Autowired
	@Resource(name="userDAO")
	private UserDAO userDAO;
	
	public void save(User user) {
		this.hibernateTemplate.save(user);
	}

	public void del(User user) {
		this.hibernateTemplate.delete(user);
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
		return this.hibernateTemplate.loadAll(User.class);
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
	
	public List<User> findByRightCode(int rightCode,int pageSize,int pageNum) {
		List<User> users = this.userDAO.loadAll();
		
		List<User> result = new ArrayList<User>();
		
		for (User user : users) {
			List<Right> rights = user.getRights();
			for (Right r : rights) {
				if (r.getRightCode() == UserRight.STUDENT) {
					result.add(user);
				}
			}
		}
		
		List<User> res = new ArrayList<User>();
		if (result.size() > 0) {
			int max = (pageNum - 1) * pageSize + pageSize > result.size() ? result.size() :  (pageNum - 1) * pageSize + pageSize;
			for (int i=(pageNum - 1) * pageSize;i<max;i++) {
				res.add(result.get(i));
			}
		}
		
		return res;
	}
	
	public int countByRightCode(int rightCode) {
		List<User> users = this.userDAO.loadAll();
		
		List<User> result = new ArrayList<User>();
		
		for (User user : users) {
			List<Right> rights = user.getRights();
			for (Right r : rights) {
				if (r.getRightCode() == UserRight.STUDENT) {
					result.add(user);
				}
			}
		}
		
		return result.size();
	}
}
