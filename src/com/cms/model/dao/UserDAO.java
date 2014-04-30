package com.cms.model.dao;

import java.util.List;

import com.cms.model.entity.User;

public interface UserDAO {
	public void save(User user);

	public void del(User user);

	public void update(User user);

	public User findById(long id);

	public void delById(long id);

	public List<User> loadAll();
	
	//通过用户名查找
	public User findByUsername(String username);
	
	public User checkUser(String username,String password);
}
