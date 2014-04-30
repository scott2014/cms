package com.cms.model.dao.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cms.model.dao.UserMedicinalDAO;
import com.cms.model.entity.UserMedicinal;

@Repository("userMedicinalDAO")
public class UserMedicinalDAOImpl implements UserMedicinalDAO {
	
	@Autowired
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	public void save(UserMedicinal um) {
		this.hibernateTemplate.save(um);
	}

	public void del(UserMedicinal um) {
		this.hibernateTemplate.delete(um);
	}

	public void update(UserMedicinal um) {
		this.hibernateTemplate.update(um);
	}

	public UserMedicinal findById(long id) {
		return this.hibernateTemplate.get(UserMedicinal.class, id);
	}

}