package com.cms.model.dao;

import java.util.List;

import com.cms.model.entity.UserMedicinal;

public interface UserMedicinalDAO {
	public void save(UserMedicinal um);
	
	public void del(UserMedicinal um);
	
	public void update(UserMedicinal um);
	
	public UserMedicinal findById(long id);
	
	public List<UserMedicinal> findAll();
	
	public List<UserMedicinal> findByAppId(long appId);
	
	public List<UserMedicinal> findByRightCode(int rightCode);
	
	public List<UserMedicinal> find(long userId,int status);
	
	public List<UserMedicinal> findByMId(long mid);
	
	public List<UserMedicinal> findByUserId(long userId);
}
