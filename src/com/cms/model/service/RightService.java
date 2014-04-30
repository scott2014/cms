package com.cms.model.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cms.model.dao.RightDAO;
import com.cms.model.entity.Right;

@Service("rightService")
public class RightService {

	@Autowired
	@Resource(name="rightDAO")
	private RightDAO rightDAO;
	
	@Transactional
	public void save(Right right) {
		this.rightDAO.save(right);
	}
	
	public Right findById(int id) {
		return this.rightDAO.findById(id);
	}
	
}
