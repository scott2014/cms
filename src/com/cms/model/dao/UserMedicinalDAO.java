package com.cms.model.dao;

import java.util.List;

import com.cms.model.entity.UserMedicinal;

public interface UserMedicinalDAO {
	public void save(UserMedicinal um);
	
	public void del(UserMedicinal um);
	
	public void update(UserMedicinal um);
	
	public UserMedicinal findById(long id);
	
	public List<UserMedicinal> findAll();
}
