package com.cms.model.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cms.model.dao.UserMedicinalDAO;
import com.cms.model.entity.UserMedicinal;

@Service("userMedicinalService")
public class UserMedicinalService {
	
	@Autowired
	@Resource(name="userMedicinalDAO")
	private UserMedicinalDAO userMedicinalDAO;
	
	@Transactional
	public void save(UserMedicinal um) {
		this.userMedicinalDAO.save(um);
	}
	
	@Transactional
	public void update(UserMedicinal um) {
		this.userMedicinalDAO.update(um);
	}
}
