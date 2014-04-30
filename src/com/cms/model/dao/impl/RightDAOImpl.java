package com.cms.model.dao.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cms.model.dao.RightDAO;
import com.cms.model.entity.Right;

@Repository("rightDAO")
public class RightDAOImpl implements RightDAO {
	
	@Autowired
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	public void save(Right right) {
		this.hibernateTemplate.save(right);
	}

	public void del(Right right) {
		this.hibernateTemplate.delete(right);
	}

	public void update(Right right) {
		this.hibernateTemplate.update(right);
	}

	public Right findById(int id) {
		return hibernateTemplate.get(Right.class, id);
	}

	public void delById(int id) {
		Right  r = this.findById(id);
		this.del(r);
	}

}
